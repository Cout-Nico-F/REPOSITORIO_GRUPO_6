package dao;

import java.sql.SQLException;

public interface ITransferirDao {
	public boolean ComprobarExistencia(String cbu) throws SQLException;
	public boolean ComprobarSaldo(String cbu, float cantidad) throws SQLException;
	public boolean Transferir(String cbuOrigen, String cbuDestino, float cantidad) throws SQLException;
	public String TraerNroCuenta (String Cbu);
	public boolean ComprobarCuentaPropia(String cbuOrigen, String idUsuario);
}
