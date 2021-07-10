package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Prestamo;

public interface IPrestamoNegocio {
	public ArrayList<BigDecimal> (ArrayList<Prestamo> listaPrestamos);

	Cuenta buscarCuenta(ArrayList<Cuenta> listaCuentas, String numeroCuenta);


}
