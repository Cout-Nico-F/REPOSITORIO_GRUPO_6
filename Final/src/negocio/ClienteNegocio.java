package negocio;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;

public interface ClienteNegocio {
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente traerCliente(int dni);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(int dni);
	public ArrayList<Localidad> traerLocalidades();
	public ArrayList<Nacionalidad> traerNacionalidades();
	public ArrayList<Provincia> traerProvincias();
}
