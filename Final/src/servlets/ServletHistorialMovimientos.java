package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoDeCuenta;
import negocio.ClienteNegocio;
import negocio.MovimientoNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

@WebServlet("/ServletHistorialMovimientos")
public class ServletHistorialMovimientos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MovimientoNegocio movNeg = new MovimientoNegocioImpl();
	private ClienteNegocio cNeg = new ClienteNegocioImpl();
       
    public ServletHistorialMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(cNeg.validarUsuarioCliente(request)) {
			cargarCuentasSelect(request);
			if(request.getParameter("slvalue") != null) {
				long numeroCuenta = Long.valueOf(request.getParameter("slvalue"));
				cargarTableHistorialMov(request,numeroCuenta);
				cargarCuentasSelect(request);
			}
		}
		else {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/HistorialMovimientos.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Rellenar el select con los tipos de cuenta de cliente
		// Capturar el evento onchange del select para cargar los datos en la tabla dependiendo el tipo de cuenta
		// Agregar un boton refresh en la tabla
		//cargarTableHistorialMov(request);
		cargarCuentasSelect(request);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HistorialMovimientos.jsp");
		rd.forward(request, response);
		
	}
	
	public void cargarCuentasSelect(HttpServletRequest request) {
		int id = (int)request.getSession().getAttribute("IdUsuario");
		ArrayList<Cuenta> listaTiposCta = movNeg.buscarTiposDeCuentasUsuario(id); // Le harcodeo el id usuario
		request.setAttribute("listaTiposCta", listaTiposCta);
	}
	public void cargarTableHistorialMov(HttpServletRequest request,long numeroCuenta) {
		ArrayList<Movimiento> listaMov = movNeg.traerDatosMovimientos(numeroCuenta); //Harcodeo el id de usuario
		request.setAttribute("listaMov", listaMov);
	}
}
