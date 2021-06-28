package negocioImpl;

import java.util.ArrayList;

import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio{

	@Override
	public ArrayList<String> listarTiposCuenta() {
		IAdminDao dao = new AdminDaoImpl();
		ArrayList<String> Lista = dao.listarTiposCuentas();
		return Lista;
	}

}
