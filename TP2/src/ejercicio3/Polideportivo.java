package ejercicio3;

public class Polideportivo extends Edificio implements I_Instalacion {

	public int tipoInstalacion;
	
	public int getTipoDeInstalacion() { //act 3.1
		return tipoDeInstalacion;
	}
	
	
	//constructores
	public Polideportivo() {
		
		super();

	
		tipoInstalacion=this.getTipoDeInstalacion();
	}
	
	public Polideportivo(String nombre, double superficie,String ubicacion) {
		
		super();
		this.setNombre(nombre);
		this.setSuperficieEdificio(superficie);
		this.setUbicacion(ubicacion);
		
		tipoInstalacion=this.getTipoDeInstalacion();
		
	}
	

	
	
}
