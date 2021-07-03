package dao;

import java.math.BigDecimal;

import entidad.TipoDeMovimiento;

public interface IMovimientoDao {
	public boolean registrarMovimiento(String descMovimiento,long cuentaARestar,long cuentaASumar,BigDecimal importe);
	public boolean actualizarSaldos(String descMovimiento,long cuentaARestar,long cuentaASumar,BigDecimal importe);
}
