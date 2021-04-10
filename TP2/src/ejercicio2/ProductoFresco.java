package ejercicio2;

import java.util.Date;

public class ProductoFresco extends Producto {
	private Date fechaDeEnvasado;
	private String paisDeOrigen;
	
	public ProductoFresco() {
		super();
		this.fechaDeEnvasado = new Date();
		this.paisDeOrigen = new String();
	}
	
	public ProductoFresco(Date fechaDeCaducidad, int numeroDeLote, Date fechaDeEnvasado, String paisDeOrigen) {
		super(fechaDeCaducidad, numeroDeLote);
		this.fechaDeEnvasado = fechaDeEnvasado;
		this.paisDeOrigen = paisDeOrigen;
	}
	
	public Date getFechaDeEnvasado() {
		return fechaDeEnvasado;
	}
	
	public void setFechaDeEnvasado(Date fechaDeEnvasado) {
		this.fechaDeEnvasado = fechaDeEnvasado;
	}
	
	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}
	
	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}
}