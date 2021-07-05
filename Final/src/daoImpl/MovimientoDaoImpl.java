package daoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import dao.IAdminDao;
import dao.IMovimientoDao;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoDeMovimiento;
import entidad.VariablesGlobales;
import entidad.VariablesGlobales.TiposMovimiento;

public class MovimientoDaoImpl implements IMovimientoDao {

	private IAdminDao dao;
	private static final String actualizarSaldo = "update cuentas set saldo = ? where NumeroCuenta = ?";
	private static final String traerSaldoCuenta = "select saldo from cuentas where numerocuenta = ?";
	private static final String movimientoAltaDeCuenta = "insert into movimientos (idtipomovimiento,cuentaorigen,cuentadestino,fecha,detalles,importe)"
			+ " values (?, ?, ?, ?, ?, ?)";
	private static final String traerTipoDeMovimientoSegunID = "select * from tiposmovimientos where idtipomovimiento =";
	private static final String traerTipoDeMovimientoSegunDescrip = "select * from tiposmovimientos where descripcion like '%";
	
	@Override
	public boolean registrarMovimiento(Movimiento mov) {
		boolean registro = false;
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			ps = conexion.prepareStatement(movimientoAltaDeCuenta);
			ps.setShort(1, mov.getTipoDeMovimiento().getIdTipoMovimiento());
			if (mov.getIDCuentaOrigen() != 0) {
				ps.setLong(2, mov.getIDCuentaOrigen());		
			}else {
				ps.setNull(2, java.sql.Types.NULL);
			}
			if (mov.getIDCuentaDestino() != 0) {
				ps.setLong(3, mov.getIDCuentaDestino());	
				
			}else {
				ps.setNull(3, java.sql.Types.NULL);
			}
			ps.setTimestamp(4, new Timestamp(Calendar.getInstance().getTime().getTime()));
			ps.setString(5, mov.getDetalle());
			ps.setBigDecimal(6, mov.getImporte());
			
			if (ps.executeUpdate() > 0) {
				conexion.commit();
				registro = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();	
			}
		}
		
		return registro;
	}

	@Override
	public boolean actualizarSaldos(TiposMovimiento tipoMov, long cuentaARestar, long cuentaASumar, BigDecimal importe) {
		boolean retorno = false;

		if (importe.compareTo(BigDecimal.ZERO) > 0) {
			switch (tipoMov.getOperacion()) {
			case VariablesGlobales.tiposMovimientoAlta: {
				retorno = CaseAltaDeCuenta(cuentaASumar, importe);
			}
				break;
			case VariablesGlobales.tiposMovimientoAltaPrestamo: {

				retorno = CaseAltaDePrestamo(cuentaASumar, importe);

			}
				break;
			case VariablesGlobales.tiposMovimientoPagoPrestamo: {
				retorno = CasePagoPrestamo(cuentaARestar, importe);
			}
				break;
			case VariablesGlobales.tiposMovimientoTransferencia: {
				retorno = CaseTransferencia(cuentaARestar, cuentaASumar, importe);
			}
				break;
			default:
				break;
			}
		}
		return retorno;
	}

	private boolean CaseTransferencia(long cuentaARestar, long cuentaASumar, BigDecimal importe) {

		if (CasePagoPrestamo(cuentaARestar, importe)) // se le resta la plata a la cuenta origen
			if (CaseAltaDePrestamo(cuentaASumar, importe)) // se le suma plata a la cuenta destino
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
			if (nuevoImporte.compareTo(BigDecimal.ZERO) >= 0) {
				ps = conexion.prepareStatement(actualizarSaldo);
				ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaARestar)).getSaldo())); // se suma el saldo de la
																								// cuenta con el importe
																								// del prestamo y se
																								// setea en DB
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
			ps.setBigDecimal(1, importe.add((dao.traerCuenta(cuentaASumar)).getSaldo())); // se suma el saldo de la
																							// cuenta con el importe del
																							// prestamo y se setea en DB
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

	@Override
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar) {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		boolean valido = false;

		try {

			BigDecimal saldo = new BigDecimal(0);
			ps = conexion.prepareStatement(traerSaldoCuenta);
			ps.setLong(1, Long.valueOf(nroCuenta));
			rs = ps.executeQuery();

			if (rs.next()) {
				saldo = rs.getBigDecimal("Saldo");
			}

			if (((saldo.subtract(importeADescontar))).compareTo(BigDecimal.ZERO) >= 0) {
				valido = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return valido;
		}

		return valido;
	}

	@Override
	public TipoDeMovimiento traerTipoDeMovimiento(short idTipoMov) {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		TipoDeMovimiento tipoMov = new TipoDeMovimiento();
		try {

			ps = conexion.prepareStatement(traerTipoDeMovimientoSegunID + idTipoMov);
			rs = ps.executeQuery();
			if (rs.next()) {
				tipoMov.setIdTipoMovimiento(rs.getShort("idtipomovimiento"));
				tipoMov.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return tipoMov;
		}

		return tipoMov;

	}

	@Override
	public TipoDeMovimiento traerTipoDeMovimiento(String descripcionTipoMov) {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		TipoDeMovimiento tipoMov = new TipoDeMovimiento();
		try {

			ps = conexion.prepareStatement(traerTipoDeMovimientoSegunDescrip + descripcionTipoMov + "%'");
			rs = ps.executeQuery();
			if (rs.next()) {
				tipoMov.setIdTipoMovimiento(rs.getShort("idtipomovimiento"));
				tipoMov.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return tipoMov;
		}

		return tipoMov;
	}

	@Override
	public boolean MovimientoAltaDeCuenta(Cuenta c) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean creo = false;
		try {

			ps = conexion.prepareStatement(movimientoAltaDeCuenta);
			ps.setShort(1, (traerTipoDeMovimiento("Alta de cuenta")).getIdTipoMovimiento());
			ps.setNull(2, java.sql.Types.NULL);
			ps.setLong(3, Long.valueOf(c.getNumeroCuenta()));
			ps.setTimestamp(4, new Timestamp(Calendar.getInstance().getTime().getTime()));
			ps.setString(5, "Alta de cuenta");
			ps.setBigDecimal(6, c.getSaldo());

			if (ps.executeUpdate() > 0) {

				conexion.commit();
				creo = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {

				conexion.rollback();
			} catch (SQLException f) {

				f.printStackTrace();
				return creo;
			}

			return creo;
		}

		return creo;

	}

}
