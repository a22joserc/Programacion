package ejercicio6;

public class Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	private String nacionalidad;
	
	public Persona(String nombre, String apellidos, String dni, int edad, String nacionalidad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.nacionalidad = nacionalidad;	
	}
	
	@Override
	public String toString() {
		/*if (this !=null ) {
			return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", DNI: " + this.dni + ", Edad: " + this.edad + ", Nacionalidad: " + this.nacionalidad;
		}*/
		return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", DNI: " + this.dni + ", Edad: " + this.edad + ", Nacionalidad: " + this.nacionalidad;

	}
}
