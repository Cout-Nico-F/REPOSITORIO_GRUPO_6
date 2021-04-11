package ejercicio3;

public class Oficinas extends Edificio{

	public int cantidadOficinas;
	

	public Oficinas() {
		super();
		cantidadOficinas=9999;
		
	}
	public Oficinas(int Cant, String nombre, double superficie,String ubicacion) {
		
		super();
		this.setNombre(nombre);
		this.setSuperficieEdificio(superficie);
		this.setUbicacion(ubicacion);
		
		cantidadOficinas=Cant;
	}
	
	
}
