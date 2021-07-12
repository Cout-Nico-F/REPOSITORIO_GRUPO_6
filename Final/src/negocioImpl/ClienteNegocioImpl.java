package negocioImpl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ClienteDao;
import dao.LocalidadDao;
import dao.NacionalidadDao;
import dao.PrestamoDao;
import dao.ProvinciaDao;
import daoImpl.ClienteDaoImpl;
import daoImpl.LocalidadDaoImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.PrestamoDaoImpl;
import daoImpl.ProvinciaDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Prestamo;
import entidad.Provincia;
import entidad.Usuario;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{
	

	@Override
	public Cliente traerClientePorNombreUsuario(String nombreUsuario) {
		ClienteDao cliDao = new ClienteDaoImpl();
		return cliDao.traerClientePorNombreUsuario(nombreUsuario);
	}
	
	@Override
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni) {
		PrestamoDao presDao= new PrestamoDaoImpl();		
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		if(existeDni(dni)) {
			listaPrestamos = presDao.listarPrestamosPorCliente(dni);
		}
		return listaPrestamos;
	}
	
	@Override
	public boolean validarUsuarioCliente(HttpServletRequest request) {
		if(request.getSession().getAttribute("nombreUsuarioLogeado") != null && (Boolean)request.getSession().getAttribute("tipoUsuarioLogeado") == false)
			return true;
		return false;
	}
	
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
	public boolean eliminarCliente(int dni) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.eliminarCliente(dni) > 0;
	}
	
	@Override
	public int actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.actualizarCliente(cliente);
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
	public boolean existeDni(int dni) {
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.existeDni(dni);
	}

	@Override
	public boolean existeCuil(String cuil) {
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.existeCuil(cuil);
	}

	@Override
	public ArrayList<Cliente> traerClientesSinAdmin() {
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		return cdao.traerClientesSinAdmin();
	}

}
