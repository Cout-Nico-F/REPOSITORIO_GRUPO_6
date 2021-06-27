package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidad.Cliente;
import daoImpl.Conexion;

public class ClientesDaoImpl {
	
	private static final String insertCliente = "insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) "
			+ "values ('?','?','?','?','?','?','?','?','?','?','?');";
	private static final String traerClientes = "Select * From clientes";
	private static final String traerClientesMaxCuentas = "Select cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico From clientes cli left join cuentas ctas on cli.Dni = ctas.Dni\r\n" + 
			"group by cli.Dni, cli.IdUsuario, cli.IdNacionalidad, cli.IdLocalidad, cli.Cuil, cli.Nombre, cli.Apellido, cli.Sexo, cli.FechaNacimiento, \r\n" + 
			"cli.Direccion, cli.CorreoElectronico\r\n" + 
			"having count(*) <=2";
	
	public Cliente insertCliente(Cliente c) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		//ResultSet rs = null;
		Cliente cli = new Cliente();
		
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
			return listaCli; //Lo envio vacio
		}
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
}
