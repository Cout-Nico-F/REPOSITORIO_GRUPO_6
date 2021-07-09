package daoImpl;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IMovimientoDao;
import dao.ITransferirDao;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.VariablesGlobales;
import entidad.VariablesGlobales.TiposMovimiento;


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
		try {
			ps=conexion.prepareStatement("select Saldo from cuentas where Cbu = ?");
			ps.setString(1, cbu);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				
				if (rs.getBigDecimal("Saldo").floatValue() >= cantidad) {
					
					return true;				
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean Transferir(String cbuOrigen, String cbuDestino, float cantidad) throws SQLException
	{	
		String cuenta =  "123813723"; // TraerNroCuenta(cbuOrigen); //TODO:No olvidar este hardcode.
		String destino = "123813724"; // TraerNroCuenta(cbuDestino);
		
		String cantidad_s = Float.toString(cantidad);
		
		IMovimientoDao daoMov = new MovimientoDaoImpl();
		
		
		Movimiento aux = new Movimiento(4, daoMov.traerTipoDeMovimiento(TiposMovimiento.Transferencia.getOperacion()), "Transferencia", new BigDecimal(cantidad_s), Long.valueOf(cuenta), Long.valueOf(destino));
		
		if (daoMov.registrarMovimiento(aux)) {
			return daoMov.actualizarSaldos(VariablesGlobales.TiposMovimiento.Transferencia, Long.valueOf(destino), Long.parseLong(cuenta), new BigDecimal(cantidad_s)); 
		}				
		return false;
	}
	
	@Override
	public String TraerNroCuenta (String Cbu) {
		
		
		return "";
		
	}
}
