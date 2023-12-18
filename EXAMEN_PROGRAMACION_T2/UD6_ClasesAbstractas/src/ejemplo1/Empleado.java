package ejemplo1;

public abstract class Empleado {
	String nombre;
	int ant;
	int sueldoBase=1000;
	
	public Empleado(String nombre, int ant) {
		this.nombre = nombre;
		this.ant = ant;
	 }
	 
	abstract int calcularNomina();
}
