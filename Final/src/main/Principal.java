package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import entidad.Cuenta;
import entidad.TipoDeCuenta;

public class Principal {

	public static void main(String[] args) {
		
		IAdminDao dao = new AdminDaoImpl();
		//dao.MovimientoAltaDeCuenta(new Cuenta("123813724","234384234",14203944,new TipoDeCuenta()));
	}

}
