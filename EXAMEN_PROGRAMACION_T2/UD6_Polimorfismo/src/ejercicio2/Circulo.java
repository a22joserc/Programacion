package ejercicio2;

public class Circulo extends Figura{
	
	public double radio;
	
	public Circulo(double radio, String color) {
		super(color);
		this.radio = radio;
	}
	
	@Override
	public double area() {
		return this.radio*this.radio*Math.PI;
	}

}
