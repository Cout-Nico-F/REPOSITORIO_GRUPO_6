package entidad;

import java.math.BigDecimal;

public class Cuenta {

	private String numeroCuenta;
	private String CBU;
	private String DNI;
	private short idTipodeCuenta;
	private BigDecimal saldo;
	
	public Cuenta() {
	
		
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public short getIdTipodeCuenta() {
		return idTipodeCuenta;
	}

	public void setIdTipodeCuenta(short idTipodeCuenta) {
		this.idTipodeCuenta = idTipodeCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
}
