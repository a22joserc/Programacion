package ejercicio1;

public class DemoEjercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Objetos clase Punto
		Punto p1 = new Punto();
		System.out.println("P1 con coordenadas " + p1.toString());
		p1.desplazar(2,2);
		System.out.println("P1 con coordenadas " + p1.toString());
		Punto p2 = new Punto(2,2);
		System.out.println("P2 con coordenadas " + p2.toString());
		System.out.println("P1 y P2 tienen las mismas coordenadas? " + p2.puntosIguales(p1));
		// Objetos clase círculo
		Circulo c1 = new Circulo(10, p2);
		System.out.println(c1.toString());
		Circulo c2 = new Circulo(20, new Punto(10,10));
		System.out.println(c2.toString());
		Circulo c3 = new Circulo(30,3,5);
		System.out.println(c3.toString());
		Circulo c4 = new Circulo();
		System.out.println(c4.toString());
	}

}
