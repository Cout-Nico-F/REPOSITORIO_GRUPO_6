package ejercicio3;

import java.util.ArrayList;
import java.util.ListIterator;

public class mainEjercicio3 {

	public static void main(String[] args) {

		ArrayList<Edificio> listaConstrucciones = new ArrayList<Edificio>(5);
		
		listaConstrucciones.add(new Polideportivo("River", 150, "Nuñez", 1));
		listaConstrucciones.add(new Polideportivo("Boca", 100, "La Boca", 1));
		listaConstrucciones.add(new Polideportivo("Club Amigos", 120, "Palermo",2));
		listaConstrucciones.add(new Oficinas(5, "Sede Central", 50, "Microcentro"));
		listaConstrucciones.add(new Oficinas(2, "Sucursal Pacheco", 40, "Pacheco"));
		
		ListIterator<Edificio> it = listaConstrucciones.listIterator();
		while(it.hasNext()) {
			Edificio edificio = it.next();
			System.out.println(edificio.toString());
		}
	}
}