package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Error the import javax.servlet cannot be resolved
// solucion: https://stackoverflow.com/questions/4119448/the-import-javax-servlet-cant-be-resolved
// Donde econtrar servet api.jar http://es.uwenku.com/question/p-dfvukhbm-o.html
import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import javax.servlet.http.HttpSession;

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
		HttpSession sessionMensaje = request.getSession();  
		
		boolean usuarioEncontrado = false;
		
		if(request.getParameter("btnLogin") != null) {
			Usuario u = new Usuario();
			u.setNombreUsuario(request.getParameter("txtNombreUsuario"));
			u.setContrasenia(request.getParameter("txtContrasenia"));
			
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			try {
				
				usuarioEncontrado = udao.buscarUsuario(u); //Envio el nombre y contrasenia y hago un where en la bd si coinciden lo traigo
				//buscarUsuario devuelve un boolean
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		if(usuarioEncontrado) { //Si es true
			sessionMensaje.setAttribute("mensaje","Usuario correcto"); //Guarda en session el mensaje para el usuario
			request.setAttribute("tipoMensaje","succes");
		}
		else {
			sessionMensaje.setAttribute("mensaje","Usuario no encontrado");
			request.setAttribute("tipoMensaje","danger"); 
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request,response);
	}

}
