package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoDeCuenta;

public interface MovimientoNegocio {
	
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar);
	public ArrayList<Cuenta> buscarTiposDeCuentasUsuario(int IDUsuario);
	public ArrayList<Movimiento> traerDatosMovimientos(int IDUsuario);
}
