package daoImpl;

import java.sql.*;
import java.util.ArrayList;

import dao.ITipoDeCuentaDao;
import entidad.Cuenta;
import entidad.TipoDeCuenta;

public class TipoDeCuentaDaoImpl implements ITipoDeCuentaDao{

	private static final String listaTodos = "select * from tiposdecuenta";
	private static final String buscar = "select * from tiposdecuenta where idtipocuenta=";
	// Trae todo lo relacionado de tipo cuentas que correspondan a un usuario
	private static final String buscarCuentasUsuarios = "Select * from tiposdecuenta tc inner join cuentas c on tc.IdTipoCuenta = c.IdTipoCuenta \r\n" + 
			"inner join clientes cli on cli.dni = c.dni \r\n" + 
			"inner join usuarios u on u.IdUsuario = cli.IdUsuario\r\n" + 
			"Where u.IdUsuario = ?";
	
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

	@Override
	public ArrayList<Cuenta> buscarTiposDeCuentasUsuario(int IDUsuario) {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<Cuenta> ListaTipos = new ArrayList<Cuenta>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			ps = conexion.prepareStatement(buscarCuentasUsuarios);
			ps.setInt(1,IDUsuario);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cuenta c = new Cuenta();
				c.setNumeroCuenta(String.valueOf((rs.getLong("c.NumeroCuenta"))));
				TipoDeCuenta tc = new TipoDeCuenta();
				tc.setDescripcion(rs.getString("descripcion"));
				tc.setIdTipoCuenta(rs.getShort("idTipoCuenta"));
				c.setTipoDeCuenta(tc);
				ListaTipos.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return ListaTipos;
		}
		return ListaTipos;
	}
}
