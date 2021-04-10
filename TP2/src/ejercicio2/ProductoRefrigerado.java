package ejercicio2;

import java.util.Date;

public class ProductoRefrigerado extends Producto {
	private String codigoDeOrganismo;
	
	public ProductoRefrigerado() {
		super();
		this.codigoDeOrganismo = new String();
	}
	
	public ProductoRefrigerado(Date fechaDeCaducidad, int numeroDeLote, String codigoDeOrganismo) {
		super(fechaDeCaducidad, numeroDeLote);
		this.codigoDeOrganismo = codigoDeOrganismo;
	}
	
	public String getCodigoDeOrganismo() {
		return codigoDeOrganismo;
	}
	
	public void setCodigoDeOrganismo(String codigoDeOrganismo) {
		this.codigoDeOrganismo = codigoDeOrganismo;
	}
}