package dao;

import java.util.ArrayList;

import entidad.*;

public interface IAdminDao {

	public boolean AgregarCuenta (Cuenta c);
	public ArrayList<Cuenta> listarCuentas();
	public int eliminarCuenta(long nroCuenta);
	public boolean MovimientoAltaDeCuenta (Cuenta c);
	public TipoDeMovimiento traerTipoDeMovimiento(short idTipoMovimiento);
	public TipoDeMovimiento traerTipoDeMovimiento(String descripcionTipoMov);
	
}
