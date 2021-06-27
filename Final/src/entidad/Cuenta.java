package entidad;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Cuenta {

	private String numeroCuenta;
	private String CBU;
	private String DNI;
	private short idTipodeCuenta;
	private BigDecimal saldo;
	private java.sql.Timestamp fecha;
	
	public Cuenta()
	{
	
	}
	//Constructor para registrar movimientos de saldo en cuentas
	
	public Cuenta(String numeroCuenta, String cBU, String dNI, short idTipodeCuenta,BigDecimal saldo,Timestamp fecha)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.idTipodeCuenta = idTipodeCuenta;
		this.saldo = saldo;
		this.fecha= fecha;
 
		

		//DB es tipo datetime

	}
	
	//Constructor para crear cuenta con cliente asignado
	public Cuenta(String numeroCuenta, String cBU, String dNI, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.idTipodeCuenta = idTipodeCuenta;
		this.saldo =BigDecimal.valueOf(10000);
		java.util.Date fecha = new java.util.Date();
		fecha =java.util.Calendar.getInstance().getTime(); 
		
		fecha =new Timestamp(fecha.getYear(),fecha.getMonth(),fecha.getDay(),fecha.getHours(),fecha.getMinutes(),fecha.getSeconds(),0);;
	}
	//Constructor para crear cuenta sin cliente asignado
	public Cuenta(String numeroCuenta, String cBU, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;	
		this.idTipodeCuenta = idTipodeCuenta;
		this.saldo = BigDecimal.valueOf(10000);
		fecha =java.util.Calendar.getInstance().getTime(); 
	}

	public java.sql.Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getNumeroCuenta() 
	{
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) 
	{
		this.numeroCuenta = numeroCuenta;
	}

	public String getCBU() 
	{
		return CBU;
	}

	public void setCBU(String cBU) 
	{
		CBU = cBU;
	}

	public String getDNI() 
	{
		return DNI;
	}

	public void setDNI(String dNI) 
	{
		DNI = dNI;
	}

	public short getIdTipodeCuenta() 
	{
		return idTipodeCuenta;
	}

	public void setIdTipodeCuenta(short idTipodeCuenta) 
	{
		this.idTipodeCuenta = idTipodeCuenta;
	}

	public BigDecimal getSaldo() 
	{
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) 
	{
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", CBU=" + CBU + ", DNI=" + DNI + ", idTipodeCuenta="
				+ idTipodeCuenta + ", saldo=" + saldo + "]";
	}
	
	
}
