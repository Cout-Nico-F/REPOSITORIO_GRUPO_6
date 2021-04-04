package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado();
		empleado1.setEdad((byte)21);
		empleado1.setNombre("Juan");
		System.out.println(empleado1.toString());
		System.out.println("El próximo ID será el número " + Empleado.devuelveProximoID());

		Empleado empleado2 = new Empleado();
		empleado2.setEdad((byte)21);
		empleado2.setNombre("Juan");
		System.out.println(empleado2.toString());
		System.out.println("El próximo ID será el número " + Empleado.devuelveProximoID());

		Empleado empleado3 = new Empleado("Ana Alvarez", (byte)30);
		System.out.println(empleado3.toString());
		System.out.println("El próximo ID será el número " + Empleado.devuelveProximoID());
		
		Empleado empleado4 = new Empleado("Edgar Lopez", (byte)52);
		System.out.println(empleado4.toString());
		System.out.println("El próximo ID será el número " + Empleado.devuelveProximoID());
		
		Empleado empleado5 = new Empleado ("Johnathan Perez", (byte) 43);
		System.out.println(empleado5.toString());
		System.out.println("El próximo ID será el número " + Empleado.devuelveProximoID());
	}
}