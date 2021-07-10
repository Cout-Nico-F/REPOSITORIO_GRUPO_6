package entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Cuota {
	private short numeroCuota;
	private BigDecimal importe;
	private java.sql.Date fechaVencimiento;
	private java.sql.Date fechaPago;
	
	public Cuota() {
		
	}
	
	public short getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(short numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(java.sql.Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public java.util.Date getFechaDeVencimientoJAVA() {
		return new java.util.Date(fechaVencimiento.getTime());
	}
	public java.sql.Date getFechaDeVencimientoSQL() {
		return fechaVencimiento;
	}
	
	public java.util.Date getFechaPagoJAVA() {
		return new java.util.Date(fechaPago.getTime());
	}
	
	public java.sql.Date getFechaPagoSQL() {
		return fechaPago;
	}
	
	public void setFechaPago(java.util.Date fechaPago) {
		this.fechaPago = new java.sql.Date(fechaPago.getTime());
	}
	
	
}
