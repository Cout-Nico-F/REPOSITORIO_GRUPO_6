package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidad.Persona;


public interface IPersonaDao 
{
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean Edit(Persona persona_a_editar);
	public boolean Exists(int dni_persona_a_buscar);
	public List<Persona> readAll();
	public Persona convertir(ResultSet rs) throws SQLException;
	public List<Persona> obtenerTodas();
	
}
