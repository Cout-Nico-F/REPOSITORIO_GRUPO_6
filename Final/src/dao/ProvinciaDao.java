package dao;

import java.util.ArrayList;

import entidad.Provincia;

public interface ProvinciaDao {

	Provincia traerProvincia(int idProvincia);

	ArrayList<Provincia> traerProvincias();

}
