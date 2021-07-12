package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.TipoDeCuenta;
import entidad.VistaAdmin;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocio.MovimientoNegocio;
import negocio.VistaAdminNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.VistaAdminNegocioImpl;


@WebServlet("/ServletVistaAdmin")
public class ServletVistaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminNegocio admNeg = new AdminNegocioImpl();
	private VistaAdminNegocio vaNeg = new VistaAdminNegocioImpl();
	private ClienteNegocio cNeg = new ClienteNegocioImpl();
	private MovimientoNegocio movNeg = new MovimientoNegocioImpl();

    public ServletVistaAdmin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (admNeg.validarUsuarioAdmin(request)) {
			
			int contadorClientes = vaNeg.contadorClientes();
			int contadorSolicitudes = vaNeg.contadorDeSolicitudesDePrestamos();
			int contadorPrestamosRechazados = vaNeg.contadorDePrestamosRechazados();
			ArrayList<Cliente> listaClientes = cNeg.traerClientes();
			
			request.setAttribute("CantidadDeClientes", contadorClientes);
			request.setAttribute("CantidadDeSolicitudes", contadorSolicitudes);
			request.setAttribute("CantidadDePrestamosRechazados", contadorPrestamosRechazados);
			request.setAttribute("listaClientes", listaClientes);
			
			if(request.getParameter("btnDniusuario") != null) {
				int dni = Integer.parseInt(request.getParameter("btnDniusuario")); //Hago un parse porque ese request es String
				ArrayList<VistaAdmin> listaVistaAdmin = vaNeg.traerDatoVistaAdminSegunDni(dni);
				
				request.setAttribute("listaCuentasUsuario", listaVistaAdmin);
			}
			
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
