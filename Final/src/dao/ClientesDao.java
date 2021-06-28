package dao;

import java.util.ArrayList;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;

public interface ClientesDao {
	
	public int insertCliente(Usuario u,Cliente c);//Hay que cambiarlo por el procedimiento almacenado
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente buscarCliente(int Dni);
	public ArrayList<Nacionalidad> traerNacionalidades();
	public ArrayList<Provincia> traerProvincias(); //TODO:Traer provincia tambien tiene que recibir un id nacionalidad
	public ArrayList<Localidad> traerLocalidades(int idProvincia);//Para filtrar las localidades
}
