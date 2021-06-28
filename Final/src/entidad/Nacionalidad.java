package entidad;

public class Nacionalidad {
	int idNacionalidad;
	String nombre;
	
	public Nacionalidad(int idNacionalidad, String nombre) {
		this.idNacionalidad = idNacionalidad;
		this.nombre = nombre;
	}
	
	public Nacionalidad() {
		// TODO Auto-generated constructor stub
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
