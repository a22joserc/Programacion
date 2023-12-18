package ejercicio2;

public class Triangulo extends Figura {
	
	public double base;
	public double altura;
	
	public Triangulo(double base, double altura, String color) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double area() {
		return this.base*this.altura*0.5;
	}

}
