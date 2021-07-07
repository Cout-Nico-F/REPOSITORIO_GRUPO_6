package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
       
    public ServletHistorialMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Rellenar el select con los tipos de cuenta de cliente
		// Capturar el evento onchange del select para cargar los datos en la tabla dependiendo el tipo de cuenta
		// Agregar un boton refresh en la tabla
		cargarCuentasSelect(request);
		//Por ahora me trae solamente los datos del usuario con id 2
		cargarTableHistorialMov(request);
		RequestDispatcher rd = request.getRequestDispatcher("/HistorialMovimientos.jsp");
		rd.forward(request, response);
	}
	
	public void cargarCuentasSelect(HttpServletRequest request) {
		ArrayList<TipoDeCuenta> listaTiposCta = movNeg.buscarTiposDeCuentasUsuario(2); // Le harcodeo el id usuario
		request.setAttribute("listaTiposCta", listaTiposCta);
	}
	public void cargarTableHistorialMov(HttpServletRequest request) {
		ArrayList<Movimiento> listaMov = movNeg.traerDatosMovimientos(2); //Harcodeo el id de usuario
		request.setAttribute("listaMov", listaMov);
	}
}
