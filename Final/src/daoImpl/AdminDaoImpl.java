package daoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import dao.IAdminDao;
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import entidad.TipoDeMovimiento;

public class AdminDaoImpl implements IAdminDao {

	private static final String insert = "insert into cuentas (NumeroCuenta,Dni,IdTipoCuenta,Saldo,Cbu,FechaCreacion) values (?,?,?,?,?,?)";
	private static final String listarCuentas = "select * from cuentas where eliminado = false";
	private static final String eliminarCuenta = "update cuentas set eliminado = true where numerocuenta = ?";
	private static final String traerTipoDeMovimientoSegunID = "select * from tiposmovimientos where idtipomovimiento =";
	private static final String traerTipoDeMovimientoSegunDescrip = "select * from tiposmovimientos where descripcion like '%";
	private static final String movimientoAltaDeCuenta = "insert into movimientos (idtipomovimiento,dni,cuentaorigen,cuentadestino,fecha,detalles,importe)"
			+ " values (?, ?, ?, ?, ?, ?, ?)";
	private static final String actualizarSaldoInicial ="update cuentas set saldo = ? where NumeroCuenta = ?";
	// private static final String readall = "SELECT * FROM cuentas";

	@Override
	public boolean AgregarCuenta(Cuenta c) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean inserto = false;

		try {
			ps = conexion.prepareStatement(insert);
			ps.setString(1, c.getNumeroCuenta());
			if(c.getDNI()!=0) {
				ps.setInt(2, c.getDNI());				
			} else {
				ps.setNull(2, java.sql.Types.NULL);
			}
			ps.setShort(3, c.getTipoDeCuenta().getIdTipoCuenta());
			ps.setBigDecimal(4, c.getSaldo());
			ps.setString(5, c.getCBU());
			ps.setDate(6, c.getFechaSQL());

			if (ps.executeUpdate() > 0) {

				conexion.commit();
				inserto = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

			try {

				conexion.rollback();
			} catch (SQLException f) {

				f.printStackTrace();
			}
		}

		return inserto;
	}

	@Override
	public ArrayList<Cuenta> listarCuentas() {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Cuenta> listaCuentas = new ArrayList<>();
		TipoDeCuentaDaoImpl daoTipoCuentas = new TipoDeCuentaDaoImpl();
		try {
			ps = conexion.prepareStatement(listarCuentas);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(rs.getString("numerocuenta"));
				cuenta.setDNI(rs.getInt("dni"));
				cuenta.setTipoDeCuenta(daoTipoCuentas.buscarTipoDeCuenta(rs.getShort("idtipocuenta")));
				cuenta.setSaldo(rs.getBigDecimal("saldo"));
				cuenta.setCBU(rs.getString("cbu"));
				cuenta.setFecha(rs.getDate("fechacreacion"));

				listaCuentas.add(cuenta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return listaCuentas; // Acá la devolvería vacía
		}
		return listaCuentas;
	}

	@Override
	public int eliminarCuenta(long nroCuenta) {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int resultado = -1;

		try {
			ps = conexion.prepareStatement(eliminarCuenta);
			ps.setLong(1, nroCuenta);
			resultado = ps.executeUpdate();

			if (resultado > 0) {
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return resultado;
	}

	@Override
	public boolean MovimientoAltaDeCuenta(Cuenta c) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean creo = false;
		try {
			
			ps = conexion.prepareStatement(movimientoAltaDeCuenta);
			ps.setShort(1, (traerTipoDeMovimiento("Alta de cuenta")).getIdTipoMovimiento());
			ps.setInt(2, c.getDNI());
			ps.setNull(3, java.sql.Types.NULL);
			ps.setLong(4, Long.valueOf(c.getNumeroCuenta()));
			ps.setTimestamp(5, new Timestamp(Calendar.getInstance().getTime().getTime()));
			ps.setString(6, "Alta de cuenta");
			ps.setBigDecimal(7, c.getSaldo());

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
			
			ps = conexion.prepareStatement(traerTipoDeMovimientoSegunDescrip+descripcionTipoMov+"%'");
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
	public boolean actualizarSaldoAltaDeCuenta(int NumeroDeCuenta, BigDecimal saldo) {
		
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifico = false;
		
		try {
			
			ps = conexion.prepareStatement(actualizarSaldoInicial);
			ps.setBigDecimal(1, saldo);
			ps.setInt(2, NumeroDeCuenta);
			
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

		
