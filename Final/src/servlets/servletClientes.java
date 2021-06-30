package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Usuario;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/Clientes")
public class servletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se ejecuta sin llamarlo? Sí, se llama a /Clientes desde el navegador
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		if(request.getParameter("btnRegistrar") != null) {
			Cliente c = new Cliente();
			c.setNombre(request.getParameter("nombre"));
			c.setApellido(request.getParameter("apellido"));
			c.setDni(Integer.parseInt(request.getParameter("dni")));
			c.setCuil(request.getParameter("cuil"));
			c.setFechaNacimiento(getDate(request.getParameter("fecha")));
			c.setSexo(request.getParameter("sexo"));
			c.setTelefonoFijo(request.getParameter("telefono"));
			c.setCelular(request.getParameter("celular"));
			c.setDireccion(request.getParameter("direccion"));
			c.setCorreoElectronico(request.getParameter("correo"));
			Localidad l = new Localidad();
			l.setIdLocalidad(Integer.parseInt(request.getParameter("localidad")));
			c.setLocalidad(l);
			Nacionalidad n = new Nacionalidad();
			n.setIdNacionalidad(Integer.parseInt(request.getParameter("nacionalidad")));
			c.setNacionalidad(n);
			Usuario u = new Usuario();
			u.setNombreUsuario(request.getParameter("usuario"));
			u.setContrasenia(request.getParameter("contrasena"));
			u.setEsAdmin("Administrador".equals(request.getParameter("tipo")));
			c.setUsuario(u);
			
			
			String mensaje = cNeg.validacionesClientes(c);
			
			if(mensaje.equals("Cliente agregado con exito")) {
				cNeg.insertCliente(c); //Ingresas el usuario
				request.setAttribute("tipoMensajeAlta","success");
				request.setAttribute("mensajeAlert", "Cliente agregado con exito");
			}
			else {
				request.setAttribute("tipoMensajeAlta", "danger");
				request.setAttribute("mensajeAlert",mensaje);
			}
		}
		
		if(request.getParameter("btnActualizar") != null) {
			Cliente c = new Cliente();
			c.setNombre(request.getParameter("nombre"));
			c.setApellido(request.getParameter("apellido"));
			c.setDni(Integer.parseInt(request.getParameter("dni")));
			c.setFechaNacimiento(getDate(request.getParameter("fecha")));
			c.setSexo(request.getParameter("sexo"));
			c.setTelefonoFijo(request.getParameter("telefono"));
			c.setCelular(request.getParameter("celular"));
			c.setDireccion(request.getParameter("direccion"));
			c.setCorreoElectronico(request.getParameter("correo"));
			Localidad l = new Localidad();
			l.setIdLocalidad(Integer.parseInt(request.getParameter("localidad")));
			c.setLocalidad(l);
			Nacionalidad n = new Nacionalidad();
			n.setIdNacionalidad(Integer.parseInt(request.getParameter("nacionalidad")));
			c.setNacionalidad(n);
			Usuario u = new Usuario();
			u.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			u.setContrasenia(request.getParameter("contrasena"));
			c.setUsuario(u);
			
			String mensaje = cNeg.validacionesClientes(c);
			
			if(mensaje.equals("Cliente agregado con exito")) {
				cNeg.actualizarCliente(c); 
				request.setAttribute("tipoMensajeAlta","success");
				request.setAttribute("mensajeAlert", "Cliente agregado con exito");
			}
			else {
				request.setAttribute("tipoMensajeAlta", "danger");
				request.setAttribute("mensajeAlert",mensaje);
			}
		}
		if(request.getParameter("btnOk") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
			rd.forward(request,response);
		}
		
		request.setAttribute("clientes", cNeg.traerClientes());
		request.setAttribute("nacionalidades", cNeg.traerNacionalidades());
		request.setAttribute("provincias", cNeg.traerProvincias());
		request.setAttribute("localidades", cNeg.traerLocalidades());
		
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		int dni = Integer.parseInt(request.getParameter("dni"));
		if(request.getParameter("btnDetalle") != null) {
			request.setAttribute("clienteActual", cNeg.traerCliente(dni));
			request.setAttribute("vista", "detalle");
		}
		if(request.getParameter("btnModificar") != null) {			
			request.setAttribute("clienteActual", cNeg.traerCliente(dni));
			request.setAttribute("vista", "modificacion");
		}
		if(request.getParameter("btnEliminar") != null) {
			cNeg.eliminarCliente(dni);
		}
		
		request.setAttribute("clientes", cNeg.traerClientes());
		request.setAttribute("nacionalidades", cNeg.traerNacionalidades());
		request.setAttribute("provincias", cNeg.traerProvincias());
		request.setAttribute("localidades", cNeg.traerLocalidades());
		
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
		rd.forward(request,response);
		
	}
	
	private Date getDate(String dateString) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
