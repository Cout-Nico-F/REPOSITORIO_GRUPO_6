package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;
import negocio.ClienteNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;
import java.time.LocalDate;

@WebServlet("/servletClientes")
public class servletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se ejecuta sin llamarlo?
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		ArrayList<Cliente> mostrarClientes = new ArrayList<Cliente>();
		ArrayList<Nacionalidad> listaNac = new ArrayList<Nacionalidad>();
		ArrayList<Provincia> listaPro = new ArrayList<Provincia>();
		
		String op;
		op = (request.getParameter("op") != null) ? request.getParameter("op") : "cargarDatosClientes"; 
		//Como no esta recibiendo nada por parametro primero el String op va a ser igual a cargarDatosClientes
		
		if(op.equals("cargarDatosClientes")) {
			mostrarClientes = cNeg.traerClientes();
			listaNac = cNeg.traerNacionalidades();
			listaPro = cNeg.traerProvincia();
			request.setAttribute("listaClientes",mostrarClientes);//Envio la lista de clientes cargada a ABMLClientes
			request.setAttribute("listaNacionalidades", listaNac);
		}
		if(request.getParameter("idProvincia") != null) {
			
			ArrayList<Localidad> listaLo = new ArrayList<Localidad>();
			int idProvincia = Integer.parseInt(request.getParameter("idProvincia"));
			listaLo = cNeg.traerLocalidades(idProvincia); //Tengo que ver la forma que cuando seleccione una provincia envie ese id y traiga la lista
			
			request.setAttribute("listaLocalidades", listaLo); //Le envio ya la lista filtrada
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		int rowsAfectadas = 0;
		Cliente c = new Cliente();
		Usuario u = new Usuario();
		
		if(request.getParameter("btnRegistrar") != null) {
			u.setNombreUsuario(request.getParameter("txtUsuario"));
			u.setContrasenia(request.getParameter("txtContrasenia"));
			u.setTipoUsuario(Integer.parseInt(request.getParameter("RTipoUsuario")));//Se ve horrible el radio pero para probar sirve
			c.setDni(Integer.parseInt(request.getParameter("txtDni")));
			c.setIdNacionalidad(1); //Esta harcodeado
			c.setIdLocalidad(1); //Esta harcodeado
			c.setCuil(request.getParameter("txtCuil"));
			c.setNombre(request.getParameter("txtNombre"));
			c.setApellido(request.getParameter("txtApellido"));
			c.setSexo("Masculino"); //Esta harcodeado
			c.setFechaNacimiento(Date.valueOf(request.getParameter("txtNacimiento")));
			c.setDireccion(request.getParameter("txtDireccion"));
			c.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
			
			rowsAfectadas = cNeg.insertCliente(u, c); //Devuelve las rows afectadas
			
			if(rowsAfectadas > 1) {
				//
				request.setAttribute("mensajeModal", "Cliente agregado con exito :)");
			}
			if (rowsAfectadas == 1) {
				request.setAttribute("mensajeModal", "Hubo un problema en la base de datos :(");
			}
			else {
				request.setAttribute("mensajeModal", "No se pudo agregar el cliente :!");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
			rd.forward(request,response);
		}
	}

}
