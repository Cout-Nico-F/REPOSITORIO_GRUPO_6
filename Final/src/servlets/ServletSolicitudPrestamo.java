package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Prestamo;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocio.IPrestamoNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;

@WebServlet("/SolicitudPrestamo")
public class ServletSolicitudPrestamo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClienteNegocio cliNeg = new ClienteNegocioImpl();
	private IPrestamoNegocio preNeg = new PrestamoNegocioImpl();
	private IAdminNegocio admNeg = new AdminNegocioImpl();
	private String nombreUsuario;
	private Cliente cli;
	
	public ServletSolicitudPrestamo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (cliNeg.validarUsuarioCliente(request)) {
		nombreUsuario = String.valueOf(request.getSession().getAttribute("nombreUsuarioLogeado"));
		cli = cliNeg.traerClientePorNombreUsuario(nombreUsuario);
		request.setAttribute("cuentas", admNeg.listarCuentas(cli.getDni()));
		RequestDispatcher rd = request.getRequestDispatcher("/SolicitudPrestamo.jsp");
		rd.forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (cliNeg.validarUsuarioCliente(request)) {
			String mensaje;
			Prestamo p = new Prestamo();
			p.setCuenta(new Cuenta(request.getParameter("cuenta")));
			p.setCliente(new Cliente(cli.getDni()));
			p.setImporteSolicitado(new BigDecimal(request.getParameter("solicitado")));
			p.setImporteAPagar(new BigDecimal(request.getParameter("total")));
			p.setMontoMensual(new BigDecimal(request.getParameter("mensual")));
			p.setCuotas(Short.valueOf(request.getParameter("cuotas")));
			if (preNeg.registrarPrestamo(p)) {
				mensaje = "El préstamo se ha solicitado con éxito";
			} else {
				mensaje = "Hubo un error al solicitar el préstamo. Por favor, intente más tarde";
			}
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("cuentas", admNeg.listarCuentas(cli.getDni()));
			RequestDispatcher rd = request.getRequestDispatcher("/SolicitudPrestamo.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
	}
}
