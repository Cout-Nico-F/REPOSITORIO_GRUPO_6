package entidad;

public class Localidad extends Provincia {
	
	private int idLocalidad;
	private String nombre;
	
	public Localidad() {
		super();
		this.nombre = "";
	}
	
	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	


}
