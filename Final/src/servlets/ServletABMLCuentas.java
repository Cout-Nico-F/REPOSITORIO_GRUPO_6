package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import entidad.VariablesGlobales;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/ServletABMLCuentas")
public class ServletABMLCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminNegocio admNeg = new AdminNegocioImpl();
	private ClienteNegocio cliNeg = new ClienteNegocioImpl();

	public ServletABMLCuentas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		cargarCuentas(request);
		cargarDropdown(request);
		cargarClientesDatalist(request);
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		eliminarCuenta(request);
		agregarCuenta(request);

		cargarCuentas(request);
		cargarDropdown(request);
		cargarClientesDatalist(request);
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
		rd.forward(request, response);

	}

	
	
	
	
	
	// *----------------------METODOS-------------------------*//

	
	private void agregarCuenta(HttpServletRequest request) {
		if (request.getParameter("btnRegistrar") != null) {
			Cuenta cuenta = new Cuenta();
			cuenta.setCBU(request.getParameter("inputCBU"));
			cuenta.setDNI(Integer.valueOf(request.getParameter("dniCli")));
			cuenta.setNumeroCuenta(request.getParameter("inputNroCuenta"));
			System.out.println(request.getParameter("DropdownTipoCuenta"));
			cuenta.setTipoDeCuenta(new TipoDeCuenta(Short.valueOf(request.getParameter("DropdownTipoCuenta")),"."));	
			cuenta.setSaldo(VariablesGlobales.saldoInicial);
			
			if(admNeg.validarCamposCuentaNoVacia(cuenta)){
				if(admNeg.validarDNIExistente(cuenta.getDNI())){
					if(admNeg.AgregarCuenta(cuenta)) {
						request.setAttribute("msjTituloModal", "Carga exitosa");
						request.setAttribute("msjModal", "La cuenta se ha agregado exitosamente.");
						limpiarCampos();
					} else {
						request.setAttribute("msjTituloModal", "ERROR");
						request.setAttribute("msjModal", "No se pudo crear la Cuenta en base de datos.");
					}
				} else {
					request.setAttribute("msjTituloModal", "ERROR");
					request.setAttribute("msjModal", "El DNI ingresado no corresponde a un Cliente");					JOptionPane.showMessageDialog(null, "ERROR. El DNI ingresado no es un Cliente.");
				}
			} else {
				request.setAttribute("msjTituloModal", "ADVERTENCIA");
				request.setAttribute("msjModal", "Hay campos sin completar!!.");				JOptionPane.showMessageDialog(null, "ERROR. Hay campos sin completar o con formato no v�lido.");
			}
		}
	}
	
	
	private void limpiarCampos() {
		
	}

	private void eliminarCuenta(HttpServletRequest request) {
		if (request.getParameter("btnEliminarCuenta") != null) {

			String numeroCuenta = request.getParameter("nroCuenta");
			admNeg.eliminarCuenta(Long.parseLong(numeroCuenta));
			System.out.println(numeroCuenta);
		}
	}

	private void cargarDropdown(HttpServletRequest request) {
		ArrayList<TipoDeCuenta> listaTiposCta = admNeg.listarTiposCuenta();
		listaTiposCta.add(0, new TipoDeCuenta((short)0,"Tipo de Cuenta"));
		request.setAttribute("listaTiposCta", listaTiposCta);
	}

	private void cargarClientesDatalist(HttpServletRequest request) {
		ArrayList<Cliente> listaClientes = cliNeg.traerClientes(VariablesGlobales.cantMaxCuentasPorCliente);
		request.setAttribute("listaClientes", listaClientes);
	}

	private void cargarCuentas(HttpServletRequest request) {
		ArrayList<Cuenta> listaCuentas = admNeg.listarCuentas();
		request.setAttribute("listaCuentas", listaCuentas);

		ArrayList<Cliente> listaClientesDeCuentas = new ArrayList<Cliente>();
		for (Cuenta cuenta : listaCuentas) {
			listaClientesDeCuentas.add(admNeg.buscarCliente(cuenta.getDNI()));
		}
		request.setAttribute("listaClientesDeCuentas", listaClientesDeCuentas);
	}
}
