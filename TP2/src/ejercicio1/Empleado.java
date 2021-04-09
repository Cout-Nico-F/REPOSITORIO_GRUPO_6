package ejercicio1;

public class Empleado {

	private static int contID = 1000;
	private final int id;
	private String nombre;
	private byte edad; 
	// Ctor
	
	public Empleado() {
		id = contID++;  
		nombre = "sin nombre";
		edad = 99;

	}

	public Empleado(String nombre, byte edad) { 
		id = contID++;
		this.nombre = nombre;
		this.edad = edad;
	}

	// Getters & Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}
	
	//Metodo ToString()
	@Override
	public String toString() {
		return "Legajo: " + id + ", Empleado: " + nombre + ", edad: " + edad + '.';
	}

	public static int devuelveProximoID() {
		return contID;
	}
}