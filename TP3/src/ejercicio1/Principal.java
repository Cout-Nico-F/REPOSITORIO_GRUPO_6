package ejercicio1;

import java.util.TreeSet;

public class Principal {	

	public static void main(String[] args) {
		
		//Lee el archivo personas.txt, por cada registro llama al metodo verificarDNI y lo guarda en una lista solo si es valido
		//Escribe a resultado.txt.
		// Punto 2
		Archivo archivoLectura = new Archivo();
		archivoLectura.setRuta("Personas.txt");
		
		if (!archivoLectura.existeArchivo()) {
			archivoLectura.informarInexistente();
		} else {
			
			TreeSet<Persona> personas = new TreeSet<Persona>(archivoLectura.leerPersonas());
			
			if (personas.isEmpty()) {
				archivoLectura.informarVacio();
			} 
			
				
			//Punto 3
			Archivo archivoEscritura = new Archivo();
			archivoEscritura.setRuta("Resultado.txt");
			
			if (!archivoEscritura.existeArchivo()) archivoEscritura.crearArchivo();
			
			archivoEscritura.escribirArbolPersonas(personas);
		}
	}
}

