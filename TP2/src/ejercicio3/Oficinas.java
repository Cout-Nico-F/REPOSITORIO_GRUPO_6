package ejercicio3;

public class Oficinas extends Edificio{

	public int cantidadOficinas;
	
	@Override
	public double getSuperficieEdificio()
	{
		return super.getSuperficie() * this.cantidadOficinas;
	}

	public Oficinas() {
	}
	
	public Oficinas(int Cant, String nombre, double superficie,String ubicacion) {
		
		super();
		this.setNombre(nombre);
		this.setSuperficie(superficie);
		this.setUbicacion(ubicacion);
		
		cantidadOficinas=Cant;
	}

	public int getCantidadOficinas() {
		return cantidadOficinas;
	}

	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}

	@Override
	public String toString() {
		return "Oficinas - " + super.toString() + ", superficie: " + getSuperficieEdificio() + ", cantidad oficinas: " + cantidadOficinas;
	}
}