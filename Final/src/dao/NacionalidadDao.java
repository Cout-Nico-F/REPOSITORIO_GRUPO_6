package dao;

import java.util.ArrayList;

import entidad.Nacionalidad;

public interface NacionalidadDao {

	ArrayList<Nacionalidad> traerNacionalidades();

	Nacionalidad traerNacionalidad(int idNacionalidad);

}
