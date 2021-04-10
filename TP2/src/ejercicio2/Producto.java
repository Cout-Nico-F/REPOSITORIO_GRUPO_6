package ejercicio2;

import java.util.Date;

public class Producto {
	private Date fechaDeCaducidad;
	private int numeroDeLote;
	
	public Producto() {
		fechaDeCaducidad = new Date();
		numeroDeLote = 0;
	}

	public Producto(Date fechaDeCaducidad, int numeroDeLote) {
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.numeroDeLote = numeroDeLote;
	}

	public Date getFechaDeCaducidad() {
		return fechaDeCaducidad;
	}

	public void setFechaDeCaducidad(Date fechaDeCaducidad) {
		this.fechaDeCaducidad = fechaDeCaducidad;
	}

	public int getNumeroDeLote() {
		return numeroDeLote;
	}

	public void setNumeroDeLote(int numeroDeLote) {
		this.numeroDeLote = numeroDeLote;
	}

	@Override
	public String toString() {
		return "fecha de caducidad: " + fechaDeCaducidad + ", nro. de lote: " + numeroDeLote;
	}
	
	
}