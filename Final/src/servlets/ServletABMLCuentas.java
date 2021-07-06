package servlets;

import java.io.IOException;
import java.math.BigDecimal;
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
		asignarCuenta(request);

		cargarCuentas(request);
		cargarDropdown(request);
		cargarClientesDatalist(request);
		modificarCuenta(request);

		RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
		rd.forward(request, response);
	}

	// *----------------------METODOS-------------------------*//

	private void asignarCuenta(HttpServletRequest request) {
		if (request.getAttribute("accion")!=null && "asignar".equals(request.getAttribute("accion"))) {
			Cuenta c = devolverCuentaCargada(request);
			request.setAttribute("inputNroCuenta", null);
			request.setAttribute("inputCBU", null);
			request.setAttribute("inputSaldo", null);
			request.setAttribute("DropdownTipoCuenta", null);
			request.setAttribute("dniCli", null);
			if (admNeg.asignarCuenta(Long.parseLong(c.getNumeroCuenta()), c.getDNI())) {
				request.setAttribute("msjTituloModal", "EXITO");
				request.setAttribute("msjModal", "La Cuenta ha sido asignada correctamente");
			} else {
				request.setAttribute("msjTituloModal", "ERROR");
				request.setAttribute("msjModal", "La Cuenta no se pudo asignar");
			}
		}

	}

	private void modificarCuenta(HttpServletRequest request) {
		if (request.getAttribute("btnModificarCuenta") != null) {
			String numeroCuenta = request.getParameter("nroCuenta");
			Cuenta cuenta = admNeg.traerCuenta(Long.valueOf(numeroCuenta));
			request.setAttribute("inputNroCuenta", cuenta.getNumeroCuenta());
			request.setAttribute("inputCBU", cuenta.getCBU());
			request.setAttribute("inputSaldo", cuenta.getSaldo());
			request.setAttribute("DropdownTipoCuenta", cuenta.getTipoDeCuenta().getIdTipoCuenta());
			request.setAttribute("dniCli", cuenta.getDNI());
		}
	}

	private void agregarCuenta(HttpServletRequest request) {
		if (request.getAttribute("accion")!=null && "agregar".equals(request.getAttribute("accion"))) {
			Cuenta cuenta = devolverCuentaCargada(request);
			if (admNeg.validarCamposCuentaNoVacia(cuenta)) {
				if (cuenta.getDNI() != 0) {
					if (admNeg.validarDNIExistente(Integer.valueOf(cuenta.getDNI()))) {
						if (!admNeg.validarCuentaExistente(Long.parseLong(cuenta.getNumeroCuenta()))) {
							agregarCuenta(request, cuenta);
							admNeg.MovimientoDeAlta(cuenta);
						} else {
							request.setAttribute("msjTituloModal", "ERROR");
							request.setAttribute("msjModal", "La Cuenta que intenta crear ya existe");
						}
					} else {
						request.setAttribute("msjTituloModal", "ERROR");
						request.setAttribute("msjModal", "El DNI ingresado no corresponde a un Cliente");
					}
				} else {
					agregarCuenta(request, cuenta);
				}
			} else {
				request.setAttribute("msjTituloModal", "ADVERTENCIA");
				request.setAttribute("msjModal", "Hay campos sin completar!!.");
			}
		}
	}

	private Cuenta devolverCuentaCargada(HttpServletRequest request) {
		Cuenta cuenta = new Cuenta();
		cuenta.setCBU(request.getParameter("inputCBU"));
		if (request.getParameter("dniCli") != "")
			cuenta.setDNI(Integer.valueOf(request.getParameter("dniCli")));
		cuenta.setNumeroCuenta(request.getParameter("inputNroCuenta"));

		cuenta.setTipoDeCuenta(new TipoDeCuenta(Short.valueOf(request.getParameter("DropdownTipoCuenta")), "."));

		cuenta.setSaldo(new BigDecimal(request.getParameter("inputSaldo")));

		return cuenta;
	}

	private void agregarCuenta(HttpServletRequest request, Cuenta cuenta) {
		if (admNeg.AgregarCuenta(cuenta)) {

			request.setAttribute("msjTituloModal", "Carga exitosa");
			request.setAttribute("msjModal", "La cuenta se ha agregado exitosamente.");
			limpiarCampos();
		} else {
			request.setAttribute("msjTituloModal", "ERROR");
			request.setAttribute("msjModal", "No se pudo crear la Cuenta en base de datos.");
		}
	}

	private void limpiarCampos() {

	}

	private void eliminarCuenta(HttpServletRequest request) {
		if (request.getParameter("btnEliminarCuenta") != null) {

			String numeroCuenta = request.getParameter("nroCuenta");
			admNeg.eliminarCuenta(Long.parseLong(numeroCuenta));
		}
	}

	private void cargarDropdown(HttpServletRequest request) {
		ArrayList<TipoDeCuenta> listaTiposCta = admNeg.listarTiposCuenta();
		listaTiposCta.add(0, new TipoDeCuenta((short) 0, "Tipo de Cuenta"));
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

	// Validaciones para cuenta

	public Boolean campoVacio(Cuenta c) {
		Boolean formatovalido = true;
		if (c.getCBU().isEmpty()) {
			formatovalido = false;
		}
		if (c.getNumeroCuenta().isEmpty()) {
			formatovalido = false;
		}
		if (c.getTipoDeCuenta().getIdTipoCuenta() == 0) {
			formatovalido = false;
		}
		return formatovalido;
	}

}
