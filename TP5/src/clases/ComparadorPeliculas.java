package clases;

import java.util.Comparator;

public class ComparadorPeliculas implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		
		return p1.getNombre().compareTo(p2.getNombre());
	}
	

}
