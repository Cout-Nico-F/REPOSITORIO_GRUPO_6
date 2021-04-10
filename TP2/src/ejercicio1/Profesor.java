package ejercicio1;

public class Profesor extends Empleado implements Comparable<Profesor> {
	String cargo;
	int antiguedadDocente;

	// Contructors
	public Profesor() {
		super();
		cargo = "sin cargo";
		antiguedadDocente = 0;
	}

	public Profesor(String nombre, byte edad, String cargo, int antiguedadDocente) {
		super(nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public Profesor(int legajo, String nombre, byte edad, String cargo, int antiguedadDocente) {
		super(legajo, nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}

	// Encapsulamiento (Getters and Setters)
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

	// Sobreescritura del metodo toString() porque no hay metodo devuelveDatos()
	@Override
	public String toString() {
		return super.toString() + " Cargo: " + cargo + ", antiguedadDocente: " + antiguedadDocente + ".";
	}

	// Comparable<Profesor>
	@Override
	public int compareTo(Profesor o) {
		// TODO Auto-generated method stub
		if (o.getEdad() == this.getEdad()) {
			return 0;
		}
		if (o.getEdad() < this.getEdad()) {
			return 1;
		}
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + antiguedadDocente;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (antiguedadDocente != other.antiguedadDocente)
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		return true;
	}
}
