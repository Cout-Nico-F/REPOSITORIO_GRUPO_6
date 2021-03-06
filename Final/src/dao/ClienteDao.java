package dao;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteDao {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente traerCliente(int dni);
	public Cliente traerClientePorNombreUsuario(String NombreUsuario);
	public int actualizarCliente(Cliente cliente);
	public int eliminarCliente(int dni);
	public boolean existeCuil(String cuil);
	public boolean existeDni(int dni);
	public ArrayList<Cliente> traerClientesSinAdmin();
}
