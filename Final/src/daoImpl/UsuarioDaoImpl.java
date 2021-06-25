package daoImpl;

import java.sql.SQLException;
import entidad.Usuario;

public class UsuarioDaoImpl {
	
	private static final String getUsuario = "Select * From usuarios Where nombreUsuario='u.getnombreUsuario' and contrasenia='u.getContrasenia'";
	
	public boolean getUsuario(Usuario u) throws SQLException
	{
		//Codigo para buscar el usuario y que devuelve un bool en caso de existir
		//Cuando la bd este terminada haria un procedimiento almacenado
		return true;
	}
}
