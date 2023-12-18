package ejercicio1;

public abstract class Vehiculo {
	private double pvp;
	private String matricula;
	
	// Constructor
	
	public Vehiculo(double pvp, String matricula) {
		this.pvp = pvp;
		this.matricula = matricula;
	}
	
	public double calcularIva() {
		return this.pvp * 0.21;
	}
	
	public double getPvp() {
		return pvp;
	}
	
	public abstract double calcularDescuento();
}
