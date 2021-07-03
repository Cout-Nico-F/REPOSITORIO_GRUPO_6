package negocioImpl;

import java.math.BigDecimal;

import dao.IMovimientoDao;
import daoImpl.MovimientoDaoImpl;
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

}
