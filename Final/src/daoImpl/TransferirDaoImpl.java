package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ITipoDeCuentaDao;
import dao.ITransferirDao;
import entidad.Cuenta;

public class TransferirDaoImpl implements ITransferirDao{

	@Override
	public boolean ComprobarExistencia(String cbu) throws SQLException {
		
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		boolean encontrado = false;
		try {
			ps=conexion.prepareStatement("select Cbu from cuentas where Cbu = ?");
			ps.setString(1, cbu);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				encontrado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}

	@Override
	public boolean ComprobarSaldo(String cbu, float cantidad) throws SQLException  {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		boolean encontrado = false;
		try {
			ps=conexion.prepareStatement("select Cbu from cuentas where Cbu = ?");
			ps.setString(1, cbu);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				encontrado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
}
