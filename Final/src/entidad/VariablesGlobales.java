package entidad;

import java.math.BigDecimal;

public class VariablesGlobales {
	public static final int cantMaxCuentasPorCliente=3;
	public static final BigDecimal saldoInicial=BigDecimal.valueOf(0);//No usar
	public static final BigDecimal saldoAltaDeCuenta=BigDecimal.valueOf(10000);
	public static final String tiposMovimientoAlta = "Alta de cuenta";
	public static final String tiposMovimientoAltaPrestamo = "Alta de prestamo";
	public static final String tiposMovimientoPagoPrestamo = "Pago de prestamo";
	public static final String tiposMovimientoTransferencia = "Transferencia";
	public enum TiposMovimiento {
		AltaCuenta("Alta de cuenta"),
	    AltaPrestamo("Alta de prestamo"),
	    PagoPrestamo("Pago de prestamo"),
	    Transferencia("Transferencia");
		
	    public final String operacion;
	    private TiposMovimiento(String op) {
	        operacion = op;
	    }
	    public String getOperacion() {
	    	return operacion;
	    }
	}
}