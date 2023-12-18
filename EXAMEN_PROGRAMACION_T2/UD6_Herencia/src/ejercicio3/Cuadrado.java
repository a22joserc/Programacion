package ejercicio3;

public class Cuadrado extends Figura {
	// Variables de clase
	private double lado;
	
	public Cuadrado(double lado, String color) {
		super(color);
		this.setLado(lado);
	}
	
	//SETTER
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	// GETTER
	
	public double getLado() {
		return lado;
	}

}
