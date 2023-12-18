package ejercicio6;


public class DiscoDuro {
	// Variables de clase
	private float capacidad;
	private String tipo;
	private int velocidad;
	
	// Constructor por paso de parámetros
	public DiscoDuro(float capacidad, String tipo, int velocidad) {
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.velocidad = velocidad;
	}
	
	// Método estático para generar un objeto con caracteríticas predefinidas
	public static DiscoDuro creaDiscoDuro() {
		return new DiscoDuro(1024f,"ssd",3500);
	}
	
	// GETTERS
	
	public float getCapacidad() {
		return this.capacidad;
	}
	public String getTipo() {
		return this.tipo;
	}
	public int getVelocidad() {
		return this.velocidad;
	}
	
	// SETTERS
	
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	// mostrarInfo
	
	public void mostrarInfo() {
		System.out.println("**** Características del DISCO DURO ****");
		System.out.println("Capacidad: " + this.getCapacidad());
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Velocidad: " + this.getVelocidad());
		System.out.println("*********************************");
	}
	
	@Override
	public String toString() {
		return "Disco Duro -> Capacidad: " + this.getCapacidad() + " GB, Velocidad: " + this.getVelocidad() + " MB/s, Tipo: " + this.getTipo();
	}
	
}
