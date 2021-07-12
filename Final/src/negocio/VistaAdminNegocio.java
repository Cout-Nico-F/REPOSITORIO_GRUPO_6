package negocio;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Prestamo;
import entidad.VistaAdmin;

public interface VistaAdminNegocio {
	
	public int contadorClientes();
	public int contadorDeSolicitudesDePrestamos();
	public int contadorDePrestamosRechazados();
	public ArrayList<VistaAdmin> traerDatoVistaAdminSegunDni(int DniUsuario);
}
