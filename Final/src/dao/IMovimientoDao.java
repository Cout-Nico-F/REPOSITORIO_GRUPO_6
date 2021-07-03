package dao;

import java.math.BigDecimal;

import entidad.TipoDeMovimiento;

public interface IMovimientoDao {
	public boolean registrarMovimiento(String descMovimiento,long cuentaorigen,long cuentaDestino,BigDecimal importe);
	public boolean actualizarSaldos(String descMovimiento,long cuentaorigen,long cuentaDestino,BigDecimal importe);
}
