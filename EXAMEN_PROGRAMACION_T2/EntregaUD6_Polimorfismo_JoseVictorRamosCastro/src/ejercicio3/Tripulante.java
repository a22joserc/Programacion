package ejercicio3;

public abstract class Tripulante {
	
	// Variables de clase
	protected int numCarnet;
	protected int edad;
	protected int tiempoEmpresa;
	protected String nombre; 
	protected String telefono;
	protected char sexo;
	protected Barco barco;
	protected Gps posicion;
	
	// Constructor por paso de parámetros
	
	public Tripulante(int numCarnet, int edad, int tiempoEmpresa, String nombre, String telefono, char sexo, Barco barco, Gps posicion) {
		this.numCarnet = numCarnet;
		this.edad = edad;
		this.tiempoEmpresa = tiempoEmpresa;
		this.nombre = nombre;
		this.telefono = telefono;
		this.sexo = sexo;
		this.barco = barco;
		this.posicion = posicion;
	}
	
	// GETTERS
	
	public int getNumCarnet() {
		return numCarnet;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getTiempoEmpresa() {
		return tiempoEmpresa;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public Barco getBarco() {
		return barco;
	}
	
	public Gps getPosicion() {
		return posicion;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + "\nEdad: " + this.getEdad() + "\nNúm Carnet: " + this.getNumCarnet() + "\nTiempo Empresa: " + this.getTiempoEmpresa() + "\nTeléfono: " + this.getTelefono() + "\nSexo: " + this.getSexo() + "\nBarco: " + this.getBarco().getNombre() + "\nGPS: " + this.getPosicion().toString();
	}
	
	
	// Métodos abstractos
	
	public abstract void sueldo();
	
	public abstract void mostrarInfo();
}

