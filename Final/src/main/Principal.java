package main;

import java.util.ArrayList;
import java.util.Iterator;

import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import entidad.Cuenta;

public class Principal {

	public static void main(String[] args) {
		IAdminDao AdmDao = new AdminDaoImpl();	
		ArrayList<Cuenta> listaCuentas = AdmDao.listarCuentas();
		for (Iterator iterator = listaCuentas.iterator(); iterator.hasNext();) {
			Cuenta cuenta = (Cuenta) iterator.next();
			System.out.println(cuenta.toString());
		}
	}

}
