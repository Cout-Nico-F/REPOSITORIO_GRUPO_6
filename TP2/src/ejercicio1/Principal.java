package ejercicio1;

public class Principal {
	public static void main(String[] args) {
		Profesor p1 = new Profesor("Ana", (byte) 40, "Profesor", 20);
		Profesor p2 = new Profesor("Ana", (byte) 40, "Profesor", 20);
		if (p1.equals(p2)) {
			System.out.println("Es el mismo profesor.");
		}
	}
}