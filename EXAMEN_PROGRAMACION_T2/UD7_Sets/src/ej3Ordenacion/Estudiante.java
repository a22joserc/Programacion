package ej3Ordenacion;

public class Estudiante {
	
	private String nombre;
	private int edad;
	private char sexo;

	public Estudiante(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " - Edad: " + this.edad + " - Sexo: " + this.sexo;
	}
}
