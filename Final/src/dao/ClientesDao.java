package dao;

import java.util.ArrayList;
import entidad.Cliente;

public interface ClientesDao {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	
}
