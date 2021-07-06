package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.TipoDeCuenta;

public interface MovimientoNegocio {
	
	public boolean validarFondosSuficientes(String nroCuenta, BigDecimal importeADescontar);
	public ArrayList<TipoDeCuenta> buscarTiposDeCuentasUsuario(int IDUsuario);
}
