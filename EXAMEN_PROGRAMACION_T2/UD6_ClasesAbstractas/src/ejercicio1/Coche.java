package ejercicio1;

public class Coche extends Vehiculo {
	
	private String tipo;
	
	public Coche(String tipo, String matricula, double pvp) {
		super(pvp, matricula);
		this.tipo = tipo;
	}
	
	
	
	public double calcularDescuento() {
		return this.getPvp()*0.75;
	}
	

}
