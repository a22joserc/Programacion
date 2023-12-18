package Ejercicio6;

public class Triangulo extends Figura {
	private double base;
	private double altura;
	
	public Triangulo(double base, double altura, String color){
		super(color);
		this.base=base;
		this.altura=altura;
	}
	
	@Override
	public double area() {
		return this.base * this.altura;
	}
}
