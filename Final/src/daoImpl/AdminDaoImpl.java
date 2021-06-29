package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAdminDao;
import entidad.Cuenta;
import entidad.TipoDeCuenta;



public class AdminDaoImpl implements IAdminDao {

	private static final String readTiposCuentas = "select * from tiposdecuenta";
	private static final String insert = "insert into cuentas (NumeroCuenta,Dni,IdTipoCuenta,Saldo,Cbu,FechaCreacion) values (?,?,?,?,?,?)";
	private static final String listarCuentas = "select * from cuentas";
	//private static final String delete = "DELETE FROM cuentas WHERE dni = ?";
	//private static final String readall = "SELECT * FROM cuentas";
	
	@Override
	public boolean AgregarCuenta(Cuenta c) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean inserto = false;
		
		try {
			
			ps = conexion.prepareStatement(insert);
			ps.setString(1, c.getNumeroCuenta());
			ps.setInt(2, c.getDNI());
			ps.setShort(3, c.getIdTipodeCuenta());
			ps.setBigDecimal(4, c.getSaldo());
			ps.setString(5, c.getCBU());
			ps.setDate(6, c.getFecha());
			
			if(ps.executeUpdate() > 0) {
				
				conexion.commit();
				inserto = true;
			}
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
			try {
				
				conexion.rollback();
			}
			catch(SQLException f) {
				
				f.printStackTrace();
			}
		}
		
		return inserto;
	}


	@Override
	public ArrayList<TipoDeCuenta> listarTiposCuentas() {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<TipoDeCuenta> ListaTipos = new ArrayList<>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		TipoDeCuenta tipoDeCuenta = new TipoDeCuenta();
		
		try {
			ps = conexion.prepareStatement(readTiposCuentas);
			rs = ps.executeQuery();
			while(rs.next()) {
				tipoDeCuenta.setDescripcion(rs.getString("descripcion"));
				tipoDeCuenta.setIdTipoCuenta(rs.getShort("idTipoCuenta"));
				ListaTipos.add(tipoDeCuenta);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return ListaTipos;
		}
		
		return ListaTipos;
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
				cuenta.setIdTipodeCuenta(rs.getShort("idtipocuenta"));
				cuenta.setSaldo(rs.getBigDecimal("saldo"));
				cuenta.setCBU(rs.getString("cbu"));
				cuenta.setFecha(rs.getDate("fechacreacion"));
				
				listaCuentas.add(cuenta);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return listaCuentas; //Ac� la devolver�a vac�a
		}
		
		return listaCuentas;
		
	}
}
