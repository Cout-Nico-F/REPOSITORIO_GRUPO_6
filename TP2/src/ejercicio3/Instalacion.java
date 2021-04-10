package ejercicio3;

public class Instalacion {
	private String nombre;
	private int tipoInstalacion;
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipoInstalacion() { //act 3.1
		return tipoInstalacion;
	}
	public void setTipoInstalacion(int tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}
	
	//constructores
	public Instalacion(String nombre, int tipoInstalacion) {
		super();
		this.nombre = nombre;
		this.tipoInstalacion = tipoInstalacion;
	}
	
	public Instalacion() {
		super();
		nombre = "default";
		tipoInstalacion = 1;
	}
	
	
	
	
	
	

}
