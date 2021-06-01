package negocioImpl;

import java.util.List;

import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocioImpl implements IPersonaNegocio{

	IPersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni()>0)
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean Exists(int dni_persona_a_buscar) {
		
		if( pdao.Exists(dni_persona_a_buscar) ) return true;
		else return false;
	}

	@Override
	public boolean edit(Persona persona_a_editar) {
		if( pdao.Edit(persona_a_editar) ) return true;
		else return false;
	}
	
	public List<Persona> obtenerTodas() {
		return pdao.obtenerTodas();
	}

}
