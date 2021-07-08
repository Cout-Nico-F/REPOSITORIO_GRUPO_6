package entidad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private Cliente cliente;
	private Cuenta cuenta;
	private java.sql.Date fecha;
	private BigDecimal importeSolicitado;
	private BigDecimal importeAPagar;
	private BigDecimal montoMensual;
	private short cuotas;
	private short estado;
	private ArrayList<Cuota> listaCuotas;
	
	public Prestamo() {
		
	}
	
	public Prestamo(int idPrestamo, Cliente cliente, Cuenta cuenta, java.sql.Date fecha, BigDecimal importeSolicitado,
			BigDecimal importeAPagar, BigDecimal montoMensual, short cuotas, short estado,
			ArrayList<Cuota> listaCuotas) {
		super();
		this.idPrestamo = idPrestamo;
		this.cliente = cliente;
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.importeSolicitado = importeSolicitado;
		this.importeAPagar = importeAPagar;
		this.montoMensual = montoMensual;
		this.cuotas = cuotas;
		this.estado = estado;
		this.listaCuotas = listaCuotas;
	}



	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public java.sql.Date getFecha() {
		return fecha;
	}
	public void setFechaSQL(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	public java.util.Date getFechaJAVA() {
		return new java.util.Date(fecha.getTime());
	}
	public java.sql.Date getFechaSQL() {
		return fecha;
	}
	
	public void setFechaJAVA(java.util.Date fecha) {
		this.fecha = new java.sql.Date(fecha.getTime());
	}
	
	public BigDecimal getImporteSolicitado() {
		return importeSolicitado;
	}
	public void setImporteSolicitado(BigDecimal importeSolicitado) {
		this.importeSolicitado = importeSolicitado;
	}
	public BigDecimal getImporteAPagar() {
		return importeAPagar;
	}
	public void setImporteAPagar(BigDecimal importeAPagar) {
		this.importeAPagar = importeAPagar;
	}
	public BigDecimal getMontoMensual() {
		return montoMensual;
	}
	public void setMontoMensual(BigDecimal montoMensual) {
		this.montoMensual = montoMensual;
	}
	public short getCuotas() {
		return cuotas;
	}
	public void setCuotas(short cuotas) {
		this.cuotas = cuotas;
	}
	public short getEstado() {
		return estado;
	}
	public void setEstado(short estado) {
		this.estado = estado;
	}

	public ArrayList<Cuota> getListaCuotas() {
		return listaCuotas;
	}

	public void setListaCuotas(ArrayList<Cuota> listaCuotas) {
		this.listaCuotas = listaCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
