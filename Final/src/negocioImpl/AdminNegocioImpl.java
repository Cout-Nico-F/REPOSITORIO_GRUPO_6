package negocioImpl;

import java.util.ArrayList;

import dao.ClientesDao;
import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClientesDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio{

	@Override
	public ArrayList<String> listarTiposCuenta() {
		IAdminDao dao = new AdminDaoImpl();
		return dao.listarTiposCuentas();
	}

	@Override
	public ArrayList<Cuenta> listarCuentas() {
		IAdminDao dao = new AdminDaoImpl();
		return dao.listarCuentas();
	}

	@Override
	public Cliente buscarCliente(int dni) {
		ClientesDao dao = new ClientesDaoImpl();
		return dao.buscarCliente(dni);
	}
}
