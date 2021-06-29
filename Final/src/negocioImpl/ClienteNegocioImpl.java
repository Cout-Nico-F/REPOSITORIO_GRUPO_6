package negocioImpl;

import java.util.ArrayList;

import dao.LocalidadDao;
import dao.NacionalidadDao;
import dao.ProvinciaDao;
import daoImpl.ClienteDaoImpl;
import daoImpl.LocalidadDaoImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.ProvinciaDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{
	
	@Override
	public boolean insertCliente(Cliente c) {
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		UsuarioDaoImpl udao = new UsuarioDaoImpl();
		Usuario usuarioCreado = udao.insertarUsuario(c.getUsuario());
		c.setUsuario(usuarioCreado);
		Cliente clienteCreado = cdao.insertCliente(c);
		return clienteCreado != null;
	}

	@Override
	public ArrayList<Cliente> traerClientes() {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.traerClientes();
	}

	@Override
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.traerClientes(cantMaxCuentas);
	}
	
	@Override
	public void eliminarCliente(int dni) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		cdao.eliminarCliente(dni);
	}
	
	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		cdao.actualizarCliente(cliente);
	}
	
	@Override
	public Cliente traerCliente(int dni) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.traerCliente(dni);
	}

	@Override
	public ArrayList<Localidad> traerLocalidades() {
		LocalidadDao dao = new LocalidadDaoImpl();
		return dao.traerLocalidades();
	}

	@Override
	public ArrayList<Nacionalidad> traerNacionalidades() {
		NacionalidadDao dao = new NacionalidadDaoImpl();
		return dao.traerNacionalidades();
	}

	@Override
	public ArrayList<Provincia> traerProvincias() {
		ProvinciaDao dao = new ProvinciaDaoImpl();
		return dao.traerProvincias();
	}

	@Override
	public String validacionesClientes(Cliente c) {
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.validacionesClientes(c);
	}
}
