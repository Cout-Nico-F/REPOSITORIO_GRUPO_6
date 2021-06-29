package entidad;

public class TipoDeCuenta {
	private short idTipoCuenta;
	private String descripcion;
	
	public TipoDeCuenta() {};
	
	public TipoDeCuenta(short idTipoCuenta, String descripcion) {
		super();
		this.idTipoCuenta = idTipoCuenta;
		this.descripcion = descripcion;
	}

	public short getIdTipoCuenta() {
		return idTipoCuenta;
	}
	public void setIdTipoCuenta(short idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
