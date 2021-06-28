package negocio;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Cuenta;

public interface IAdminNegocio {
	public ArrayList<String> listarTiposCuenta();
	public ArrayList<Cuenta> listarCuentas();
	public Cliente buscarCliente(int dni);
}
