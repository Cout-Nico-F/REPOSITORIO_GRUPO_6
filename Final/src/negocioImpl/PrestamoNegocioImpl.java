package negocioImpl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.IMovimientoDao;
import daoImpl.MovimientoDaoImpl;
import entidad.Cuenta;
import entidad.Cuota;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.VariablesGlobales.TiposMovimiento;
import negocio.IPrestamoNegocio;

public class PrestamoNegocioImpl implements IPrestamoNegocio {

	@Override
	public Cuenta buscarCuenta(ArrayList<Cuenta> listaCuentas, String numeroCuenta) {

		Cuenta aux = new Cuenta();
		for (Cuenta c : listaCuentas) {
			if (c.getNumeroCuenta().equals(numeroCuenta)) {
				aux = c;
			}
		}
		return aux;
	}

	@Override
	public ArrayList<BigDecimal> cargarSaldos(ArrayList<Prestamo> listaPrestamos) {
		ArrayList<BigDecimal> listaSaldos = new ArrayList<BigDecimal>();
		for (int i = 0; i < listaPrestamos.size(); i++) {
			BigDecimal aux = new BigDecimal(0);
			ArrayList<Cuota> listaCuotas = listaPrestamos.get(i).getListaCuotas();
			for (Cuota c : listaCuotas) {
				aux = new BigDecimal(c.getImporte().floatValue() + aux.floatValue(), new MathContext(6)).setScale(2);
			}
			listaSaldos.add(aux);
		}
		return listaSaldos;
	}

	@Override
	public boolean registrarPagoPrestamo(String numeroCuenta, Cuota cuota, int idPrestamo, String detalle) {
		IMovimientoDao imDao = new MovimientoDaoImpl();
		Movimiento mov = new Movimiento(imDao.traerTipoDeMovimiento(TiposMovimiento.PagoPrestamo.getOperacion()),
				detalle, cuota.getImporte(), Long.valueOf(numeroCuenta));
		if (imDao.actualizarSaldos(TiposMovimiento.PagoPrestamo, Long.valueOf(numeroCuenta), 0,
				cuota.getImporte()) && imDao.registrarMovimiento(mov) && registrarPagoCuota(idPrestamo, cuota)) {
			
			return true;  //TODO actualizar cuota y préstamo
		} else {
			return false;
		}

	}
	
	private boolean registrarPagoCuota(int idPrestamo, Cuota cuota) {
		
	}

}
