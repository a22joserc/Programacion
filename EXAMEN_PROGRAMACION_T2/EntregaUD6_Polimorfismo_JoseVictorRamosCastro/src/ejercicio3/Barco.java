package ejercicio3;

public class Barco {
	
	//Variables de clase
	private String nombre;
	private String tipo;
	private int capacidadPasajeros;
	private int capacidadCarga;
	
	// Constructor paso de parámetros
	public Barco(String nombre, String tipo, int capacidadPasajeros, int capacidadCarga) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.capacidadPasajeros = capacidadPasajeros;
		this.capacidadCarga = capacidadCarga;
	}
	
	
	// GETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getCapacidadPasajeros() {
		return capacidadPasajeros;
	}
	
	public int getCapacidadCarga() {
		return capacidadCarga;
	}
	
	// toString
	@Override
	public String toString() {
		return "INFO BARCO -> Nombre: " + this.getNombre() + "; Tipo: " + this.getTipo() + "; Capacidad Pasajeros: " + this.getCapacidadPasajeros() + "; Capacidad Carga: " + this.getCapacidadCarga();
	}

}
