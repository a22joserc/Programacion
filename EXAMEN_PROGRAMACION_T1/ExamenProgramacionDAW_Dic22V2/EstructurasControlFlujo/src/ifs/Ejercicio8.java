package ifs;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el primer número: ");
		int a = sc.nextInt();
		System.out.println("Introduzca el segundo número: ");
		int b = sc.nextInt();
		System.out.println("Introduzca el tercer número: ");
		int c = sc.nextInt();
		sc.close();
		int mayor;
		if (a > b) {
			if (a > c) {
				 mayor = a;
			}
			else {
				mayor = c;
			}
		}
		else {
			if (b > c) {
				mayor = b;
			}
			else {
				mayor = c;
			}			
		}
		System.out.println("El mayor es: " + mayor);
	}

}
