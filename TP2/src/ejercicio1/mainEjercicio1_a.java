package ejercicio1;

import java.util.ArrayList;

public class mainEjercicio1_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Profesor> lProfesores = new ArrayList<Profesor>(5);
		
		//Se me hace raro que tenga que castear el numero si esta dentro del rango
		//del tipo byte que es entre -128 y 128
		
		lProfesores.add(new Profesor("Alonso",(byte)33,"Profesor",10));
		lProfesores.add(new Profesor("Ramon",(byte)18,"Profesor",3));
		lProfesores.add(new Profesor("Pepe",(byte)21,"Profesor",4));
		lProfesores.add(new Profesor("Fulano",(byte)16,"Profesor",1));
		lProfesores.add(new Profesor("Florencia",(byte)17,"Profesor",2));
		
		for(Profesor x: lProfesores) {
			System.out.println(x);
		}
		
	}

}
