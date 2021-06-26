package entidad;

public class Usuario {
	
	private String nombreUsuario;
	private String contrasenia;
	private int tipoUsuario;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombreUsuario,String contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void setTipoUsuario(int tipo) {
		this.tipoUsuario = tipo;
	}
	
	public int getTipoUsuario () {
		return this.tipoUsuario;
	}
	
}
