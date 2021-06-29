package negocioImpl;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.IAdminDao;
import dao.ITipoDeCuentaDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClienteDaoImpl;
import daoImpl.TipoDeCuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio{

	@Override
	public ArrayList<TipoDeCuenta> listarTiposCuenta() {
		ITipoDeCuentaDao dao = new TipoDeCuentaDaoImpl();
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

	@Override
	public void eliminarCuenta(long nroCuenta) {
		IAdminDao dao = new AdminDaoImpl();
		dao.eliminarCuenta(nroCuenta);
	}
}
