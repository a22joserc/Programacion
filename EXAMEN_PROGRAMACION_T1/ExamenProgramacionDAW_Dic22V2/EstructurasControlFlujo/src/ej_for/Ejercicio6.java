package ej_for;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont=0;
		for(int i=0; i<101; i++) {
			if(i % 2 !=0) {
				System.out.println(i + " es impar!");
				cont++;
			}
		}
		System.out.println("El número de impares de 0 a 100 es: " + cont);

	}

}
