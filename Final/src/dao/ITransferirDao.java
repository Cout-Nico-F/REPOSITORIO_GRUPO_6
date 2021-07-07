package dao;

import java.sql.SQLException;

public interface ITransferirDao {
	public boolean ComprobarExistencia(String cbu) throws SQLException;
	public boolean ComprobarSaldo(String cbu, float cantidad) throws SQLException;
}
