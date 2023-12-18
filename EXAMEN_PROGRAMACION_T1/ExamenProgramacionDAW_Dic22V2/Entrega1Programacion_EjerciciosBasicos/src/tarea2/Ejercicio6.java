package tarea2;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la nota de la primera evaluación:");
		double n1 = sc.nextDouble();
		System.out.println("Introduzca la nota de la segunda evaluación:");
		double n2 = sc.nextDouble();
		System.out.println("Introduzca la nota de la tercera evaluación:");
		double n3 = sc.nextDouble();
		sc.close();
		double media = (n1+n2+n3) / 3;
		System.out.println("********************** SALIDA *************************");
		System.out.printf("La nota media con dos cifras significativas es %.2f%n", media);
		// Redondeo usando printf
		System.out.printf("La nota media redondeada es %.0f%n", media);
		// Operador ternario
		System.out.println("Por lo tanto la nota final es " + (media<5? "SUSPENSO" : "APROBADO"));
		System.out.println("*******************************************************");
		// Usando una estructura if else
		/*
		if(media_r1 < 5) {
			System.out.println("Por lo tanto la nota final es SUSPENSO");
		}
		else {
			System.out.println("Por lo tanto la nota final es APROBADO");
		}*/
	}

}
