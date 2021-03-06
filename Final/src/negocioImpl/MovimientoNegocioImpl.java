package negocioImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.IMovimientoDao;
import dao.ITipoDeCuentaDao;
import daoImpl.MovimientoDaoImpl;
import daoImpl.TipoDeCuentaDaoImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoDeCuenta;
import negocio.MovimientoNegocio;

public class MovimientoNegocioImpl implements MovimientoNegocio {

	@Override
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar) {
		IMovimientoDao iDao = new MovimientoDaoImpl();
		if (iDao.validarFondosSuficientes(nroCuenta, importeADescontar)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Cuenta> buscarTiposDeCuentasUsuario(int IDUsuario) {
		ITipoDeCuentaDao iTDao = new TipoDeCuentaDaoImpl();
		return iTDao.buscarTiposDeCuentasUsuario(IDUsuario);
	}

	@Override
	public ArrayList<Movimiento> traerDatosMovimientos(long NumeroCuenta) {
		IMovimientoDao iMDao = new MovimientoDaoImpl();
		return iMDao.traerDatosMovimientos(NumeroCuenta);
	}

}
