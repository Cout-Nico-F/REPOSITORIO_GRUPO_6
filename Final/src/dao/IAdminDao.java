package dao;

import java.util.ArrayList;

import entidad.*;

public interface IAdminDao {

	public boolean AgregarCuenta (Cuenta c);
	public ArrayList<String> listarTiposCuentas ();
}
