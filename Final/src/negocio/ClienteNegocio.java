package negocio;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;

public interface ClienteNegocio {
	public boolean insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente traerCliente(int dni);
	public int actualizarCliente(Cliente cliente);
	public void eliminarCliente(int dni);
	public ArrayList<Localidad> traerLocalidades();
	public ArrayList<Nacionalidad> traerNacionalidades();
	public ArrayList<Provincia> traerProvincias();
	public boolean existeCuil(String cuil);
	public boolean existeDni(int dni);
}
