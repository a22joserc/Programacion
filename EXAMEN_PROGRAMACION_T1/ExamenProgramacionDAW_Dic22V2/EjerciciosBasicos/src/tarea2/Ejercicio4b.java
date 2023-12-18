package tarea2;
import java.util.Scanner;

public class Ejercicio4b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un captial inicial:");
		double c = sc.nextDouble();
		System.out.println("Introduzca una tasa de interés:");
		double x = sc.nextDouble();
		System.out.println("Introduzca un periodo de retorno en años:");
		int n = sc.nextInt();
		sc.close();
		double cf = c * Math.pow((1+(x/100)),n);
		double ren = cf - c;
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("|Entrada | Resultado\t\t\t\t\t\t\t|");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.printf("| %1$.0f  | Capital inicial (€): %1$.2f\t\t\t\t|%n",c);
		System.out.printf("| %1$.1f\t | Interés anual (%%): %1$.2f\t\t\t\t\t|%n",x);
		System.out.printf("| %1$d\t | Años (a): %1$d\t\t\t\t\t\t\t|%n",n);
		System.out.println("|        | *************************************************************|");
		System.out.printf("|        | * Capital inicial: %.2f € *\t\t\t\t|%n",c);
		System.out.printf("|        | * Interés anual: %10.2f %% *\t\t\t\t|%n", x);
		System.out.printf("|        | * Periodo: %16d a *\t\t\t\t|%n", n);
		System.out.printf("|        | * Capital final: %10.2f € *\t\t\t\t|%n", cf);
		System.out.printf("|        | * Rendimiento: %12.2f € *\t\t\t\t|%n", ren);
		System.out.println("|        | *************************************************************|");
		System.out.println("|-----------------------------------------------------------------------|");


	}

}
