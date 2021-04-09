package ejercicio1;

public class Profesor extends Empleado {
	String cargo;
	int antiguedadDocente;
	
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
