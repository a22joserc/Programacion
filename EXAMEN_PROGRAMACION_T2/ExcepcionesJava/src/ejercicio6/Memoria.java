package ejercicio6;

public class Memoria {
	// Variables de clase
	private final static int MIN_MEM = 2;
	private int capacidad;
	private final String TIPO = "DDR4";
	private int velocidad;
	
	// Constructor por paso de parámetros
	public Memoria(int capacidad, int velocidad) {
		if (capacidad < MIN_MEM) {
			this.capacidad = MIN_MEM;
		}
		else {
			this.capacidad = capacidad;
		}
		this.velocidad = velocidad;
	}
	
	// GETTERS
	
	public int getCapacidad() {
		return this.capacidad;
	}

	public int getVelocidad() {
		return this.velocidad;
	}
	
	public String getTipo() {
		return this.TIPO;
	}
	
	// SETTERS
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	
	// mostrarInfo()
	
	public void mostrarInfo() {
		System.out.println("**** Características memoria ****");
		System.out.println("Capacidad: " + this.getCapacidad());
		System.out.println("Velocidad: " + this.getVelocidad());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("*********************************");
	}
	
	@Override
	public String toString() {
		return "Memoria -> Capacidad: " + this.getCapacidad() + " GB, Velocidad: " + this.getVelocidad() + " MB/s, Tipo: " + this.getTipo();
	}

}
