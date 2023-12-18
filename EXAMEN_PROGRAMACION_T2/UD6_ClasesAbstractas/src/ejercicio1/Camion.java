package ejercicio1;

public class Camion extends Vehiculo {
	private int numRuedas;
	
	public Camion (int numRuedas, double pvp, String matricula) {
		super(pvp, matricula);
		this.numRuedas = numRuedas;
		
	}
	
	@Override
	public double calcularDescuento() {
		return this.getPvp()*0.8*1.1*this.numRuedas;
	}
}
