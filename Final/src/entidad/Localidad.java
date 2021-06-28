package entidad;

public class Localidad {
	int idLocalidad;
	Provincia provincia;
	String nombre;
	
	public Localidad(int idLocalidad, Provincia provincia, String nombre) {
		super();
		this.idLocalidad = idLocalidad;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	
	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
