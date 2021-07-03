package dao;

import java.math.BigDecimal;

import entidad.Cuenta;
import entidad.TipoDeMovimiento;

public interface IMovimientoDao {
	public boolean registrarMovimiento(String descMovimiento,long cuentaARestar,long cuentaASumar,BigDecimal importe);
	public boolean actualizarSaldos(String descMovimiento,long cuentaARestar,long cuentaASumar,BigDecimal importe);
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar);
	public boolean MovimientoAltaDeCuenta (Cuenta c);
	public TipoDeMovimiento traerTipoDeMovimiento(String descripcionTipoMov);
	public TipoDeMovimiento traerTipoDeMovimiento(short idTipoMov);
}
