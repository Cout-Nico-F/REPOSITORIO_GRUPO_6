package negocioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import dao.ClienteDao;
import dao.IAdminDao;
import dao.IMovimientoDao;
import dao.ITipoDeCuentaDao;
import dao.PrestamoDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClienteDaoImpl;
import daoImpl.MovimientoDaoImpl;
import daoImpl.PrestamoDaoImpl;
import daoImpl.TipoDeCuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.TipoDeCuenta;
import entidad.VariablesGlobales;
import entidad.VariablesGlobales.TiposMovimiento;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;

public class AdminNegocioImpl implements IAdminNegocio {

	@Override
	public ArrayList<Prestamo> listarPrestamosParaAutorizar(){
		PrestamoDao dao = new PrestamoDaoImpl();
		return dao.traerPrestamosParaAutorizar();
	}
	
	@Override
	public int actualizarPrestamo(Prestamo prestamo) {
		PrestamoDao dao = new PrestamoDaoImpl();
		return dao.actualizarPrestamo(prestamo);
	}
	
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
		if (dao.existe(nroCuenta)) {
			dao.eliminarCuenta(nroCuenta);
		}
	}

	@Override
	public boolean validarCampoNoVacio(String campo) {
		if (campo.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validarCamposCuentaNoVacia(Cuenta c) {
		if (validarCampoNoVacio(c.getCBU()) && validarCampoNoVacio(c.getNumeroCuenta())
				&& validarCampoNoVacio(String.valueOf(c.getTipoDeCuenta().getIdTipoCuenta()))
				&& validarCampoNoVacio(String.valueOf(c.getSaldo())) && c.getTipoDeCuenta().getIdTipoCuenta() != 0)
			return true;
		return false;
	}

	@Override
	public boolean validarDNIExistente(int dni) {
		ClienteNegocio cliNeg = new ClienteNegocioImpl();
		ArrayList<Cliente> listaClientes = cliNeg.traerClientes(VariablesGlobales.cantMaxCuentasPorCliente);
		int index;
		for (index = 0; index < listaClientes.size(); index++) {
			if (listaClientes.get(index).getDni() == dni) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validarCuentaExistente(long nroCuenta) {
		IAdminDao dao = new AdminDaoImpl();
		return dao.existe(nroCuenta);
	}

	@Override
	public boolean AgregarCuenta(Cuenta cuenta) {
		IAdminDao dao = new AdminDaoImpl();
		cuenta.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
		return dao.AgregarCuenta(cuenta);
	}

	@Override
	public boolean MovimientoDeAlta(Cuenta cuenta) {
		IMovimientoDao daoMov = new MovimientoDaoImpl();
		cuenta.setSaldo(VariablesGlobales.saldoAltaDeCuenta);
		//if (daoMov.MovimientoAltaDeCuenta(cuenta)) {
		Movimiento aux = new Movimiento(0, daoMov.traerTipoDeMovimiento(TiposMovimiento.AltaCuenta.getOperacion()), "Alta de cuenta", VariablesGlobales.saldoAltaDeCuenta, Long.valueOf(0), Long.valueOf(cuenta.getNumeroCuenta()));
		if (daoMov.registrarMovimiento(aux)) {
			return daoMov.actualizarSaldos(VariablesGlobales.TiposMovimiento.AltaCuenta, Long.valueOf(0),
					Long.parseLong(cuenta.getNumeroCuenta()), VariablesGlobales.saldoAltaDeCuenta); 
		}
		return false;
	}

	@Override
	public boolean asignarCuenta(long nroCuenta, int dni) {
		IAdminDao dao = new AdminDaoImpl();
		IMovimientoDao daoMov = new MovimientoDaoImpl();
		if (validarCuentaExistente(nroCuenta) && validarDNIExistente(dni)) {
			if (daoMov.actualizarSaldos(VariablesGlobales.TiposMovimiento.AltaCuenta, Long.valueOf(0), nroCuenta,
					VariablesGlobales.saldoAltaDeCuenta) && daoMov.MovimientoAltaDeCuenta(new Cuenta(String.valueOf(nroCuenta),"",dni,new TipoDeCuenta(), VariablesGlobales.saldoAltaDeCuenta,new java.util.Date())))
				return dao.asignacionCuenta(nroCuenta, dni);
		}
		return false;
	}

	@Override
	public Cuenta traerCuenta(long nroCuenta) {
		IAdminDao dao = new AdminDaoImpl();
		Cuenta cuenta = dao.traerCuenta(nroCuenta);
		return cuenta;
	}

	/*
	 * TODO: falta crear validadores de: - El número de cuenta no esté repetido. -
	 * El CBU no este repetido. - El IDTipoCuenta exista en la tabla TiposDeCuenta.
	 * - El saldo no quede negativo después de la modificación.
	 */
}
