package ejercicio2;

public class Empleado extends Persona {
	// Variables de clase
	private double sueldo;
		
	// Constructor por paso de parámetros
	public Empleado(String nombre, String direccion, String dni, double sueldo) {
		super(nombre, direccion, dni);
		// this.sueldo = sueldo;
		this.setSueldo(sueldo); // Juan recomienda usar setters en vez de la nomenclatura del punto.
	}
	
	// SETTERS
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	// GETTERS
	
	public double getSueldo() {
		return sueldo;
	}
	
	// toString()
	@Override
	public String toString() {
		String str = super.toString();
		str = str.replaceFirst("Persona", "Empleado");
		return str + ", Sueldo: " + this.getSueldo();
	}


}
