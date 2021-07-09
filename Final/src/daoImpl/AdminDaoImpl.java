package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import dao.IAdminDao;
import dao.ITipoDeCuentaDao;
import entidad.Cuenta;
import entidad.TipoDeMovimiento;

public class AdminDaoImpl implements IAdminDao {

	
	private static final String insert = "insert into cuentas (NumeroCuenta,Dni,IdTipoCuenta,Saldo,Cbu,FechaCreacion) values (?,?,?,?,?,?)";
	private static final String listarCuentas = "select * from cuentas where eliminado = false";
	private static final String eliminarCuenta = "update cuentas set eliminado = true where numerocuenta = ?";
	private static final String existeCuenta = "select * from cuentas where numerocuenta = ?";
	private static final String asignarCuenta = "update cuentas set dni=? where numerocuenta = ?";
	private static final String listarCuentasporDni = "select * from cuentas where eliminado = false and dni = ?";
	private ITipoDeCuentaDao daoTipoCuentas = new TipoDeCuentaDaoImpl();
	
	
	
	@Override
	public Cuenta traerCuenta(long numeroCuenta) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Cuenta cuenta = new Cuenta();
		ResultSet rs;
		ITipoDeCuentaDao daoTipoCuentas = new TipoDeCuentaDaoImpl();
		try {
			ps=conexion.prepareStatement(existeCuenta);
			ps.setLong(1, numeroCuenta);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				cuenta.setNumeroCuenta(rs.getString("numerocuenta"));
				cuenta.setDNI(rs.getInt("dni"));
				cuenta.setTipoDeCuenta(daoTipoCuentas.buscarTipoDeCuenta(rs.getShort("idtipocuenta")));
				cuenta.setSaldo(rs.getBigDecimal("saldo"));
				cuenta.setCBU(rs.getString("cbu"));
				cuenta.setFecha(rs.getDate("fechacreacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new Cuenta();
		}
		return cuenta;
	}

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
	public boolean eliminarCuenta(long nroCuenta) {

		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int resultado=0;

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

		return (resultado>0)? true:false;
	}

	

	
	@Override
	public boolean existe(long numeroCuenta) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean existe = false;
		ResultSet rs;
		
		try {
			ps=conexion.prepareStatement(existeCuenta);
			ps.setLong(1, numeroCuenta);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean asignacionCuenta(long nroCuenta, int dni) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean asigno=false;
				
		try {
			ps = conexion.prepareStatement(asignarCuenta);
			ps.setInt(1, dni);
			ps.setLong(2, nroCuenta);
			
			if(ps.executeUpdate()>0) {
				conexion.commit();
				asigno=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
		
		return asigno;
	}

	@Override
	public ArrayList<Cuenta> listarCuentas(int dni) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		try {
			ps = conexion.prepareStatement(listarCuentasporDni);
			ps.setInt(1, dni);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(String.valueOf(rs.getLong("NumeroCuenta")));
				cuenta.setDNI(rs.getInt("Dni"));
				cuenta.setTipoDeCuenta(daoTipoCuentas.buscarTipoDeCuenta(rs.getShort("IdTipoCuenta")));
				cuenta.setSaldo(rs.getBigDecimal("Saldo"));
				cuenta.setCBU(rs.getString("CBU"));
				cuenta.setFecha(rs.getDate("FechaCreacion"));
				
				listaCuentas.add(cuenta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return listaCuentas;
		}
		return listaCuentas;
	}
	

	
	
}

		
