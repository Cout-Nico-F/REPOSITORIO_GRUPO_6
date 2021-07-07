package negocio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoDeCuenta;

public interface IAdminNegocio {
	public ArrayList<TipoDeCuenta> listarTiposCuenta();
	public ArrayList<Cuenta> listarCuentas();
	public Cliente buscarCliente(int dni);
	public void eliminarCuenta(long nroCuenta);
	public boolean validarCampoNoVacio(String campo);
	public boolean validarCamposCuentaNoVacia(Cuenta cuenta);
	public boolean validarDNIExistente(int dni);
	public boolean AgregarCuenta(Cuenta cuenta);
	public boolean MovimientoDeAlta(Cuenta cuenta);
	public boolean validarCuentaExistente(long nroCuenta);
	public boolean asignarCuenta(long nroCuenta, int dni);
	public Cuenta traerCuenta(long nroCuenta);
}
