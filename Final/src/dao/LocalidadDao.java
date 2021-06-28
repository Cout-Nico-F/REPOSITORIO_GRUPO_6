package dao;

import java.util.ArrayList;

import entidad.Localidad;

public interface LocalidadDao {

	Localidad traerLocalidad(int idLocalidad);

	ArrayList<Localidad> traerLocalidades();

}
