package ejercicio1;

import java.io.*;

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
	
	public void escribe_letra_x_letra(String frase) {
		try {
			FileWriter fw = new FileWriter(ruta,true); //true para que si el archivo ya esta creado no reemplace su contenido
			for(int x = 0; x < frase.length(); x++) {
			
			}
			//fw.write(str);
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_letra_x_letra() {
		FileReader fr;
		try {
			fr = new FileReader(ruta);
			int c = fr.read();
			while(c != 1) {
				char letra = (char) c;
				System.out.println(letra);
				c = fr.read();
			}
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
  	}
}
