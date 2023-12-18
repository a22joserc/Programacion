package ejercicio2;

public class Main {
	
	public static void main(String[] args) {
		
		Figura[] figuras = new Figura[9];
		
		figuras[0] = new Triangulo(1, 2, "rojo");
		figuras[1] = new Triangulo(2, 3, "negro");
		figuras[2] = new Triangulo(3, 4, "verde");
		figuras[3] = new Rectangulo(6, 4, "verde");
		figuras[4] = new Rectangulo(8, 5, "rojo");
		figuras[5] = new Rectangulo(5, 4, "verde");
		figuras[6] = new Circulo(4, "verde");
		figuras[7] = new Circulo(5, "rojo");
		figuras[8] = new Circulo(4, "verde");
		
		for (Figura figura: figuras) {
			System.out.println("Área figura: " + figura.area() + "m2");
			if (figura.area() > 4) {
				figura.color = "negro";
			}
			System.out.println("Color figura: " + figura.color);
		}
		
	}

}
