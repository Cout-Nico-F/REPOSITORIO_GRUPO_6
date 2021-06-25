package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import entidad.Persona;

public class UsuarioDaoImpl {
	
	private static final String getUsuario = "Select * From usuarios Where nombreUsuario='u.getnombreUsuario' and contrasenia='u.getContrasenia'";
	
	private boolean getUsuario(Usuario u) throws SQLException
	{
		//Codigo para buscar el usuario y que devuelve un bool en caso de existir
		//Cuando la bd este terminada haria un procedimiento almacenado
	}
}
