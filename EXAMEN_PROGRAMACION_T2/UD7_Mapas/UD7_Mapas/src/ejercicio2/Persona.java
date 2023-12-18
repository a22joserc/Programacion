package ejercicio2;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private int telefono;
	
	public Persona(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + " - Teléfono: " + this.getTelefono();
	}
	
	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}
}
