package dao;

import java.util.ArrayList;

import entidad.TipoDeCuenta;

public interface ITipoDeCuentaDao {
	public ArrayList<TipoDeCuenta> listarTiposCuentas();
	public TipoDeCuenta buscarTipoDeCuenta(short ID);
	public ArrayList<TipoDeCuenta> buscarTiposDeCuentasUsuario(int IDUsuario);
}
