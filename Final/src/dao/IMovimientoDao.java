package dao;

import java.math.BigDecimal;

import entidad.Cuenta;
import entidad.TipoDeMovimiento;
import entidad.VariablesGlobales;
import entidad.VariablesGlobales.TiposMovimiento;

public interface IMovimientoDao {
	public boolean registrarMovimiento(TiposMovimiento EnumTipoMov,long cuentaARestar,long cuentaASumar,BigDecimal importe);
	public boolean actualizarSaldos(TiposMovimiento EnumTipoMov,long cuentaARestar,long cuentaASumar,BigDecimal importe);
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar);
	public boolean MovimientoAltaDeCuenta (Cuenta c);
	public TipoDeMovimiento traerTipoDeMovimiento(String descripcionTipoMov);
	public TipoDeMovimiento traerTipoDeMovimiento(short idTipoMov);
}
