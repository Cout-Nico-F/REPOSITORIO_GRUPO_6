package ejercicio1;

public class Principal {

	public static void main(String[] args) {

		Empleado empleado1 = new Empleado();
		empleado1.setEdad(21);
		empleado1.setNombre("Juan");
		System.out.println(empleado1.toString());

		Empleado empleado2 = new Empleado();
		empleado2.setEdad(21);
		empleado2.setNombre("Juan");
		System.out.println(empleado2.toString());

		Empleado empleado3 = new Empleado("Ana Alvarez", 30);
		System.out.println(empleado3.toString());

	}
}
