package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.LocalidadDao;
import entidad.Localidad;
import entidad.Provincia;

public class LocalidadDaoImpl implements LocalidadDao {
	private static final String traerLocalidad = "select * from localidades inner join provincias on localidades.IdProvincia = provincias.IdProvincia where IdLocalidad = ";
	private static final String traerLocalidades = "select * from localidades inner join provincias on localidades.IdProvincia = provincias.IdProvincia";

	@Override
	public Localidad traerLocalidad(int idLocalidad){
		PreparedStatement statement;
		Localidad localidad = new Localidad();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerLocalidad + idLocalidad);
			rs = statement.executeQuery();
			while(rs.next()) {
				Localidad l = new Localidad();
				l.setIdLocalidad(rs.getInt("IdLocalidad"));
				l.setNombre(rs.getString("localidades.Nombre"));
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("provincias.IdProvincia"));
				p.setNombre(rs.getString("provincias.Nombre"));
				l.setProvincia(p);
				localidad = l;
			}
			return localidad;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return localidad;
		}
	}
	@Override
	public ArrayList<Localidad> traerLocalidades(){
		PreparedStatement statement;
		ArrayList<Localidad> listaLoc = new ArrayList<Localidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerLocalidades);
			rs = statement.executeQuery();
			while(rs.next()) {
				Localidad l = new Localidad();
				l.setIdLocalidad(rs.getInt("IdLocalidad"));
				l.setNombre(rs.getString("localidades.Nombre"));
				Provincia p = new Provincia();
				p.setIdProvincia(rs.getInt("provincias.IdProvincia"));
				p.setNombre(rs.getString("provincias.Nombre"));
				l.setProvincia(p);
				listaLoc.add(l);
			}
			return listaLoc; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaLoc; //Lo envio vacio
		}
	}
}
