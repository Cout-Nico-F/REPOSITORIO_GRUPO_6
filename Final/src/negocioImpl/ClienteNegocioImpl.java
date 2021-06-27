package negocioImpl;

import java.util.ArrayList;

import daoImpl.ClientesDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{

	@Override
	public Cliente insertCliente(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> traerClientes() {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();

		return  udao.buscarUsuario(u);
	}
	
	
	
}
