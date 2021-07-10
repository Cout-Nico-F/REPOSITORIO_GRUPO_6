package dao;

import java.util.ArrayList;

import entidad.Cuota;
import entidad.Prestamo;

public interface PrestamoDao {

	public ArrayList<Prestamo> traerPrestamosParaAutorizar();
	public int autorizarPrestamo(Prestamo prestamo);	
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni);
	ArrayList<Cuota> listarCuotas(int idPrestamo);
	boolean actualizarPrestamo(short estado, int IDPrestamo);
	

}
