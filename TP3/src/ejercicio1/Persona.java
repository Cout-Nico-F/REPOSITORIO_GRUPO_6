package ejercicio1;

public class Persona implements Comparable<Persona> {
	
	private String nombre;
	private String apellido;
	private String dni;
	
	public Persona() {
		nombre = "Sin nombre";
		apellido = "Sin apellido";
		dni = "0";
	}
	public Persona(String nombre,String apellido,String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public Persona(String lineaArchivo) {
		String[] propiedades = lineaArchivo.split("-");
		if (propiedades.length == 3) {
			nombre = propiedades[0].trim();
			apellido = propiedades[1].trim();
			dni = propiedades[2].trim();
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	//Ordena los datos de la A - Z
	@Override
	public int compareTo(Persona persona) {
		//Criterio de ordenamiento de apellidos
		int retorno=0;
		if(this.apellido.compareToIgnoreCase(persona.apellido)>0){
			retorno=1;
		} else if (this.apellido.compareToIgnoreCase(persona.apellido)<0){
			retorno=-1;
		} else if(this.nombre.compareToIgnoreCase(persona.nombre)>0){ 
			//si son iguales los apellidos comparo los nombres
			retorno= 1;
		} else if (this.nombre.compareToIgnoreCase(persona.nombre)<0) {
			retorno= -1;
		} else if(this.dni.compareTo(persona.dni)<0) {
			retorno= -1;
		} else if(this.dni.compareTo(persona.dni)>0) {
			retorno= 1;
		}
		return retorno;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return nombre + " - " + apellido + " - " + dni;
	}
	
	void verificarDniInvalido() throws DniInvalidoException {
		
		try {
			Integer.parseInt(dni);
		} catch (NumberFormatException e) {
			throw new DniInvalidoException(DniInvalidoException.FORMATO_NO_VALIDO);
		}
		
		if (dni.length() != 8) {
			throw new DniInvalidoException(DniInvalidoException.LONGITUD_NO_VALIDA);
		}
	}
	
}
