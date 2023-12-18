package Ejercicio6;

public class Circulo extends Figura {
	private double radio;
	
	public Circulo(double radio, String color) {
		super(color);
		this.radio=radio;
	}
	
	@Override
	public double area() {
		return Math.PI*Math.pow(this.radio, 2);
	}
}
