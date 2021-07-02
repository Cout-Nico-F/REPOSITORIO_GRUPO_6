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
			c.setDni(getInteger(request.getParameter("dni")));
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
			
			String mensaje = validarClienteAlta(c);
			if("Cliente valido".equals(mensaje)) {
				if(cNeg.insertCliente(c)){
					mensaje = "Cliente agregado con exito";
				} else {
					mensaje = "Hubo un error al intentar crear el cliente";
				}
			}
			request.setAttribute("mensajeAlert", mensaje);
		}
		
		if(request.getParameter("btnActualizar") != null) {
			Cliente c = new Cliente();
			c.setNombre(request.getParameter("nombre"));
			c.setApellido(request.getParameter("apellido"));
			c.setDni(getInteger(request.getParameter("dni")));
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
			u.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			u.setContrasenia(request.getParameter("contrasena"));
			c.setUsuario(u);
			
			String mensaje = validarCliente(c);
			if("Cliente valido".equals(mensaje)) {
				if (cNeg.actualizarCliente(c) > 0) {
					mensaje = "Cliente modificado con exito";
				} else {
					mensaje = "Hubo un error al intentar actualizar el cliente";
				}
			}
			request.setAttribute("mensajeAlert", mensaje);
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
	
	private int getInteger(String intString) {
		int integer = 0;
		try {
			integer = Integer.parseInt(intString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return integer;
	}
	
	public String validarClienteAlta(Cliente c) {
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		String mensaje = validarCliente(c);
		if("Cliente valido".equals(mensaje)) {
			if(cNeg.existeDni(c.getDni())){
				mensaje = "El DNI ya se encuentra en base de datos";
			}
			if(cNeg.existeCuil(c.getCuil())){
				mensaje = "El CUIL ya se encuentra en base de datos";
			}
		} 
		return mensaje;
	}
	
	public String validarCliente(Cliente c) {
		String mensaje = campoVacio(c);
		if("No hay campos vacios".equals(mensaje)) {
			if(c.getNombre().length() > 45) {
				return "El campo nombre no puede superar los 45 caracteres";
			}
			if(c.getApellido().length() > 45) {
				return "El campo apellido no puede superar los 45 caracteres";
			}
			if(String.valueOf(c.getDni()).length() > 8) {
				return "El campo DNI no puede superar los 8 digitos";
			}
			if(c.getCuil().length() > 15) {
				return "El campo CUIL no puede superar los 15 caracteres";
			}
			if(c.getDireccion().length() > 45) {
				return "El campo direccion no puede superar los 45 caracteres";
			}
			if(c.getTelefonoFijo().length() > 20) {
				return "El campo telefono fijo no puede superar los 20 digitos";
			}
			if(c.getCelular().length() > 20) {
				return "El campo celular no puede superar los 20 digitos";
			}
			if(c.getCorreoElectronico().length() > 45) {
				return "El campo correo no puede superar los 45 caracteres";
			}
			if(c.getUsuario().getNombreUsuario().length() > 45) {
				return "El campo nombre usuario no puede superar los 45 caracteres";
			}
			if(c.getUsuario().getContrasenia().length() > 45) {
				return "El campo contraseña no puede superar los 45 caracteres";
			}
		}
		else {
			return mensaje;
		}
		return "Cliente valido";
	}
	
	public String campoVacio(Cliente c) {
		if(c.getNombre().isEmpty()) {
			return "El campo nombre esta vacio";
		}
		if(c.getApellido().isEmpty()) {
			return "El campo apellido esta vacio";
		}
		if(c.getDni() == 0) {
			return "El campo DNI no es valido";
		}
		if(String.valueOf(c.getCuil()).isEmpty()) {
			return "El campo CUIL esta vacio";
		}
		if(String.valueOf(c.getCelular()).isEmpty()) {
			return "El campo celular esta vacio";
		}
		if(c.getDireccion().isEmpty()) {
			return "El campo direccion esta vacio";
		}
		if(c.getCorreoElectronico().isEmpty()) {
			return "El campo correo electronico esta vacio";
		}
		if( c.getUsuario().getNombreUsuario().isEmpty() ) {
			return "El campo nombre usuario esta vacio";
		}
		if(c.getUsuario().getContrasenia().isEmpty()) {
			return "El campo contraseña esta vacio";
		}
		return "No hay campos vacios";
	}

}
