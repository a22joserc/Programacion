package Ejercicio6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangulo triangulo = new Triangulo(2, 3, "rojo");
		System.out.println("Área: " + triangulo.area() + " m2");
		Circulo circulo = new Circulo(1, "verde");
		System.out.println("Área: " + circulo.area() + " m2");
	}

}
