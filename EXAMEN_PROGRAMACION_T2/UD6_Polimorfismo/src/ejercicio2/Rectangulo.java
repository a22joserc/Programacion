package ejercicio2;

public class Rectangulo extends Figura {
	
	public double base;
	public double altura;
	
	public Rectangulo(double base, double altura, String color) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double area() {
		return this.base*this.altura;
	}


}
