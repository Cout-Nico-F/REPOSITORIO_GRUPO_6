package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IAdminDao;
import entidad.Cuenta;



public class AdminDaoImpl implements IAdminDao {

	private static final String readTiposCuentas = "select descripcion from tiposdecuenta";
	private static final String insert = "insert into cuentas (NumeroCuenta,Dni,IdTipoCuenta,Saldo,Cbu,FechaCreacion) values (?,?,?,?,?,?)";
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
			ps.setString(2, c.getDNI());
			ps.setShort(3, c.getIdTipodeCuenta());
			ps.setBigDecimal(4, c.getSaldo());
			ps.setString(5, c.getCBU());
			ps.setTimestamp(6, c.getFecha());
			
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
	public ArrayList<String> listarTiposCuentas() {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<String> ListaTipos = new ArrayList<>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			ps = conexion.prepareStatement(readTiposCuentas);
			rs = ps.executeQuery();
			while(rs.next()) {
				String aux = rs.getString("descripcion");
				ListaTipos.add(aux);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return ListaTipos;
		}
		
		return ListaTipos;
	}
}
