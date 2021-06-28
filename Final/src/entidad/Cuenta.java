package entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

public class Cuenta {

	private String numeroCuenta;
	private String CBU;
	private String DNI;
	private short idTipodeCuenta;
	private BigDecimal saldo;
	private Timestamp fecha;
	
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

	}
	
	//Constructor para crear cuenta con cliente asignado
	public Cuenta(String numeroCuenta, String cBU, String dNI, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;
		DNI = dNI;
		this.idTipodeCuenta = idTipodeCuenta;
		saldo = BigDecimal.valueOf(10000);
		fecha = new Timestamp(Calendar.getInstance().getTime().getTime()); //el 1er getTime obtiene un Date,  
		                                                                   //el 2do cantidad de milisegundos transcurridos desde el 1ro de enero de 1970 00:00 GMT, hasta la fecha de sistema
	}                                                                     //con eso se elimina el deprecated del constructor anterior
	//Constructor para crear cuenta sin cliente asignado
	public Cuenta(String numeroCuenta, String cBU, short idTipodeCuenta)
	{
		super();
		this.numeroCuenta = numeroCuenta;
		CBU = cBU;	
		this.idTipodeCuenta = idTipodeCuenta;
		saldo = BigDecimal.valueOf(10000);
		fecha = new Timestamp(Calendar.getInstance().getTime().getTime());
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
		return "Número de cuenta: " + numeroCuenta + ", CBU: " + CBU + ", DNI: " + DNI + ", ID Tipo de Cuenta: "
				+ idTipodeCuenta + ", Saldo: " + "$" + saldo + ", Fecha de creación: " + fecha + ".";
	}
	
	
}
