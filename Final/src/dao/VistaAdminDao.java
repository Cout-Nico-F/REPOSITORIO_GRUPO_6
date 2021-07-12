package dao;

import java.util.ArrayList;

import entidad.VistaAdmin;

public interface VistaAdminDao {
	
	public int contadorClientes();
	public int contadorDeSolicitudesDePrestamos();
	public int contadorDePrestamosRechazados();
	public ArrayList<VistaAdmin> traerDatoVistaAdminSegunDni(int DniUsuario);
	
}
