package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;

/**
 * Servlet implementation class ServletAutorizarPrestamos
 */
@WebServlet("/ServletAutorizarPrestamos")
public class ServletAutorizarPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminNegocio admNeg = new AdminNegocioImpl();
       

    public ServletAutorizarPrestamos() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
