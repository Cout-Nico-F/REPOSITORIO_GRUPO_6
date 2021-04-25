package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Archivo {
	
	private String ruta; //Resultado.txt para que se cree dentro de la carpeta ejercicio1
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existeArchivo() {
		File archivo = new File(ruta);
		if(archivo.exists()) {
			return true;
		}
		return false;
	}

	public boolean crearArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta,true);
			escritura.write("");
			escritura.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* - Se trabaja con un Set asi no se aceptan datos duplicados
	 * - Se llama a verificarDniInvalido y si tira una excepcion no se agrega la persona */
	//Cambio al TreeSet para ingresar los nombres ya ordenados en el set
	//sin necesidad de un ArraySet
	public TreeSet<Persona> leerPersonas() {
		//Set<Persona> resultado = new HashSet<Persona>();
		TreeSet<Persona> resultado = new TreeSet<Persona>();
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
		    String linea = "";
		    Persona persona = new Persona();
			while (linea != null) {
				try {
					// No entra la primera vez y se ignoran las lineas vacias
					if (linea != "") {
						persona = new Persona(linea);
						persona.verificarDniInvalido();
						resultado.add(persona);
					}
				} catch (DniInvalidoException e) {
					System.out.println("No se agrego a " + persona.getNombre() + " " + persona.getApellido() + 
							" porque su DNI (" + persona.getDni() + ") es invalido.");
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			informarInexistente();
		}
		return resultado;
	}
	
	public void escribirLinea(String linea) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(linea);
			miBuffer.newLine();
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void informarInexistente() {
		System.out.println("No se encontro el archivo " + ruta);
	}
	
	public void informarVacio() {
		System.out.println("El archivo " + ruta + " esta vacio");
	}
}
