package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;


@WebServlet("/ServletDatosPersonales")
public class ServletDatosPersonales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteNegocio cNeg = new ClienteNegocioImpl();

    public ServletDatosPersonales() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//OJO: yo lo tenia en el post pero pasa por el get primero me olvide de eso
	if(cNeg.validarUsuarioCliente(request)) {
			
			String nombreUsuario = (String)request.getSession().getAttribute("nombreUsuarioLogeado");
			Cliente cli = cNeg.traerClientePorNombreUsuario(nombreUsuario); 
			request.setAttribute("DatosCliente", cli);
			 
		} else {
			response.sendRedirect("Login.jsp");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/DatosPersonales.jsp");
		rd.forward(request, response);

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
