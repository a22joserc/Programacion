package tarea1;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A=1;
		int B=2;
		int C=3;
		int D=4;
		int n=B; // Variable puente para poder almacenar el valor de B
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
		System.out.println("D = " + D);
		B=C;
		System.out.println("B toma el valor de C -> B = " + B);
		C=A;
		System.out.println("C toma el valor de A -> C = " + C);
		A=D;
		System.out.println("A toma el valor de D -> A = " + A);
		D=n;
		System.out.println("D toma el valor de B -> D = " + n);
		
	}

}
