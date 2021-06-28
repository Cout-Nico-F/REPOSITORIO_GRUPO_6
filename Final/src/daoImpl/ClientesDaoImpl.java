package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClientesDao;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;
import daoImpl.Conexion;

public class ClientesDaoImpl implements ClientesDao {
	
	//private static final String insertCliente = "insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) "
		//	+ "values ('?','?','?','?','?','?','?','?','?','?','?');";
	private static final String traerClientes = "Select * From clientes";
	private static final String traerClientesMaxCuentas = "Select cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico From clientes cli left join cuentas ctas on cli.Dni = ctas.Dni\r\n" + 
			"group by cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico\r\n" + 
			"having count(*) <=2";		
	private static final String traerNacionalidades = "Select * From nacionalidades";
	private static final String traerProvincias = "Select * From provincias";
	private static final String traerLocalidades = "Select * From localidades Where idProvincia = '?'";
	
	
	public int insertCliente(Usuario u,Cliente c) { //La idea es que devuelva las row
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		//ResultSet rs = null;
		Cliente cli = new Cliente();
		Usuario u = new Usuario();
		
		try {
			//Este metodo recibe un objeto Cliente cargado con los datos desde los inputs de ABML Cliente
			statement = conexion.prepareStatement(insertCliente);
			statement.setInt(1,cli.getDni());
			statement.setInt(2,cli.getIdUsuario()); //Para esto primero el cliente debe tener un usuario no?
			//Tenemos que hacer un procedimiento almacenado primero un insert en usuario se crea el id y recuperar ese
			//id para poder hacerlo cliente - usemos como referencia el script de pa que entregamos en labo 3 ahi
			//hicimos algo parecido
		}
			
		catch(SQLException e) {
			cli = null;
			e.printStackTrace();
			return cli;
		}
		return cli = null;
	}
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
		}
		return listaCli = null;
	}
	
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
	public Cliente buscarCliente(int Dni) {
		String query = "select * from clientes where dni = "+ Dni;
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		Cliente aux = new Cliente();
		try {
			ps = conexion.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				aux.setDni(rs.getInt("dni"));
				aux.setIdUsuario(rs.getInt("idusuario"));
				aux.setIdNacionalidad(rs.getInt("idnacionalidad"));
				aux.setIdLocalidad(rs.getInt("idlocalidad"));
				aux.setCuil(rs.getString("cuil"));
				aux.setNombre(rs.getString("nombre"));		
				aux.setApellido(rs.getString("apellido"));		
				aux.setSexo(rs.getString("sexo"));
				aux.setFechaNacimiento(rs.getTimestamp("fechanacimiento"));
				aux.setDireccion(rs.getString("direccion"));
				aux.setCorreoElectronico(rs.getString("correoelectronico"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Cliente();
		}
		
		return aux;
	}
	@Override
	public ArrayList<Nacionalidad> traerNacionalidades() {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ArrayList<Nacionalidad> listaNa = new ArrayList<Nacionalidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerNacionalidades);
			rs = statement.executeQuery();
			while(rs.next()) {
				Nacionalidad n = new Nacionalidad();
				n.setIdNacionalidad(rs.getInt("idNacionalidad"));
				n.setNombre(rs.getNString("Nombre"));
				listaNa.add(n);
			}
			return listaNa; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listaNa = null;
	}
	@Override
	public ArrayList<Provincia> traerProvincias() {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ArrayList<Provincia> listaPro = new ArrayList<Provincia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerNacionalidades);
			rs = statement.executeQuery();
			while(rs.next()) {
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("idProvincia"));
				p.setNombre(rs.getNString("Nombre"));
				listaPro.add(p);
			}
			return listaPro; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listaPro = null;
	}
	@Override
	public ArrayList<Localidad> traerLocalidades(int idProvincia) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ArrayList<Localidad> listaLo = new ArrayList<Localidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerLocalidades);
			rs = statement.executeQuery();
			while(rs.next()) {
				Localidad lo = new Localidad();
				lo.setIdLocalidad(rs.getInt("idLocalidad"));
				lo.setNombre(rs.getNString("Nombre"));
				
				listaLo.add(lo);
			}
			return listaLo;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listaLo = null;
	}
}
