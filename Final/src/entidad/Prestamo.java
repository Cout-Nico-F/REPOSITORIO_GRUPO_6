package entidad;

import java.math.BigDecimal;
import java.sql.Date;

public class Prestamo {
	private int ID;
	private int dniCliente;
	private Date fecha;
	private BigDecimal importeSolicitado;
	private BigDecimal montoMensual;
	private short cantCuotas;
	
	public Prestamo(int iD, int dniCliente, java.util.Date fecha, BigDecimal importeSolicitado,
			BigDecimal montoMensual, short cantCuotas) {
		super();
		ID = iD;
		this.dniCliente = dniCliente;
		this.fecha = new Date(fecha.getTime());
		this.importeSolicitado = importeSolicitado;
		this.montoMensual = montoMensual;
		this.cantCuotas = cantCuotas;
	}
	
	public Prestamo() {
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}
	public java.sql.Date getFechaSQL() {
		return fecha;
	}
	public java.util.Date getFechaJava() {
		return new java.util.Date(fecha.getTime());
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = new Date(fecha.getTime());
	}
	public BigDecimal getImporteSolicitado() {
		return importeSolicitado;
	}
	public void setImporteSolicitado(BigDecimal importeSolicitado) {
		this.importeSolicitado = importeSolicitado;
	}
	public BigDecimal getMontoMensual() {
		return montoMensual;
	}
	public void setMontoMensual(BigDecimal montoMensual) {
		this.montoMensual = montoMensual;
	}
	public short getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(short cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

}
