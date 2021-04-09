package ejercicio1;

public class Profesor extends Empleado {
	String cargo;
	int antiguedadDocente;
	
	//Contructors
	public Profesor() {
		super();
		cargo = "sin cargo";
		antiguedadDocente = 0;
	}
	public Profesor(String nombre,byte edad,String cargo,int antiguedadDocente) {
		super(nombre,edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	
	//Encapsulamiento (Getters and Setters)
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}
	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}
	
}
