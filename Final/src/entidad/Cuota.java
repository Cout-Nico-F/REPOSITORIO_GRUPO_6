package entidad;

import java.util.Date;

public class Cuota {
	private int numeroCuota;
	private Prestamo prestamo;
	private double importe;
	private Date fechaVencimiento;
	private Date fechaPago;
	
	public Cuota() {
		
	}
	
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
}
