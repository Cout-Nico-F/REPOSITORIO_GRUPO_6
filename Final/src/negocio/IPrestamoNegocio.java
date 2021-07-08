package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Prestamo;

public interface IPrestamoNegocio {
	public ArrayList<BigDecimal> cargarSaldos(ArrayList<Prestamo> listaPrestamos);
}
