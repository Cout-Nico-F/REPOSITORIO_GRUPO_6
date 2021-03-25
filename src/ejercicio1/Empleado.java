package ejercicio1;

public class Empleado {

	private static int contID = 999;
	private final int id;
	private String nombre;
	private int edad;

	// Ctor
	public Empleado() {
		id = ++contID;
		nombre = "sin nombre";
		edad = 99;

	}

	public Empleado(String nombre, int edad) {
		id = ++contID;
		this.nombre = nombre;
		this.edad = edad;
	}

	// Getters & Setters

	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	int getEdad() {
		return edad;
	}

	void setEdad(int edad) {
		this.edad = edad;
	}

	// Metodo ToString()
	@Override
	public String toString() {
		return "Empleado: " + nombre + ", edad: " + edad + ", legajo: " + id + '.';
	}

	public static int devuelveProximoID() {
		return contID + 1;
	}
}
