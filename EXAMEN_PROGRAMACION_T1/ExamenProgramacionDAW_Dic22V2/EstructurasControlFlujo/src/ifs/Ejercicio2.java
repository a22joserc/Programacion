package ifs;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Teclea número entero x: ");
		int x = sc.nextInt();
		System.out.println("Teclea número entero y: ");
		int y = sc.nextInt();
		sc.close();
		if (x== 10) {
			System.out.println("x vale 10");
			System.out.println("La suma de x + y es: " + (x+y));
		}
		else {
			System.out.println("x NO vale 10");
			System.out.println("La resta de x - y es: " + (x-y));
		}

	}

}
