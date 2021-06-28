package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NacionalidadDao;
import entidad.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao {
	private static final String traerNacionalidad = "select * from nacionalidades where IdNacionalidad = ";
	private static final String traerNacionalidades = "select * from nacionalidades";

	@Override
	public Nacionalidad traerNacionalidad(int idNacionalidad){
		PreparedStatement statement;
		Nacionalidad nac = new Nacionalidad();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerNacionalidad + idNacionalidad);
			rs = statement.executeQuery();
			while(rs.next()) {
				Nacionalidad n = new Nacionalidad();
				n.setIdNacionalidad(rs.getInt("IdNacionalidad"));
				n.setNombre(rs.getString("Nombre"));
				nac = n;
			}
			return nac;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return nac;
		}
	}
	@Override
	public ArrayList<Nacionalidad> traerNacionalidades(){
		PreparedStatement statement;
		ArrayList<Nacionalidad> listaNac = new ArrayList<Nacionalidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerNacionalidades);
			rs = statement.executeQuery();
			while(rs.next()) {
				Nacionalidad n = new Nacionalidad();
				n.setIdNacionalidad(rs.getInt("IdNacionalidad"));
				n.setNombre(rs.getString("Nombre"));
				listaNac.add(n);
			}
			return listaNac; //Envio la lista completa
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaNac; //Lo envio vacio
		}
	}
}
