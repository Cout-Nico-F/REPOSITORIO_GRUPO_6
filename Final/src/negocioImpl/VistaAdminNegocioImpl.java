package negocioImpl;

import java.util.ArrayList;

import dao.VistaAdminDao;
import daoImpl.VistaAdminDaoImpl;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.TipoDeCuenta;
import entidad.VistaAdmin;
import negocio.VistaAdminNegocio;

public class VistaAdminNegocioImpl implements VistaAdminNegocio {

	@Override
	public int contadorClientes() {
		VistaAdminDao Dva = new VistaAdminDaoImpl();
		int contador = Dva.contadorClientes();
		return contador;
	}

	@Override
	public int contadorDeSolicitudesDePrestamos() {
		VistaAdminDao Dva = new VistaAdminDaoImpl();
		int contador = Dva.contadorDeSolicitudesDePrestamos();
		return contador;
	}

	@Override
	public int contadorDePrestamosRechazados() {
		VistaAdminDao Dva = new VistaAdminDaoImpl();
		int contador = Dva.contadorDePrestamosRechazados();
		return contador;
	}

	@Override
	public ArrayList<VistaAdmin> traerDatoVistaAdminSegunDni(int DniUsuario) {
		VistaAdminDao Dva = new VistaAdminDaoImpl();
		ArrayList<VistaAdmin> listaVistaAdmin = Dva.traerDatoVistaAdminSegunDni(DniUsuario);
		return listaVistaAdmin;
	}

	

}
