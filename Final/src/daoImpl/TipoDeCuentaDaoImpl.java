package daoImpl;

import java.sql.*;
import java.util.ArrayList;

import dao.ITipoDeCuentaDao;
import entidad.TipoDeCuenta;

public class TipoDeCuentaDaoImpl implements ITipoDeCuentaDao{

	private static final String listaTodos = "select * from tiposdecuenta";
	private static final String buscar = "select * from tiposdecuenta where idtipocuenta=";
	// Trae todo lo relacionado de tipo cuentas que correspondan a un usuario
	private static final String buscarCuentasUsuarios = "Select * from tiposdecuenta inner join cuentas on tiposdecuenta.IdTipoCuenta = cuentas.IdTipoCuenta \r\n" + 
			"inner join clientes on clientes.dni = cuentas.dni \r\n" + 
			"inner join usuarios on usuarios.IdUsuario = clientes.IdUsuario\r\n" + 
			"Where usuarios.IdUsuario = ?";
	
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
	public ArrayList<TipoDeCuenta> buscarTiposDeCuentasUsuario(int IDUsuario) {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<TipoDeCuenta> ListaTipos = new ArrayList<TipoDeCuenta>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			ps = conexion.prepareStatement(buscarCuentasUsuarios);
			ps.setInt(1,IDUsuario);
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
}
