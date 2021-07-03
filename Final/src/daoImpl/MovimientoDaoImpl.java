package daoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.IAdminDao;
import dao.IMovimientoDao;
import entidad.TipoDeMovimiento;
import entidad.VariablesGlobales;

public class MovimientoDaoImpl implements IMovimientoDao{

	private IAdminDao dao;
	private static final String actualizarSaldo ="update cuentas set saldo = ? where NumeroCuenta = ?";
	
	@Override
	public boolean registrarMovimiento(String tipoMov, long cuentaARestar, long cuentaASumar, BigDecimal importe) {
		
		if(actualizarSaldos(tipoMov,cuentaARestar,cuentaASumar,importe)) {
			//TODO Falta registrar el movimiento
		
		}
		return false;
	}

	@Override
	public boolean actualizarSaldos(String tipoMov, long cuentaARestar, long cuentaASumar, BigDecimal importe) {
		boolean retorno = false; 
		switch(tipoMov)
		{
			case VariablesGlobales.tiposMovimientoAlta:
			{
				retorno = CaseAltaDeCuenta(cuentaASumar,importe);
			} break;
			case VariablesGlobales.tiposMovimientoAltaPrestamo:
			{
				retorno = CaseAltaDePrestamo(cuentaASumar,importe);
			} break;
			case VariablesGlobales.tiposMovimientoPagoPrestamo:
			{
				retorno = CasePagoPrestamo(cuentaARestar, importe);
			} break;
			case VariablesGlobales.tiposMovimientoTransferencia:
			{
				retorno = CaseTransferencia(cuentaARestar, cuentaASumar, importe);
			} break;
			default:
			  break;
		}
		return retorno;
	}
	
	private boolean CaseTransferencia(long cuentaARestar, long cuentaASumar, BigDecimal importe) {
		
		if(CasePagoPrestamo(cuentaARestar, importe)) //se le resta la plata a la cuenta origen
			if(CaseAltaDePrestamo(cuentaASumar, importe)) //se le suma plata a la cuenta destino
				return true;
		return false;
	}
	
	private boolean CasePagoPrestamo(long cuentaARestar, BigDecimal importe) {
		
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		dao = new AdminDaoImpl();
		try {
			BigDecimal nuevoImporte = importe.subtract((dao.traerCuenta(cuentaARestar)).getSaldo());
			if(nuevoImporte.compareTo(BigDecimal.ZERO)>=0){
				ps = conexion.prepareStatement(actualizarSaldo);
				ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaARestar)).getSaldo())); //se suma el saldo de la cuenta con el importe del prestamo y se setea en DB
				ps.setLong(2, cuentaARestar);		
				if (ps.executeUpdate() > 0) {
					conexion.commit();
					modifico = true;
				}				
			}
		} catch (SQLException e) {

			e.printStackTrace();

			try {
				conexion.rollback();
			} catch (SQLException f) {

				f.printStackTrace();
			}
		}
		return modifico;
	}
	
	private boolean CaseAltaDePrestamo(long cuentaASumar, BigDecimal importe) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		dao = new AdminDaoImpl();
		try {
			ps = conexion.prepareStatement(actualizarSaldo);
			ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaASumar)).getSaldo())); //se suma el saldo de la cuenta con el importe del prestamo y se setea en DB
			ps.setLong(2, cuentaASumar);		
			if (ps.executeUpdate() > 0) {
				conexion.commit();
				modifico = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();

			try {
				conexion.rollback();
			} catch (SQLException f) {

				f.printStackTrace();
			}
		}
		return modifico;
	}
	
	private boolean CaseAltaDeCuenta(long NumeroDeCuenta, BigDecimal importe) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		
		try {
			
			ps = conexion.prepareStatement(actualizarSaldo);
			ps.setBigDecimal(1, importe);
			ps.setLong(2, NumeroDeCuenta);
			
			if (ps.executeUpdate() > 0) {

				conexion.commit();
				modifico = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

			try {
				conexion.rollback();
			} catch (SQLException f) {

				f.printStackTrace();
			}
		}
		return modifico;
	}
	
	
}
