package negocio;

import java.util.ArrayList;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;

public interface ClienteNegocio {
	
	public Cliente insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public ArrayList<Nacionalidad> traerNacionalidades();
	public ArrayList<Provincia> traerProvincia();
	public ArrayList<Localidad> traerLocalidades(int idProvincia);//Para filtrar las localidades
}
