package dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.*;

public interface IAdminDao {

	public boolean AgregarCuenta (Cuenta c);
	public boolean existe(long numeroCuenta);
	public ArrayList<Cuenta> listarCuentas();
	public int eliminarCuenta(long nroCuenta);
	public boolean MovimientoAltaDeCuenta (Cuenta c);
	public TipoDeMovimiento traerTipoDeMovimiento(short idTipoMovimiento);
	public TipoDeMovimiento traerTipoDeMovimiento(String descripcionTipoMov);
	public boolean actualizarSaldoAltaDeCuenta(int NumeroDeCuenta,BigDecimal saldo);
	public boolean asignacionCuenta(long nroCuenta, String nombre, String apellido, int dni);
	public Cuenta traerCuenta(long numeroCuenta);
}
