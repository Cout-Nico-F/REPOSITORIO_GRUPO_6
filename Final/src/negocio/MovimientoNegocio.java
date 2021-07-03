package negocio;

import java.math.BigDecimal;

import entidad.Cuenta;

public interface MovimientoNegocio {
	
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar);
}
