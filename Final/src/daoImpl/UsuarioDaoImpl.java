package daoImpl;

import java.sql.SQLException;
import entidad.Usuario;
import daoImpl.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDaoImpl {
	
	private static final String searchUser = "Select * From usuarios Where nombreUsuario=? and contrasenia=?";
	
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
				x.setNombreUsuario(rs.getNString("NombreUsuario"));
				x.setTipoUsuario(rs.getInt("IdTipoUsuario"));
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
