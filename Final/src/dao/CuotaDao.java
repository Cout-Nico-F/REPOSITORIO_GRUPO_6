package dao;

import entidad.Cuota;
import entidad.Prestamo;

public interface CuotaDao {

	public int insertarCuotas(Prestamo prestamo);
	public boolean registrarPagoCuota(int idPrestamo, Cuota cuota);
	

}
