package ejercicio2;

public class Persona {
	// Variables de clase
	private String nombre;
	private String direccion;
	private String dni;
	
	// Constructor por paso de parámetros
	public Persona(String nombre, String direccion, String dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
	}
	
	// SETTERS
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	// GETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getDni() {
		return dni;
	}
	
	// toString()

	@Override
	public String toString() {
		return "Persona - Nombre: " + this.getNombre() + ", Direccion: " + this.getDireccion() + ", DNI: " + this.getDni();
	}
	

}
