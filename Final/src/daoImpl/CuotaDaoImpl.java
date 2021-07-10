package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.CuotaDao;
import entidad.Cuota;
import entidad.Prestamo;

public class CuotaDaoImpl implements CuotaDao {
	private static final String InsertarCuotaInsert = "insert into cuotas(IdPrestamos, NumeroCuota, Importe, FechaVencimiento) values";
	private static final String registrarPagoCuota ="update cuotas set fechaPago =? where idPrestamos = ?";
	@Override
	public int insertarCuotas (Prestamo prestamo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int result = -1;
		
		String query = InsertarCuotaInsert;
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		for(int i=0; i<prestamo.getCuotas(); i++) {
			if(i != 0) {
				query += ",";
			}
			query += " (" + prestamo.getIdPrestamo() + ", " + (i+1) + ", " + prestamo.getMontoMensual() + ", '" + (new java.sql.Date(sumarMeses(prestamo.getFecha(), i+1).getTime())) + "')"; 
		}
		
		try {
			statement = conexion.prepareStatement(query);
			result = statement.executeUpdate();
			if(result > 0) {
				conexion.commit();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	private static Date sumarMeses(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }

	@Override
	public boolean registrarPagoCuota(int idPrestamo,short numeroCuota) {
		
		boolean modifico=false;
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			ps = conexion.prepareStatement(registrarPagoCuota);
			ps.setDate(1,new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			ps.setShort(2, numeroCuota);
			if(ps.executeUpdate()>0) {
				conexion.commit();
				modifico=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
			conexion.rollback();	
			} catch (SQLException e2) {
				e2.printStackTrace();
				return false;
			}
		return false;
		}
	
		return modifico;
	}
}
