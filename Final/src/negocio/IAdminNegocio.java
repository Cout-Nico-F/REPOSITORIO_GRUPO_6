package negocio;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;

public interface IAdminNegocio {
	public ArrayList<TipoDeCuenta> listarTiposCuenta();
	public ArrayList<Cuenta> listarCuentas();
	public Cliente buscarCliente(int dni);
}
