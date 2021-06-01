package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import dao.IPersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements IPersonaDao
{
 	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String readall = "SELECT * FROM personas";

	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(Persona persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getDni()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(id, nombre, apellido);
	}

	@Override
	public boolean Exists(int dni_persona_a_buscar) {
		PreparedStatement statement;
		ResultSet resultSet;
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean found = false;
		try {
			statement = conexion.prepareStatement("SELECT * FROM personas WHERE dni ="+dni_persona_a_buscar);
			resultSet = statement.executeQuery();
			
			if( resultSet.next() == true ) found = true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public boolean Edit(Persona persona_a_editar) {
		
		
		int rows;
		String stringQuery = "UPDATE personas SET Nombre =\""+ persona_a_editar.getNombre() +"\", Apellido =\""+ persona_a_editar.getApellido() +"\" WHERE Dni =\""+ String.valueOf(persona_a_editar.getDni()) + "\"";
		Connection conexion;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			Statement statement = conexion.createStatement();
			rows = statement.executeUpdate(stringQuery);
			
			if(rows == 1 ) {
				conexion.commit();
				System.out.println("Resultado fue "+rows+" StringQuery: "+stringQuery);
				return true;			
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Resultado fue diferente de 1");
		
		return false;	
	}
	
	public Persona convertir(ResultSet rs) throws SQLException {
		
		int dni = Integer.parseInt(rs.getString("dni"));
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");	
		Persona persona = new Persona(dni, nombre, apellido);
		return persona;
	}
	
	public List<Persona> obtenerTodas() {
		Connection conn = Conexion.getConexion().getSQLConexion();
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		try {
			stat = conn.prepareStatement(readall);
			rs = stat.executeQuery();
			while (rs.next()) {
				listaPersonas.add(convertir(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return listaPersonas;
	}
}
