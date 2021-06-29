package entidad;

import java.math.BigDecimal;
import java.util.Calendar;
import java.sql.*;

public class Cuenta {

	private String numeroCuenta;
	private String CBU;
	private int DNI;
	private short idTipodeCuenta;
	private BigDecimal saldo;
	private Date fecha;
	
	public Cuenta()
	{
	
	}
	//Constructor para registrar movimientos de saldo en cuentas
	
	public Cuenta(String numeroCuenta, String cBU, int dNI, short idTipodeCuenta,BigDecimal saldo,Date fecha)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.idTipodeCuenta = idTipodeCuenta;
		this.saldo = saldo;
		this.fecha= fecha;

	}
	
	//Constructor para crear cuenta con cliente asignado
	public Cuenta(String numeroCuenta, String cBU, int dNI, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.idTipodeCuenta = idTipodeCuenta;
		saldo = BigDecimal.valueOf(10000);
		fecha = (Date)Calendar.getInstance().getTime(); 
	}                                                                    
	
	//Constructor para crear cuenta sin cliente asignado
	public Cuenta(String numeroCuenta, String cBU, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;	
		this.idTipodeCuenta = idTipodeCuenta;
		saldo = BigDecimal.valueOf(10000);
		fecha = (Date)Calendar.getInstance().getTime();
	}

	public java.sql.Date getFecha() {
		return fecha;
	}
	
	public void setFecha(java.sql.Date fecha) {
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

	public int getDNI() 
	{
		return DNI;
	}

	public void setDNI(int dNI) 
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
		return "Número de cuenta: " + numeroCuenta + ", CBU: " + CBU + ", DNI: " + DNI + ", ID Tipo de Cuenta: "
				+ idTipodeCuenta + ", Saldo: " + "$" + saldo + ", Fecha de creación: " + fecha + ".";
	}
	
	
}
