package entidad;

public class TipoDeMovimiento {
	
	private short idTipoMovimiento;
	private String descripcion;
	
	public short getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(short idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoDeMovimiento(short idTipoMovimiento, String descripcion) {
		super();
		this.idTipoMovimiento = idTipoMovimiento;
		this.descripcion = descripcion;
	}
	
	public TipoDeMovimiento() {
		super();
	}
	
}
