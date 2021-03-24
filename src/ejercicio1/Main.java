package ejercicio1;

public class Main {
	
	public static void main(String[] args) {
		
		Empleado x = new Empleado();
		x.setEdad(21);
		x.setNombre("Juan");
		System.out.println(x.toString());
		
		Empleado x2 = new Empleado();
		x2.setEdad(21);
		x2.setNombre("Juan");
		System.out.println(x2.toString());
	}
}
