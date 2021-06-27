package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;

public class ClientesDaoImpl {
	
	private static final String insertCliente = "insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) "
			+ "values ('?','?','?','?','?','?','?','?','?','?','?');";
	private static final String traerClientes = "Select * From clientes";
	
	public Cliente insertCliente(Cliente c) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
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
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(insertCliente);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return cli;
		}
	}
	
}
