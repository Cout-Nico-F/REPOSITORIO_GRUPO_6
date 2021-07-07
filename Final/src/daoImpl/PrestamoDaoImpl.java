package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IPrestamoDao;
import entidad.Prestamo;

public class PrestamoDaoImpl implements IPrestamoDao{

	private static String listarPrestamosPorCliente = "select * from prestamos where dni = ? and estado=3";
	
	/*
	Estados de los Prestamos:
	1-Solicitado 
	2-Denegado 
	3-Vigente 
	4-Pagado
	*/
	
	@Override
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		
		try {
			ps=conexion.prepareStatement(listarPrestamosPorCliente);
			ps.setInt(1, dni);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Prestamo aux = new Prestamo();
				aux.setCantCuotas(rs.getShort("cuotas"));
				aux.setDniCliente(rs.getInt("dni"));
				aux.setFecha(rs.getDate("fecha"));
				aux.setID(rs.getInt("idPrestamos"));
				aux.setImporteSolicitado(rs.getBigDecimal("importeSolicitado"));
				aux.setMontoMensual(rs.getBigDecimal("montoMensual"));
				listaPrestamos.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Prestamo>();
		}
		
		return listaPrestamos;
	}
	
}
