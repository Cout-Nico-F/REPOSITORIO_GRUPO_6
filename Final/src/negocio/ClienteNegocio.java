package negocio;

import java.util.ArrayList;
import entidad.Cliente;
import entidad.Usuario;

public interface ClienteNegocio {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
}
