package ejercicio3;

public abstract class Edificio {
	private String nombre;
	private String ubicacion;
	private double superficie;
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
		
	public double getSuperficie() {
		return this.superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + ", ubicacion: " + ubicacion;
	}
	
	public abstract double getSuperficieEdificio();
}
