package ejercicio1;

public class Empleado {
	
	private static int nextId = 1000;
	private final int id;
	private String nombre;
	private int edad;
	
	
	//Ctor
	public Empleado(){
		id = nextId;
		nextId++;
		
		nombre = "No ingresado";
		edad = 0;
		
	}
	
	//Getters & Setters
	int getId() {
		return id;
	}
	
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
	
	//Metodo ToString()
	@Override
	public String toString() {
		return "Empleado: "+nombre+", edad: "+edad+" legajo: "+id;
	}
	
}
