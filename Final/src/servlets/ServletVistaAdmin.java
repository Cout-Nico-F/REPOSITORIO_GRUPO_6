package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;


@WebServlet("/ServletVistaAdmin")
public class ServletVistaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminNegocio admNeg = new AdminNegocioImpl();

    public ServletVistaAdmin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (admNeg.validarUsuarioAdmin(request)) {
			//Acá adentro el código si está logueado
			
			
			
			
			
			
			//Acá adentro el código si está logueado
		}else {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/VistaAdmin.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (admNeg.validarUsuarioAdmin(request)) {
			//Acá adentro el código si está logueado
			
			
			
			
			
			
			//Acá adentro el código si está logueado
		}else {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/VistaAdmin.jsp");
		rd.forward(request, response);

	}

}
