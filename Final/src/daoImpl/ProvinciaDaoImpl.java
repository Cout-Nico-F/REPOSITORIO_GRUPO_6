package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {
	private static final String traerProvincia = "select * from provincias where IdProvincia = ";
	private static final String traerProvincias = "select * from provincias";

	@Override
	public Provincia traerProvincia(int idProvincia){
		PreparedStatement statement;
		Provincia prov = new Provincia();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerProvincia + idProvincia);
			rs = statement.executeQuery();
			while(rs.next()) {
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("IdProvincia"));
				p.setNombre(rs.getString("Nombre"));
				prov = p;
			}
			return prov;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return prov;
		}
	}
	@Override
	public ArrayList<Provincia> traerProvincias(){
		PreparedStatement statement;
		ArrayList<Provincia> listaProv = new ArrayList<Provincia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerProvincias);
			rs = statement.executeQuery();
			while(rs.next()) {
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("IdProvincia"));
				p.setNombre(rs.getString("Nombre"));
				listaProv.add(p);
			}
			return listaProv; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaProv; //Lo envio vacio
		}
	}
}
