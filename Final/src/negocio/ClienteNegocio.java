package negocio;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteNegocio {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	
}
