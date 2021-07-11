package negocioImpl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.CuotaDao;
import dao.IMovimientoDao;
import dao.PrestamoDao;
import daoImpl.CuotaDaoImpl;
import daoImpl.MovimientoDaoImpl;
import daoImpl.PrestamoDaoImpl;
import entidad.Cuenta;
import entidad.Cuota;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.VariablesGlobales.TiposMovimiento;
import negocio.IPrestamoNegocio;

public class PrestamoNegocioImpl implements IPrestamoNegocio {

	private PrestamoDao preDao = new PrestamoDaoImpl();
	
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
				cuota.getImporte()) && imDao.registrarMovimiento(mov) && registrarPagoCuota(idPrestamo, cuota.getNumeroCuota())) {
			
			return true;  //TODO actualizar cuota y préstamo
		} else {
			return false;
		}

	}
	
	@Override
	public boolean registrarPrestamo(Prestamo prestamo) {
		return preDao.insertarPrestamo(prestamo);
	}
	

	private boolean registrarPagoCuota(int idPrestamo, short cuota) {
		
		//1 Actualizar prestamo
		boolean resultado=true;
		CuotaDao cuotaDao = new CuotaDaoImpl();
		if(cuotaDao.registrarPagoCuota(idPrestamo,cuota)==false)resultado=false;
		
		
		ArrayList<Cuota> listaCuotas = preDao.listarCuotas(idPrestamo);
		if(listaCuotas.size()==0) {
			if(preDao.actualizarPrestamo(Short.valueOf("4"), idPrestamo)==false)resultado=false;
			
		}
		return resultado;

	}
}
