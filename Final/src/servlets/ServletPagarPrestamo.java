package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class ServletPagarPrestamo
 */
@WebServlet("/ServletPagarPrestamo")
public class ServletPagarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteNegocio cliNeg = new ClienteNegocioImpl();

	public ServletPagarPrestamo() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (cliNeg.validarUsuarioCliente(request)) {

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

		} else {
			response.sendRedirect("Login.jsp");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamos.jsp");
		rd.forward(request, response);

	}

}
