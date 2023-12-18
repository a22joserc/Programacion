package ejercicio1;

public class Ordenador {
	private String procesador;
	private int memoria;
	
	// Constructor por paso de parámetros
	
	public Ordenador(String procesador, int memoria) {
		this.procesador = procesador;
		this.memoria = memoria;
	}
	
	// SETTERS
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	// GETTERS
	
	public int getMemoria() {
		return memoria;
	}
	
	public String getProcesador() {
		return procesador;
	}
}
