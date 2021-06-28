package negocio;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.TiposDeCuenta;

public interface IAdminNegocio {
	public ArrayList<TiposDeCuenta> listarTiposCuenta();
	public ArrayList<Cuenta> listarCuentas();
	public Cliente buscarCliente(int dni);
}
