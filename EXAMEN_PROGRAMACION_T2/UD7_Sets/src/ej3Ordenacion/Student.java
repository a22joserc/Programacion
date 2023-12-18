package ej3Ordenacion;

public class Student implements Comparable<Student> {
	
	private String nombre;
	private int edad;

	public Student(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " - Edad: " + this.edad;
	}
	
	@Override
	public int compareTo(Student s) {
		
		if (!this.getNombre().equals(s.getNombre())) {
			return this.getNombre().compareTo(s.getNombre());
		}
		
		return Integer.compare(this.getEdad(),s.getEdad());
	}
	
	

}
