package dao;

import java.math.BigDecimal;

import entidad.TipoDeMovimiento;

public interface IMovimientoDao {
	public boolean registrarMovimiento(TipoDeMovimiento tipoMov,long cuentaorigen,long cuentaDestino,BigDecimal importe);
	public boolean actualizarSaldos(TipoDeMovimiento tipoMov,long cuentaorigen,long cuentaDestino,BigDecimal importe);
}
