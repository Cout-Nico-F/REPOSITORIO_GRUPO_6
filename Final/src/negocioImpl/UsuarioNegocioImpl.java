package negocioImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{

	@Override
	public Usuario buscarUsuario(Usuario u) {
		
		UsuarioDaoImpl udao = new UsuarioDaoImpl();
		return  udao.buscarUsuario(u); //Envio el nombre y contrasenia y hago un where en la bd si coinciden lo traigo
		//buscarUsuario devuelve un boolean
	}
}