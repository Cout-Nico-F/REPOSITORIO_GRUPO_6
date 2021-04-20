package ejercicio1;

public class Principal {

	//Lee el archivo personas.txt, por cada registro llama al metodo verificarDNI y lo guarda en una lista solo si es valido
	//Escribe a resultado.txt.
	public static void main(String[] args) {
		
		
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
