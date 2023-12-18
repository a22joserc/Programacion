package ejercicio3;

public class Circulo extends Figura {
	// Variables de clase
	private double radio;
	
	//Constructor por parámetros
	public Circulo(double radio, String color) {
		super(color);
		this.setRadio(radio);
		
	}
	
	// Setter
	public void setRadio(double radio) {
		this.radio = radio;
	}

}
