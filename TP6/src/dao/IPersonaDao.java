package dao;

import java.util.List;

import entidad.Persona;


public interface IPersonaDao 
{
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean Exists(int dni_persona_a_buscar);
	public List<Persona> readAll();
}
