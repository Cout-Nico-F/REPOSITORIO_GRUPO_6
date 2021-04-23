package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {	

	public static void main(String[] args) {
		
		try {
			String DNI = JOptionPane.showInputDialog("Ingrese el número de DNI: ");
			Dni.validarDni(DNI);
			JOptionPane.showMessageDialog(null,"Carga exitosa!");
		} catch (DniInvalidoException e) {
			JOptionPane.showMessageDialog(null, "Carga incorrecta. \n" + e.getMensaje());
			e.printStackTrace();
		}
		
		//Lee el archivo personas.txt, por cada registro llama al metodo verificarDNI y lo guarda en una lista solo si es valido
		//Escribe a resultado.txt.
		// Punto 2
		Archivo archivoLectura = new Archivo();
		archivoLectura.setRuta("Personas.txt");
		
		if (!archivoLectura.existeArchivo()) {
			archivoLectura.informarInexistente();
		} else {
			List<Persona> personas = (new ArrayList<Persona>(archivoLectura.leerPersonas()));
			
			if (personas.isEmpty()) {
				archivoLectura.informarVacio();
			} else {
				// Se ordena por apellido alfabeticamente
				Collections.sort(personas, (p1, o2) -> (p1.getApellido().compareTo(o2.getApellido())));
				
				//Punto 3
				Archivo archivoEscritura = new Archivo();
				archivoEscritura.setRuta("Resultado.txt");
				
				if (!archivoEscritura.existeArchivo()) archivoEscritura.crearArchivo();
				
				for (Persona persona: personas) {
					archivoEscritura.escribirLinea(persona.toString());	
				}
			}
		}
	}
}
