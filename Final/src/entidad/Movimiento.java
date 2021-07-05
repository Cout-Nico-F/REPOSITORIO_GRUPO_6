package entidad;

import java.math.BigDecimal;

public class Movimiento {

	private int ID;
	private TipoDeMovimiento tipoDeMovimiento;
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
	public Movimiento(int iD, TipoDeMovimiento tipoDeMovimiento, String detalle, BigDecimal importe,
			long iDCuentaOrigen, long iDCuentaDestino) {
		super();
		ID = iD;
		this.tipoDeMovimiento = tipoDeMovimiento;
		this.detalle = detalle;
		this.importe = importe;
		IDCuentaOrigen = iDCuentaOrigen;
		IDCuentaDestino = iDCuentaDestino;
	}
	
	
	
}
