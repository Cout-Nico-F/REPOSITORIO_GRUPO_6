package entidad;
import java.util.Date;

public class Cliente {
	
	private int dni;
	private String cuil;
	private Nacionalidad nacionalidad;
	private Localidad localidad;
	private String nombre;
	private String apellido;
	private String sexo;
	private Date fechaNacimiento;
	private String direccion;
	private String correoElectronico;
	private Usuario usuario;
	private String telefonoFijo;
	private String celular;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", usuario=" + usuario.getNombreUsuario() + ", nacionalidad=" + nacionalidad.getNombre()
				+ ", idLocalidad=" + localidad.getNombre() + ", cuil=" + cuil + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
				+ ", correoElectronico=" + correoElectronico + "]";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
