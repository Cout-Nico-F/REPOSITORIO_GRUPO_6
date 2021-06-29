package daoImpl;

import java.sql.*;
import java.util.ArrayList;

import dao.ITipoDeCuentaDao;
import entidad.TipoDeCuenta;

public class TipoDeCuentaDaoImpl implements ITipoDeCuentaDao{

	private static final String listaTodos = "select * from tiposdecuenta";
	private static final String buscar = "select * from tiposdecuenta where idtipocuenta=";
	
	@Override
	public ArrayList<TipoDeCuenta> listarTiposCuentas() {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<TipoDeCuenta> ListaTipos = new ArrayList<TipoDeCuenta>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			ps = conexion.prepareStatement(listaTodos);
			rs = ps.executeQuery();
			while(rs.next()) {
				TipoDeCuenta tipoDeCuenta = new TipoDeCuenta();
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
	public TipoDeCuenta buscarTipoDeCuenta(short ID) {
		ResultSet rs;
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		TipoDeCuenta aux = new TipoDeCuenta();
		try {
			ps = conexion.prepareStatement(buscar+ID);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux.setIdTipoCuenta(rs.getShort("IdTipoCuenta"));
				aux.setDescripcion(rs.getString("Descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return aux;
		}
		return aux;
	}
}
