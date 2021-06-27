package negocioImpl;

import daoImpl.ClientesDaoImpl;
import entidad.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{
	
	@Override
	public Cliente insertCliente (Cliente c) {
		
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return  cdao.insertCliente(c); 
		
	}
	
}
