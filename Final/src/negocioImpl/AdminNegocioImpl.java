package negocioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import dao.ClienteDao;
import dao.IAdminDao;
import dao.ITipoDeCuentaDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClienteDaoImpl;
import daoImpl.TipoDeCuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import negocio.ClienteNegocio;
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

	@Override
	public boolean validarCampoNoVacio(String campo) {
		if(campo.isEmpty()) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean validarCamposCuentaNoVacia(Cuenta c) {
		if(validarCampoNoVacio(c.getCBU()) &&
		validarCampoNoVacio(c.getNumeroCuenta()) &&
		validarCampoNoVacio(String.valueOf(c.getTipoDeCuenta().getIdTipoCuenta())) &&
		validarCampoNoVacio(String.valueOf(c.getSaldo())) &&
		c.getTipoDeCuenta().getIdTipoCuenta()!=0)
			return true;
		return false;
	}

	@Override
	public boolean validarDNIExistente(int dni) {
		ClienteNegocio cliNeg = new ClienteNegocioImpl();
		Cliente cli = cliNeg.traerCliente(dni);
		if(cli.getDni()==0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean AgregarCuenta(Cuenta cuenta) {
		IAdminDao dao = new AdminDaoImpl();		
		cuenta.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
		return dao.AgregarCuenta(cuenta);
	}
	
	/*TODO: falta crear validadores de:
	 * 						  - El número de cuenta no esté repetido.
	 * 						  - El CBU no este repetido.
	 * 						  - El IDTipoCuenta exista en la tabla TiposDeCuenta.
	 * 						  - El saldo no quede negativo después de la modificación.
	 */
}
