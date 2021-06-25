package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionMensaje =request.getSession();  
		
		boolean usuarioEncontrado;
		if(request.getParameter("btnLogin") != null) {
			Usuario u = new Usuario();
			u.setNombreUsuario(request.getParameter("txtNombreUsuario"));
			u.setContrasenia(request.getParameter("txtContrasenia"));
			
			UsuarioDao udao = new UsuarioDao();
			usuarioEncontrado = traerUsuario(u); //Envio el nombre y contrasenia y hago un where en la bd si coinciden lo traigo
			//Traer usuario devuelve un boolean
		}
		if(usuarioEncontrado) { //Si es true
			session.setAtrribute("mensaje","Usuario correcto");
			request.setAtrribute("tipoMensaje","succes");
		}
		else {
			session.setAtrribute("mensaje","Usuario no encontrado");
			request.setAtrribute("tipoMensaje","danger"); 
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request,response);
	}

}
