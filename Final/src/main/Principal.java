package main;

import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import entidad.Cuenta;

public class Principal {

	public static void main(String[] args) {
		IAdminDao dao = new AdminDaoImpl();
		Cuenta cta = new Cuenta("205011","2055410","14203944",(short)1);
		Cuenta cta2 = new Cuenta("2050112","2055411","14203944",(short)1);
		Cuenta cta3 = new Cuenta("2050113","2055412","14203944",(short)1);
		
		dao.AgregarCuenta(cta);
		dao.AgregarCuenta(cta2);
		dao.AgregarCuenta(cta3);	
	}

}
