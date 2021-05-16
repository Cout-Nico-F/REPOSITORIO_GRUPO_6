package clases;

public class Pelicula {

	private static int count = 0;
	private final int id;
	private String nombre;
	private Categoria categoria;
	
	public Pelicula() {
		id = count++;
	}
	
	public Pelicula(String nombre, Categoria categoria) {
		id = count++;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public static int getCount() {
		return count;
	}
	
}