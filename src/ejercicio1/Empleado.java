package ejercicio1;

public class Empleado {

	private static int contID = 1000; //Le cambié a 1000, ya que necesitamos empezarlo en el numero que vamos a usar, no tiene sentido un numero menos para despues sumarle 1 en la primera instrucción
	private final int id;
	private String nombre;
	private byte edad; // le cambié el tipo de dato a byte, para no consumir recursos innecesarios (nadie debería vivir más de 127 años jaja no sería justo)

	// Ctor
	
	public Empleado() {
		id = contID++;  //ahora sería contID++ ya que primero asigna y luego actualiza el contador
		nombre = "sin nombre";
		edad = 99;

	}

	public Empleado(String nombre, byte edad) { //le cambié el tipo de dato a byte ya que la property es un tipo de dato Byte
		id = contID++; //mismo que en el otro constructor
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

	public void setEdad(byte edad) { //mismo, ahora es byte y no int
		this.edad = edad;
	}
	
	// Metodo ToString()
	@Override
	public String toString() {
		return "Empleado: " + nombre + ", edad: " + edad + ", legajo: " + id + '.';
	}

	public static int devuelveProximoID() {
		return contID; //Ahora no hace falta sumarle +1, ya que se actualiza el contador estático al próximo ID en el propio constructor 
	}
}