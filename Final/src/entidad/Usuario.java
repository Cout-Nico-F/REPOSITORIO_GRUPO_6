package entidad;

public class Usuario {
	
	private string nombreUsuario;
	private string contrasenia;
	
	public Usuario() {
		
	}
	
	public Usuario(string nombreUsuario,string contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public string getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(string nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public string getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(string contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
