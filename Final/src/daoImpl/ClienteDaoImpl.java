package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClienteDao;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;
import daoImpl.Conexion;

public class ClienteDaoImpl implements ClienteDao {
	private static final String insertCliente = "insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) "
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String traerClientes = "select * from clientes c inner join usuarios u on c.idusuario = u.idusuario inner join nacionalidades n on c.idnacionalidad = n.idnacionalidad inner join localidades l on c.idlocalidad = l.idlocalidad inner join provincias p on l.idprovincia = p.idprovincia where Eliminado = false";
	private static final String traerCliente = "select * from clientes c inner join usuarios u on c.idusuario = u.idusuario inner join nacionalidades n on c.idnacionalidad = n.idnacionalidad inner join localidades l on c.idlocalidad = l.idlocalidad inner join provincias p on l.idprovincia = p.idprovincia where Dni = ";
	private static final String traerClientesMaxCuentas = "Select cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico From clientes cli left join cuentas ctas on cli.Dni = ctas.Dni\r\n" + 
			"group by cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico\r\n" + 
			"having count(*) <=2";
	private static final String actualizarCliente = "UPDATE clientes SET IdNacionalidad = ? , IdLocalidad = ? , Nombre = ? , Apellido = ? , Sexo = ? , FechaNacimiento = ? , Direccion = ? , CorreoElectronico = ? , TelefonoFijo = ? , Celular = ?, Direccion = ? WHERE Dni = ?";
	private static final String eliminarCliente = "UPDATE clientes SET Eliminado = true WHERE Dni = ?";
	@Override
	public Cliente insertCliente(Cliente c) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result;
		try {
			statement = conexion.prepareStatement(insertCliente);
			statement.setInt(1, c.getDni());
			statement.setInt(2, c.getUsuario().getIdUsuario()); 
			statement.setInt(3, c.getNacionalidad().getIdNacionalidad());
			statement.setInt(4, c.getLocalidad().getIdLocalidad());
			statement.setString(5, c.getCuil());
			statement.setString(6, c.getNombre());
			statement.setString(7, c.getApellido());
			statement.setString(8, c.getSexo());
			statement.setDate(9, new java.sql.Date(c.getFechaNacimiento().getTime()));
			statement.setString(10, c.getDireccion());
			statement.setString(11, c.getCorreoElectronico());
			statement.setString(12, c.getTelefonoFijo());
			statement.setString(13, c.getCelular());
			result = statement.executeUpdate();
			if(result > 0) {
				conexion.commit();
			}
		}
		catch(SQLException e) {
			c = null;
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return c;
	}
	@Override
	public int eliminarCliente (int dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result = -1;
		try {
			statement = conexion.prepareStatement(eliminarCliente);
			statement.setInt(1, dni);
			result = statement.executeUpdate();
			if(result > 0) {
				conexion.commit();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int actualizarCliente (Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result = -1;
		try {
			statement = conexion.prepareStatement(actualizarCliente);
			statement.setInt(1, cliente.getNacionalidad().getIdNacionalidad());
			statement.setInt(2, cliente.getLocalidad().getIdLocalidad());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
			statement.setString(7, cliente.getDireccion());
			statement.setString(8, cliente.getCorreoElectronico());
			statement.setString(9, cliente.getTelefonoFijo());
			statement.setString(10, cliente.getCelular());
			statement.setString(11, cliente.getDireccion());
			statement.setInt(12, cliente.getDni());
			result = statement.executeUpdate();
			if(result > 0) {
				conexion.commit();
			}
			UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
			usuarioDaoImpl.actualizarUsuario(cliente.getUsuario());
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public Cliente traerCliente(int dni){
		PreparedStatement statement;
		Cliente cliente = new Cliente();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerCliente + dni);
			rs = statement.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setDni(rs.getInt("c.Dni"));
				c.setNombre(rs.getString("c.Nombre"));
				c.setApellido(rs.getString("c.Apellido"));
				c.setDireccion(rs.getString("c.Direccion"));
				c.setCorreoElectronico(rs.getString("c.CorreoElectronico"));
				c.setSexo(rs.getString("c.Sexo"));
				c.setCuil(rs.getString("c.Cuil"));
				c.setFechaNacimiento(rs.getDate("c.FechaNacimiento"));
				c.setTelefonoFijo(rs.getString("c.TelefonoFijo"));
				c.setCelular(rs.getString("c.Celular"));
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getInt("u.IdUsuario"));
				u.setContrasenia(rs.getString("u.Contrasenia"));
				u.setNombreUsuario(rs.getString("u.NombreUsuario"));
				u.setEsAdmin(rs.getBoolean("u.EsAdmin"));
				c.setUsuario(u);
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("p.IdProvincia"));
				p.setNombre(rs.getString("p.Nombre"));
				Localidad l = new Localidad();
				l.setIdLocalidad(rs.getInt("l.IdLocalidad"));
				l.setNombre(rs.getString("l.Nombre"));
				l.setProvincia(p);
				c.setLocalidad(l);
				Nacionalidad n = new Nacionalidad(); 
				n.setIdNacionalidad(rs.getInt("n.IdNacionalidad"));
				n.setNombre(rs.getString("n.Nombre"));
				c.setNacionalidad(n);
				cliente = c;
			}
			return cliente;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return cliente;
		}
	}
	@Override
	public ArrayList<Cliente> traerClientes(){
		PreparedStatement statement;
		ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerClientes);
			rs = statement.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setDni(rs.getInt("c.Dni"));
				c.setNombre(rs.getString("c.Nombre"));
				c.setApellido(rs.getString("c.Apellido"));
				c.setDireccion(rs.getString("c.Direccion"));
				c.setCorreoElectronico(rs.getString("c.CorreoElectronico"));
				c.setSexo(rs.getString("c.Sexo"));
				c.setCuil(rs.getString("c.Cuil"));
				c.setFechaNacimiento(rs.getDate("c.FechaNacimiento"));
				c.setTelefonoFijo(rs.getString("c.TelefonoFijo"));
				c.setCelular(rs.getString("c.Celular"));
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getInt("u.IdUsuario"));
				u.setContrasenia(rs.getString("u.Contrasenia"));
				u.setNombreUsuario(rs.getString("u.NombreUsuario"));
				u.setEsAdmin(rs.getBoolean("u.EsAdmin"));
				c.setUsuario(u);
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("p.IdProvincia"));
				p.setNombre(rs.getString("p.Nombre"));
				Localidad l = new Localidad();
				l.setIdLocalidad(rs.getInt("l.IdLocalidad"));
				l.setNombre(rs.getString("l.Nombre"));
				l.setProvincia(p);
				c.setLocalidad(l);
				Nacionalidad n = new Nacionalidad(); 
				n.setIdNacionalidad(rs.getInt("n.IdNacionalidad"));
				n.setNombre(rs.getString("n.Nombre"));
				c.setNacionalidad(n);
				listaCli.add(c);
			}
			return listaCli; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaCli; //Lo envio vacio
		}
	}
	@Override
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas){
		PreparedStatement statement;
		ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerClientesMaxCuentas);
			rs = statement.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setDni(rs.getInt("Dni"));
				c.setNombre(rs.getNString("Nombre"));
				c.setApellido(rs.getNString("Apellido"));
				c.setDireccion(rs.getNString("Direccion"));
				c.setCorreoElectronico(rs.getNString("CorreoElectronico"));
				
				listaCli.add(c);
			}
			return listaCli; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaCli; //Lo envio vacio
		}
	}
	@Override
	public String validacionesClientes(Cliente c) {
		
		/*if(campoVacio(c).equals("No hay campos vacios")) {
			
			if(c.getNombre().length() > 45) {
				return "El nombre ingresado supera los 45 caracteres";
			}
			if(c.getApellido().length() > 45) {
				return "El apellido ingresado supera los 45 caracteres";
			}
			/*if(c.getDni()) { //tengo que hacer que vaya a la base de datos y compare
				return "El dni ingresado ya se encuentra en la base de datos";
			}
			if(c.getCuil()) { //tengo que hacer que vaya a la base de datos y compare
				
			}*/
			/*if(c.getFechaNacimiento())) { //Ya recibe una fecha de nacimiento valida?
				
			}*/
			/*if(c.getSexo()) { //Como es un select tiene opciones ya predeterminadas
				
			}*//*
			if(c.getDireccion().length() > 45) {
				return "El campo direccion no puede superar los 45 digitos";
			}
			if(Integer.parseInt(c.getTelefonoFijo()) > 20) {
				return "El telefono fijo no puede superar los 20 digitos";
			}
			if(c.getUsuario().getNombreUsuario().length() > 45) {
					return "El nombre de usuario debe ser menor a 45 caracteres";
			}
			if(c.getUsuario().getContrasenia().length() > 45) {
				return "La contrase�a ingresada debe ser menor a 45 caracteres";
			}
		}*/
		return "Cliente agregado con exito";
	}
	public String campoVacio(Cliente c) {
		if(c.getNombre().isEmpty()) {
			return "El campo nombre esta vacio";
		}
		if(c.getApellido().isEmpty()) {
			return "El campo apellido esta vacio";
		}
		/*if(c.getDni() == ) {
			return "El campo dni esta vacio";
		}*/
		return "No hay campos vacios";
		// TODO Auto-generated method stub
		return null;
	}
}
