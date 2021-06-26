package negocioImpl;

import java.sql.SQLException;

import org.apache.catalina.connector.Response;

import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{

	@Override
	public boolean buscarUsuario(Usuario u) {
		
		UsuarioDaoImpl udao = new UsuarioDaoImpl();
		try {
			
			return  udao.buscarUsuario(u); //Envio el nombre y contrasenia y hago un where en la bd si coinciden lo traigo
			//buscarUsuario devuelve un boolean
		
		} catch (SQLException e) {
			//TODO redireccionar a una pagina de error? 
			
			e.printStackTrace();
			return false;
		} 

	}

}
