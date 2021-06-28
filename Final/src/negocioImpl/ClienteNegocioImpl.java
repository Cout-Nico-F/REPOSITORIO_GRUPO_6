package negocioImpl;

import java.util.ArrayList;

import daoImpl.ClientesDaoImpl;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{

	@Override
	public Cliente insertCliente(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> traerClientes() {
		// TODO Auto-generated method stub
		ClientesDaoImpl cdao = new ClientesDaoImpl();
		return cdao.traerClientes();
	}

	@Override
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas) {
		// TODO Auto-generated method stub
		ClientesDaoImpl cdao = new ClientesDaoImpl();
		return cdao.traerClientes(cantMaxCuentas);
	}

	@Override
	public ArrayList<Nacionalidad> traerNacionalidades() {
		ClientesDaoImpl cdao = new ClientesDaoImpl();
		return cdao.traerNacionalidades();
	}

	@Override
	public ArrayList<Provincia> traerProvincia() {
		ClientesDaoImpl cdao = new ClientesDaoImpl();
		return cdao.traerProvincias();
	}

	@Override
	public ArrayList<Localidad> traerLocalidades(int idProvincia) {
		ClientesDaoImpl cdao = new ClientesDaoImpl();
		return cdao.traerLocalidades(idProvincia);
	}
}
