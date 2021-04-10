package ejercicio2;

import java.util.Date;

public class ProductoCongelado extends Producto {
	private float temperaturaDeCongelacion;
	
	public ProductoCongelado() {
		super();
		this.temperaturaDeCongelacion = 0;
	}
	
	public ProductoCongelado(Date fechaDeCaducidad, int numeroDeLote, float temperaturaDeCongelacion) {
		super(fechaDeCaducidad, numeroDeLote);
		this.temperaturaDeCongelacion = temperaturaDeCongelacion;
	}
	
	public float getTemperaturaDeCongelacion() {
		return temperaturaDeCongelacion;
	}
	
	public void setTemperaturaDeCongelacion(float temperaturaDeCongelacion) {
		this.temperaturaDeCongelacion = temperaturaDeCongelacion;
	}
}