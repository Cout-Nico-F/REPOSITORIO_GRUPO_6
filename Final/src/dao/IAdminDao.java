package dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.*;

public interface IAdminDao {

	public boolean AgregarCuenta (Cuenta c);
	public boolean existe(long numeroCuenta);
	public ArrayList<Cuenta> listarCuentas();
	public ArrayList<Cuenta> listarCuentas(int dni);
	public boolean eliminarCuenta(long nroCuenta);
	public Cuenta traerCuenta(long numeroCuenta);
	public boolean asignacionCuenta(long nroCuenta, int dni);
	public long traerUltimoNroCuenta();
}
