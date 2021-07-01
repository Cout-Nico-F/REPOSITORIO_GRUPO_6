package entidad;

import java.math.BigDecimal;

public class Movimiento {

	private int ID;
	private TipoDeMovimiento tipoDeMovimiento;
	private int DNI;
	private java.sql.Date fecha;
	private String detalle;
	private BigDecimal importe;
	private long IDCuentaOrigen;
	private long IDCuentaDestino;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public TipoDeMovimiento getTipoDeMovimiento() {
		return tipoDeMovimiento;
	}
	public void setTipoDeMovimiento(TipoDeMovimiento tipoDeMovimiento) {
		this.tipoDeMovimiento = tipoDeMovimiento;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public java.sql.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public long getIDCuentaOrigen() {
		return IDCuentaOrigen;
	}
	public void setIDCuentaOrigen(long iDCuentaOrigen) {
		IDCuentaOrigen = iDCuentaOrigen;
	}
	public long getIDCuentaDestino() {
		return IDCuentaDestino;
	}
	public void setIDCuentaDestino(long iDCuentaDestino) {
		IDCuentaDestino = iDCuentaDestino;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
