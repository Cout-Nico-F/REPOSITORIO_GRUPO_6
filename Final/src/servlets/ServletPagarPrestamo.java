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

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Cuota;
import entidad.Prestamo;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocio.IPrestamoNegocio;
import negocio.MovimientoNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;

/**
 * Servlet implementation class ServletPagarPrestamo
 */
@WebServlet("/ServletPagarPrestamo")
public class ServletPagarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Prestamo> listaPrestamos;
	private ArrayList<Cuenta> listaCuentas;
	private ClienteNegocio cliNeg = new ClienteNegocioImpl();
	private IPrestamoNegocio preNeg = new PrestamoNegocioImpl();
	private IAdminNegocio admNeg = new AdminNegocioImpl();
	private MovimientoNegocio movNeg = new MovimientoNegocioImpl();
	private int cantidadCuotasAMostrar = 3;

	public ServletPagarPrestamo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (cliNeg.validarUsuarioCliente(request)) {
			cargarPrestamos(request);
			cargarSaldos(request);
			cargarCuentasUsuario(request);
			pagarPrestamo(request);
		} else {
			response.sendRedirect("Login.jsp");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamos.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (cliNeg.validarUsuarioCliente(request)) {
			cargarPrestamos(request);
			cargarSaldos(request);
			cargarCuentasUsuario(request);

		} else {
			response.sendRedirect("Login.jsp");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamos.jsp");
		rd.forward(request, response);

	}

	//////////////// -------------------------//////////////////////

	private void cargarSaldos(HttpServletRequest request) {
		request.setAttribute("listaSaldos", preNeg.cargarSaldos(listaPrestamos));
	}

	private void cargarPrestamos(HttpServletRequest request) {
		String nombreUsuario = String.valueOf(request.getSession().getAttribute("nombreUsuarioLogeado"));
		Cliente cli = cliNeg.traerClientePorNombreUsuario(nombreUsuario);
		listaPrestamos = cliNeg.listarPrestamosPorCliente(cli.getDni());
		ArrayList<Prestamo> listaPrestAux = new ArrayList<Prestamo>();
		Prestamo prestamo = new Prestamo();
		for (Prestamo p : listaPrestamos) {
			ArrayList<Cuota> listaCuotas = p.getListaCuotas();
			int numeroCuotasMostradas = cantidadCuotasAMostrar;
			if (listaCuotas.size() < cantidadCuotasAMostrar) { // Si el tamaño de la lista es menor a la cant. de cuotas
																// que se quiere mostrar,
				numeroCuotasMostradas = listaCuotas.size(); // en la línea 96 le recortamos hasta el tamaño de la lista.
			}
			listaCuotas = new ArrayList<Cuota>(listaCuotas.subList(0, numeroCuotasMostradas));
			prestamo = new Prestamo(p.getIdPrestamo(), p.getCliente(), p.getCuenta(), p.getFechaSQL(),
					p.getImporteSolicitado(), p.getImporteAPagar(), p.getMontoMensual(), p.getCuotas(), p.getEstado(),
					listaCuotas);
			prestamo.setListaCuotas(listaCuotas);
			listaPrestAux.add(prestamo);
		}
		request.setAttribute("listaPrestAux", listaPrestAux);
	}

	private void cargarCuentasUsuario(HttpServletRequest request) {
		String nombreUsuario = String.valueOf(request.getSession().getAttribute("nombreUsuarioLogeado"));
		Cliente cli = cliNeg.traerClientePorNombreUsuario(nombreUsuario);
		listaCuentas = admNeg.listarCuentas(cli.getDni());

		request.setAttribute("listaCtasUsuario", listaCuentas);
		if (request.getParameter("cuentaSelecc") != null) {
			Cuenta c = preNeg.buscarCuenta(listaCuentas, String.valueOf(request.getParameter("cuentaSelecc")));
			request.setAttribute("cuentaSeleccionada", c);
		}
	}

	// 1 Checkear los checkbox seleccionados
	// 2 Verificar el saldo disponible
	// 3 Actualizar saldo
	// 4 Registrar nmovimiento
	// 5 Actualizar estado de prestamo
	private void pagarPrestamo(HttpServletRequest request) {
		if (request.getParameter("btnPagar") != null) {
			ArrayList<Prestamo> listaPrestamosScope = validarInputSaldo(request);
			for (Prestamo p : listaPrestamosScope) {
				ArrayList<Cuota> listaCuotas = p.getListaCuotas();
				if (listaCuotas.size() > 0) {
					for (Cuota c : listaCuotas) {
						if (movNeg.validarFondosSuficientes(String.valueOf(request.getParameter("cuentaSelecc")), c.getImporte())) {
							movNeg.
						}
					}
				} else {
					request.setAttribute("msjModal", "No tiene fondos suficientes para pagar las cuotas seleccionadas.");
				}

			}
		}

	}

	private ArrayList<Prestamo> validarInputSaldo(HttpServletRequest request) {
		BigDecimal totalAPagar = new BigDecimal(0);
		ArrayList<Prestamo> listaAux = (ArrayList<Prestamo>) request.getAttribute("listaPrestAux");
		for (Prestamo p : listaAux) {
			ArrayList<Cuota> listaCuotas = p.getListaCuotas();
			int indexPrestamo = listaPrestamos.indexOf(p);
			for (Cuota c : listaCuotas) {
				int indexCuota = listaCuotas.indexOf(c);
				if (request.getParameter("cbPrestamo" + indexPrestamo + indexCuota) != null) {
					totalAPagar.add(c.getImporte());
				} else {
					listaAux.get(indexPrestamo).getListaCuotas().remove(c);
				}
			}
		}
		Cuenta cuentaSeleccionada = (Cuenta)(request.getAttribute("cuentaSeleccionada"));
		if (cuentaSeleccionada.getSaldo().subtract(totalAPagar).compareTo(BigDecimal.ZERO) >= 0) {
			return listaAux;
		}
		return new ArrayList<Prestamo>();
	}

}
