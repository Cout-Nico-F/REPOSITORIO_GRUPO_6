package dao;

import entidad.Cuota;
import entidad.Prestamo;

public interface CuotaDao {

	public int insertarCuotas(Prestamo prestamo);
	boolean registrarPagoCuota(int idPrestamo, short numeroCuota);
	

}
