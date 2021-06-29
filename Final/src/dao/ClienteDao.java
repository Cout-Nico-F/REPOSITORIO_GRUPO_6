package dao;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteDao {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente traerCliente(int dni);
	public int actualizarCliente(Cliente cliente);
	public int eliminarCliente(int dni);
	public String validacionesClientes(Cliente c);
}
