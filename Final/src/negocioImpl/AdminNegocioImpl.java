package negocioImpl;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClienteDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio{

	@Override
	public ArrayList<TipoDeCuenta> listarTiposCuenta() {
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
		ClienteDao dao = new ClienteDaoImpl();
		return dao.traerCliente(dni);
	}
}
