package ejercicio3;

import java.util.Objects;

public class Alumno {
	
	private String nombre;
	private double notaMedia;
	
	public Alumno(String nombre, double notaMedia) {
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " - Nota Media: " + this.notaMedia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
