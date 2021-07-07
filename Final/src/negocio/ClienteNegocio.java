package negocio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Prestamo;
import entidad.Provincia;
import entidad.Usuario;

public interface ClienteNegocio {
	public boolean insertCliente(Cliente c);
	public ArrayList<Cliente> traerClientes();
	public ArrayList<Cliente> traerClientes(int cantMaxCuentas);
	public Cliente traerCliente(int dni);
	public Cliente traerClientePorNombreUsuario(String nombreUsuario);
	public int actualizarCliente(Cliente cliente);
	public boolean eliminarCliente(int dni);
	public ArrayList<Localidad> traerLocalidades();
	public ArrayList<Nacionalidad> traerNacionalidades();
	public ArrayList<Provincia> traerProvincias();
	public boolean existeCuil(String cuil);
	public boolean existeDni(int dni);
	public boolean validarUsuarioCliente(HttpServletRequest request);
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni);
}
