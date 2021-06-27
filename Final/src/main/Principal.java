package main;

import java.math.BigDecimal;
import java.sql.Date;

import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import entidad.Cuenta;

public class Principal {

	public static void main(String[] args) {
		//(String numeroCuenta, String cBU, String dNI, short idTipodeCuenta,BigDecimal saldo,Date fecha)
		//(NumeroCuenta,Dni,IdTipoCuenta,Saldo,Cbu,FechaCreacion) values (?,?,?,?,?,?)
		Cuenta c = new Cuenta("10","6544121", "14203944", (short) 1);
		Cuenta c2 = new Cuenta("12","6544141",(short) 2);
		
		IAdminDao adm = new AdminDaoImpl();
		
		if(adm.AgregarCuenta(c) && adm.AgregarCuenta(c2)) {
			System.out.println("Se insertaron");
		}
		
	}

}
