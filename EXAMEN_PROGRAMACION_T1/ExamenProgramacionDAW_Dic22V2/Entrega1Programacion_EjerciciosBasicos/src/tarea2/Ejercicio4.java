package tarea2;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un capital inicial:");
		double c = sc.nextDouble();
		System.out.println("Introduzca una tasa de interés:");
		double x = sc.nextDouble();
		System.out.println("Introduzca un periodo de retorno en años:");
		int n = sc.nextInt();
		sc.close();
		double cf = c * Math.pow((1+(x/100)),n);
		double ren = cf - c;
		System.out.println("RESULTADO");
		System.out.println("*******************************");
		System.out.printf("Capital inicial (€): %.2f%nInterés anual (%%): %.2f%nAños (a): %d%n",c,x,n);
		System.out.println("*******************************");
		System.out.printf("* Capital inicial: %.2f € *%n",c);
		System.out.printf("* Interés anual: %10.2f %% *%n", x);
		System.out.printf("* Periodo: %16d a *%n", n);
		System.out.printf("* Capital final: %10.2f € *%n", cf);
		System.out.printf("* Rendimiento: %12.2f € *%n", ren);
		System.out.println("*******************************");
	}

}
