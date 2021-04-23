package ejercicio1;

public class Dni {
	
	public Dni() {
		
	}
	
	public static boolean validarDni(String dni) throws DniInvalidoException {
		
		Boolean auxLongitud;


		if (dni.length() == 8) {
			auxLongitud = true;
			
		} else {
			throw new DniInvalidoException(DniInvalidoException.LONGITUD_NO_VALIDA);
		}
		
		int DniException = 0;
		
		try {
			DniException = Integer.parseUnsignedInt(dni);

		} catch (NumberFormatException e) {
			throw new DniInvalidoException(DniInvalidoException.FORMATO_NO_VALIDO);
		}
				
		if (auxLongitud && DniException != 0) {
			return true;
		} return false;
	}
}


