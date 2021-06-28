package daoImpl;

import java.sql.SQLException;

import entidad.Usuario;
import daoImpl.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDaoImpl {
	
	private static final String searchUser = "Select * From usuarios Where nombreUsuario=? and contrasenia=?";
	private static final String actualizarUsuario = "UPDATE usuarios SET Contrasenia = ? WHERE IdUsuario = ?";
	private static final String insertarUsuario = "INSERT INTO usuarios (EsAdmin, NombreUsuario, Contrasenia) VALUES (?, ?, ?);";
	
	public Usuario insertarUsuario (Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result = -1;
		Usuario registrado = new Usuario();
		try {
			statement = conexion.prepareStatement(insertarUsuario);
			statement.setBoolean(1, usuario.getEsAdmin());
			statement.setString(2, usuario.getNombreUsuario());
			statement.setString(3, usuario.getContrasenia());
			result = statement.executeUpdate();
			if(result > 0) {
				conexion.commit();
			}
			registrado = buscarUsuario(usuario);
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return registrado;
	}
	
	public int actualizarUsuario (Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result = -1;
		try {
			statement = conexion.prepareStatement(actualizarUsuario);
			statement.setString(1, usuario.getContrasenia());
			statement.setInt(2, usuario.getIdUsuario());
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
	
	public Usuario buscarUsuario(Usuario u)
	{
		//Codigo para buscar el usuario y que devuelve un bool en caso de existir
		//Cuando la bd este terminada haria un procedimiento almacenado
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		Usuario x = new Usuario();
		
		try {
			statement = conexion.prepareStatement(searchUser);
			statement.setString(1,u.getNombreUsuario());
			statement.setString(2,u.getContrasenia());
			rs = statement.executeQuery();
			while(rs.next())
			{				
				//cargamos el objeto usuario que viajara por sesión		
				x.setIdUsuario(rs.getInt("IdUsuario"));
				x.setNombreUsuario(rs.getString("NombreUsuario"));
				x.setEsAdmin(rs.getBoolean("EsAdmin"));
				return x;
			}
		}
		catch(SQLException e) {
			x = null;
			e.printStackTrace();
			return x;
		}
		x.setNombreUsuario("");
		return x;
	}
}
