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
	
	public Empleado(int legajo, String nombre, byte edad) {
		id = legajo;
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

	// Metodo ToString()
	@Override
	public String toString() {
		return "Legajo: " + id + ", Empleado: " + nombre + ", edad: " + edad;
	}

	public static int devuelveProximoID() {
		return contID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + id;
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
		Empleado other = (Empleado) obj;
		if (edad != other.edad)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}