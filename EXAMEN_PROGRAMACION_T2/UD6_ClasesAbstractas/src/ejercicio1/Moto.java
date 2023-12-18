package ejercicio1;

public class Moto extends Vehiculo {
	private int numTiempos;
	
	public Moto(int numTiempos, String matricula, double pvp) {
		super(pvp, matricula);
		this.numTiempos = numTiempos;
	}
	
	public double calcularDescuento() {
		return (this.getPvp()-this.numTiempos)*0.75;
	}

}
