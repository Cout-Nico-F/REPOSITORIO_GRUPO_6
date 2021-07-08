package dao;

import java.util.ArrayList;

import entidad.Prestamo;

public interface PrestamoDao {

	public ArrayList<Prestamo> traerPrestamosParaAutorizar();
	public int actualizarPrestamo(Prestamo prestamo);	
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni);

}
