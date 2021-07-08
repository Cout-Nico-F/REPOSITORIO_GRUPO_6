package entidad;

import java.math.BigDecimal;
import java.sql.Date;

public class Cuota {
	
	short numeroDeCuota;
	BigDecimal importe;
	Date fechaDeVencimiento;
	Date fechaDePago;
	
	
	public Cuota(short numeroDeCuota, BigDecimal importe, java.util.Date fechaDeVencimiento, java.util.Date fechaDePago) {
		super();
		this.numeroDeCuota = numeroDeCuota;
		this.importe = importe;
		this.fechaDeVencimiento = new Date(fechaDeVencimiento.getTime());
		this.fechaDePago = new Date(fechaDePago.getTime());
	}
	public Cuota() {
		super();
	}
	
	
	public short getNumeroDeCuota() {
		return numeroDeCuota;
	}
	public void setNumeroDeCuota(short numeroDeCuota) {
		this.numeroDeCuota = numeroDeCuota;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public java.util.Date getFechaDeVencimientoJAVA() {
		return new java.util.Date(fechaDeVencimiento.getTime());
	}
	public java.sql.Date getFechaDeVencimientoSQL() {
		return fechaDeVencimiento;
	}
	public void setFechaDeVencimiento(java.util.Date fechaDeVencimiento) {
		this.fechaDeVencimiento = new Date(fechaDeVencimiento.getTime());
	}
	public java.util.Date getFechaDePagoJAVA() {
		return new java.util.Date(fechaDePago.getTime());
	}
	public java.sql.Date getFechaDePagoSQL() {
		return fechaDePago;
	}
	public void setFechaDePago(java.util.Date fechaDePago) {
		this.fechaDePago =new Date(fechaDePago.getTime());
	}
}
