package entidad;

public class VistaAdmin {
	
	private String numeroCuenta;
	private TipoDeCuenta tipoCuenta;
	private Prestamo prestamo;
	
	
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public TipoDeCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoDeCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}
