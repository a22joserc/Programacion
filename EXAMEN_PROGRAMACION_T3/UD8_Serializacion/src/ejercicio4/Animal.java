package ejercicio4;

import java.io.Serializable;
import java.util.Objects;

public abstract class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int edad;
	
	
	public Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	@Override
	public String toString() {
		return "Animal -> [Nombre: " + this.getNombre() + " - Edad: " + this.getEdad();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}

	public abstract void habla();
	
	public abstract void getTipo();
	
	// public abstract Animal getTipo();
	

}
