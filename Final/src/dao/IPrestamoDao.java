package dao;

import java.util.ArrayList;

import entidad.Prestamo;

public interface IPrestamoDao {
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni);

}

