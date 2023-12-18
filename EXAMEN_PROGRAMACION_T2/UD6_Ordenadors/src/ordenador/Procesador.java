package ordenador;

public class Procesador {
	// Variables de clase
	private String modelo;
	private float velocidad;
	
	// Constructor por paso de parámetros
	public Procesador(String modelo, float velocidad) {
		this.modelo = modelo;
		this.velocidad = velocidad;
	}
	
	// Getters
	
	public String getModelo() {
		return this.modelo;
	}
	
	public float getVelocidad() {
		return this.velocidad;
	}
	
	// SETTERS
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	// mostrarInfo
	
	public void mostrarInfo() {
		System.out.println("**** Características procesador ****");
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Velocidad: " + this.getVelocidad());
		System.out.println("*********************************");
	}
	
	@Override
	public String toString() {
		return "Procesador -> Modelo: " + this.getModelo() + ", Velocidad: " + this.getVelocidad();
	}

}
