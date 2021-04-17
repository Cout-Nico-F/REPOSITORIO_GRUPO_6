package ejercicio1;

import java.util.ArrayList;
import java.util.ListIterator;

public class mainEjercicio1_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Profesor> lProfesores = new ArrayList<Profesor>(5);
	
		lProfesores.add(new Profesor("Alonso",(byte)33,"Profesor",10));
		lProfesores.add(new Profesor("Ramon",(byte)18,"Profesor",3));
		lProfesores.add(new Profesor("Pepe",(byte)21,"Profesor",4));
		lProfesores.add(new Profesor("Fulano",(byte)16,"Profesor",1));
		lProfesores.add(new Profesor("Florencia",(byte)17,"Profesor",2));

		//Esta dentro de llaves (bloque de código) para que el GC libere la memoria del iterador luego de mostrarlo
		{ListIterator<Profesor> it = lProfesores.listIterator();
			while(it.hasNext())
			{
					Profesor profeIterado = it.next();
					System.out.println(profeIterado.toString());
			}
		}
	}

}
