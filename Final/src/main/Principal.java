package main;

import dao.ClientesDao;
import dao.IAdminDao;
import daoImpl.AdminDaoImpl;
import daoImpl.ClientesDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;

public class Principal {

	public static void main(String[] args) {
		ClientesDao cliDao = new ClientesDaoImpl();	
		Cliente c = cliDao.buscarCliente(14203944);
		System.out.println(c.toString());
	}

}
