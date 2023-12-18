package ej_for;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for(int i=1; i<=n; i++) {
			System.out.println(i);
		}
	}

}
