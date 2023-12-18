package tarea2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la temperatura en ºC:");
		double cel = sc.nextDouble();
		sc.close();
		double far = 1.8*cel+32;
		System.out.printf("%.1fºC son %.1fºF",cel,far);
		
	}

}
