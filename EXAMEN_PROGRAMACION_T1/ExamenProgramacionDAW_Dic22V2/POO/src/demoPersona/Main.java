package demoPersona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona();
		p1.nombre = "Ana";
		p1.edad = 3;
		Persona p2 = new Persona();
		p2.nombre = "David";
		p2.edad = 5;
		System.out.println("El nombre de P1 es: " + p1.nombre);
		System.out.println("La edad de P1 es: " + p1.edad);
		System.out.println("El nombre de P2 es: " + p2.nombre);
		System.out.println("La edad de P2 es: " + p2.edad);
		System.out.println("La variable referencia p1 es " + (p1==p2?"igual":"distinta") + " a la variable referencia p2");
		// Intercambio
		Persona temp;
		temp = p2;
		p2 = p1;
		p1 = temp;
		System.out.println("El nombre de P1 es: " + p1.nombre);
		System.out.println("La edad de P1 es: " + p1.edad);
		System.out.println("El nombre de P2 es: " + p2.nombre);
		System.out.println("La edad de P2 es: " + p2.edad);
		Persona p3;
		p3 = p2;
		System.out.println("La variable referencia p3 es " + (p3==p2?"igual":"distinta") + " a la variable referencia p2");
		System.out.println("La persona p1 " + p1);
		System.out.println("La persona p2 " + p2);
		System.out.println("La persona p3 " + p3);
	}

}
