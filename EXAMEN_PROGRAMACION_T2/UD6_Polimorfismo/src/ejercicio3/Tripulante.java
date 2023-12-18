package ejercicio3;

public abstract class Tripulante {
	
	protected int numCarnet;
	protected int edad;
	protected int tiempoEmpresa;
	protected String nombre;
	protected String tipoTelefono;
	protected char sexo;
	protected Barco tipoBarco;
	
	
	public Tripulante(int numCarnet, int edad, int tiempoEmpresa, String nombre, String tipoTelefono, char sexo, Barco tipoBarco) {
		this.numCarnet = numCarnet;
		this.edad = edad;
		this.tiempoEmpresa = tiempoEmpresa;
		this.nombre = nombre;
		this.tipoTelefono = tipoTelefono;
		this.sexo = sexo;
		this.tipoBarco = tipoBarco;	
	}
	
	
	public abstract double sueldo();
	
	public abstract void mostrarDatos();
	

}
