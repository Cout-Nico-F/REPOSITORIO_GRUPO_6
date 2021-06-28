package entidad;

public class Usuario {
	
	private int idUsuario;
	private String nombreUsuario;
	private String contrasenia;
	private boolean esAdmin;
	
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
	
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	public boolean getEsAdmin () {
		return this.esAdmin;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
