package ejercicio1;

import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Profesor> tProfesores = new TreeSet<Profesor>();
		
		Profesor p1 = new Profesor("Alonso",(byte)33,"Profesor",10);
		Profesor p2 = new Profesor("Ramon",(byte)18,"Profesor",3);
		Profesor p3 = new Profesor("Pepe",(byte)21,"Profesor",4);
		Profesor p4 = new Profesor("Fulano",(byte)16,"Profesor",1);
		Profesor p5 = new Profesor("Florencia",(byte)17,"Profesor",2);
		
		tProfesores.add(p1);
		tProfesores.add(p2);
		tProfesores.add(p3);
		tProfesores.add(p4);
		tProfesores.add(p5);
		
		//Recorre y muestra el TreeSet ordenado por edad de menor a mayor
		for(Profesor x: tProfesores) {
			System.out.println(x.toString());
		}
		
	}

}
