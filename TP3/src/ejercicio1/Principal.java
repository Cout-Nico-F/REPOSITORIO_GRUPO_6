package ejercicio1;

public class Principal {

	//Lee el archivo personas.txt, por cada registro llama al metodo verificarDNI y lo guarda en una lista solo si es valido
	//Escribe a resultado.txt.
	public static void main(String[] args) {
		
		//Punto 3 
		Archivo archivo = new Archivo();
		archivo.setRuta("Resultado.txt");
		
		if(archivo.existeArchivo()) {
			System.out.println("Existe archivo");
		}
		else {
			System.out.println("No existe archivo");
			archivo.crearArchivo();
		}
		
	}
	
	
	void VerificarDniInvalido () throws DniInvalidoException {
		//verifica que contenga solo numeros
		//convierte un int en un string y compara cada caracter
		//puede usar el codigo ascii para saber si es numero
		
		if (/*tiene caracteres que no son numeros*/) {
			throw new DniInvalidoException();
		}
	}
	
	
	
}
