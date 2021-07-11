package entidad;

import java.math.BigDecimal;
import java.util.Calendar;
import java.sql.*;

public class Cuenta {

	private String numeroCuenta;
	private String CBU;
	private int DNI;
	private TipoDeCuenta tipoDeCuenta;
	private BigDecimal saldo;
	private Date fecha;
	
	public Cuenta()
	{
		this.tipoDeCuenta = new TipoDeCuenta();
	}
	
	//Constructor para registrar movimientos de saldo en cuentas	
	public Cuenta(String numeroCuenta, String cBU, int dNI, TipoDeCuenta tipoDeCuenta,BigDecimal saldo,java.util.Date fecha)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.tipoDeCuenta = tipoDeCuenta;
		this.saldo = saldo;
		this.fecha= new Date(fecha.getTime());
	}
	
	//Constructor para crear cuenta con cliente asignado
	public Cuenta(String numeroCuenta, String cBU, int dNI, TipoDeCuenta tipoDeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.tipoDeCuenta = tipoDeCuenta;
		saldo = VariablesGlobales.saldoCero;
		fecha = new Date(Calendar.getInstance().getTime().getTime()); 
	}                                                                    
	
	//Constructor para crear cuenta sin cliente asignado
	public Cuenta(String numeroCuenta, String cBU, TipoDeCuenta tipoDeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;	
		this.tipoDeCuenta = tipoDeCuenta;
		saldo = VariablesGlobales.saldoCero;
		fecha = new Date(Calendar.getInstance().getTime().getTime());
	}
	
	public Cuenta(String numeroCuenta)
	{
		this.numeroCuenta = numeroCuenta;
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

	public BigDecimal getSaldo() 
	{
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) 
	{
		this.saldo = saldo;
	}
	
	public TipoDeCuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(TipoDeCuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}

	@Override
	public String toString() {
		return "Número de cuenta: " + numeroCuenta + ", CBU: " + CBU + ", DNI: " + DNI + ", Tipo de Cuenta: "
				+ tipoDeCuenta.getDescripcion() + ", Saldo: " + "$" + saldo + ", Fecha de creación: " + fecha + ".";
	}
	
	
}
