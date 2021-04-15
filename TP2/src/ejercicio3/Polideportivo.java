package ejercicio3;

public class Polideportivo extends Edificio implements I_Instalacion {

	public int tipoDeInstalacion;
	
	@Override
	public double getSuperficieEdificio()
	{
		return super.getSuperficie();
	}
	
	@Override
	public int getTipoDeInstalacion() { //act 3.1
		return tipoDeInstalacion;
	}
	
	
	//constructores
	public Polideportivo() {
		super();
		tipoDeInstalacion=1;
	}
	
	public Polideportivo(String nombre, double superficie,String ubicacion, int tipoDeInstalacion) {
		super();
		this.setNombre(nombre);
		this.setSuperficie(superficie);
		this.setUbicacion(ubicacion);
		this.tipoDeInstalacion = tipoDeInstalacion;
	}
	
	public void setTipoDeInstalacion(int tipoDeInstalacion) {
		this.tipoDeInstalacion=tipoDeInstalacion;
	}

	@Override
	public String toString() {
		return "Polideportivo - " + super.toString() + ", superficie: " + getSuperficieEdificio() + ", tipo de Instalacion:" + getTipoDeInstalacion();
	}
}
