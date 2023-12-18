package ejercicio1;

public class Sobremesa extends Ordenador {
	private String tipoCaja;
	
	public Sobremesa(String procesador, int memoria, String tipoCaja) {
		super(procesador, memoria);
		this.tipoCaja=tipoCaja;
	}
	
	// GETTER
	public String getTipoCaja() {
		return tipoCaja;
	}
	
	// SETTER
	
	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}
	
	@Override
	public String toString() {
		return "Sobremesa - Memoria: " + this.getMemoria() + ", Procesador: " + this.getProcesador() + ", Peso: " + this.getTipoCaja();
	}

}
