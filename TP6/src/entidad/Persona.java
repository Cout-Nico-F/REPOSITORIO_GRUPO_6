package entidad;

public class Persona 
{
	private int dni;
	private String nombre;
	private String apellido;

	public Persona()
	{
		
	}	
			
	public Persona(int idPersona, String nombre, String apellido)
	{
		this.dni = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getDni() 
	{
		return this.dni;
	}

	public void setDni(int dni) 
	{
		this.dni = dni;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return this.apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
}
