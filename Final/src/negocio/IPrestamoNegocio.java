package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Cuota;
import entidad.Prestamo;

public interface IPrestamoNegocio {
	public ArrayList<BigDecimal> cargarSaldos (ArrayList<Prestamo> listaPrestamos);
	public Cuenta buscarCuenta(ArrayList<Cuenta> listaCuentas, String numeroCuenta);
	public boolean registrarPagoPrestamo(String numeroCuenta, Cuota cuota, int idPrestamo, String detalle);
	public boolean registrarPrestamo(Prestamo prestamo);
}
