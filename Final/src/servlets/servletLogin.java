package servlets;

import java.io.IOException;
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
import entidad.Usuario;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;


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
		HttpSession sessionUsuario = request.getSession();
				
		UsuarioNegocio uNeg = new UsuarioNegocioImpl();
		Usuario u = new Usuario();
		
		if(request.getParameter("btnLogin") != null) {
			u = new Usuario();
			u.setNombreUsuario(request.getParameter("txtNombreUsuario"));
			u.setContrasenia(request.getParameter("txtContrasenia"));
			
			u = uNeg.buscarUsuario(u);			
						
			if(u != null) {//si no es null es porque la conexion no falló
				
				if (u.getNombreUsuario().equals("")) { //si vino vacío es que no lo encontró.
					sessionMensaje.setAttribute("mensaje","Usuario no encontrado");
					request.setAttribute("tipoMensaje","danger"); 
					
				} else {
					sessionMensaje.setAttribute("mensaje","Usuario correcto"); //Guarda en session el mensaje para el usuario
					request.setAttribute("tipoMensaje","success");
					
					sessionUsuario.setAttribute("tipoUsuarioLogeado", u.getTipoUsuario());
					sessionUsuario.setAttribute("nombreUsuarioLogeado", u.getNombreUsuario());
				}				
			}					
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request,response);
			return;
		}
		
		if(request.getParameter("btnCerrarSesion") != null) {
			sessionUsuario.removeAttribute("tipoUsuarioLogeado");
			sessionUsuario.removeAttribute("nombreUsuarioLogeado");
			
			return;
		}
		
		if(request.getParameter("btnIniciarSesion") != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request,response);
			return;
		}
		
	}
}
