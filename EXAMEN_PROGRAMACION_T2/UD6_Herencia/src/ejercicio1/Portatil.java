package ejercicio1;

public class Portatil extends Ordenador {
	private float peso;
	
	public Portatil(String procesador, int memoria, float peso) {
		super(procesador, memoria);
		this.peso = peso;
	}
	
	// GETTER
	public float getPeso() {
		return peso;
	}
	
	// SETTER
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Portatil - Memoria: " + this.getMemoria() + ", Procesador: " + this.getProcesador() + ", Peso: " + this.getPeso();
	}
}
