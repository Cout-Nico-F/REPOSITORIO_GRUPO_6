package ejercicio1;

import java.io.IOException;

public class DniInvalidoException extends IOException {
	
	public static final String LONGITUD_NO_VALIDA = "La longitud debe ser de 8 caracteres.";
	
	public static final String FORMATO_NO_VALIDO = "El Dni debe estar conformado por 8 caracteres entre el 0 al 9.";
	
	private String mensaje;

	public DniInvalidoException() {	
	}
	
	public DniInvalidoException(String exception) {
		this.mensaje=exception;
	}

	@Override
	public String getMessage() {

		return mensaje + "\n";
	}

	public String getMensaje() {
		return mensaje;
	}
}
