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
		Cuenta c = new Cuenta("12","6544121","31511515",(short) 3);
		
		IAdminDao adm = new AdminDaoImpl();
		
		if(adm.AgregarCuenta(c)) {
			System.out.println("Se inserto");
		}
		
	}

}
