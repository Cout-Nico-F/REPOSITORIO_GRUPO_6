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
	public boolean registrarMovimiento(String tipoMov, long cuentaorigen, long cuentaDestino, BigDecimal importe) {
		
		if(actualizarSaldos(tipoMov,cuentaorigen,cuentaDestino,importe)) {
			
		
		}
		return false;
	}

	@Override
	public boolean actualizarSaldos(String tipoMov, long cuentaOrigen, long cuentaDestino, BigDecimal importe) {
		boolean retorno = false; 
		switch(tipoMov)
		{
			case VariablesGlobales.tiposMovimientoAlta:
			{
				retorno = CaseAltaDeCuenta(cuentaDestino,importe);
			}
			case VariablesGlobales.tiposMovimientoAltaPrestamo:
			{
				retorno = CaseAltaDePrestamo(cuentaDestino,importe);
			} break;
			case VariablesGlobales.tiposMovimientoPagoPrestamo:
			{
				retorno = CasePagoPrestamo(cuentaOrigen, importe);
			} break;
			case VariablesGlobales.tiposMovimientoTransferencia:
			{
				retorno = CaseTransferencia(cuentaOrigen, cuentaDestino, importe);
			} break;
			default:
			  break;
		}
		return retorno;
	}
	
	private boolean CaseTransferencia(long cuentaOrigen, long cuentaDestino, BigDecimal importe) {
		
		if(CasePagoPrestamo(cuentaOrigen, importe)) //se le resta la plata a la cuenta origen
			if(CaseAltaDePrestamo(cuentaDestino, importe)) //se le suma plata a la cuenta destino
				return true;
		return false;
	}
	
	private boolean CasePagoPrestamo(long cuentaOrigen, BigDecimal importe) {
		
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		dao = new AdminDaoImpl();
		try {
			BigDecimal nuevoImporte = importe.subtract((dao.traerCuenta(cuentaOrigen)).getSaldo());
			if(nuevoImporte.compareTo(BigDecimal.ZERO)>=0){
				ps = conexion.prepareStatement(actualizarSaldo);
				ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaOrigen)).getSaldo())); //se suma el saldo de la cuenta con el importe del prestamo y se setea en DB
				ps.setLong(2, cuentaOrigen);		
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
	
	private boolean CaseAltaDePrestamo(long cuentaDestino, BigDecimal importe) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		dao = new AdminDaoImpl();
		try {
			ps = conexion.prepareStatement(actualizarSaldo);
			ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaDestino)).getSaldo())); //se suma el saldo de la cuenta con el importe del prestamo y se setea en DB
			ps.setLong(2, cuentaDestino);		
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
