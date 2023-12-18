package ejercicioRecursividadFactorial;
import java.util.Scanner;

public class MainFactorialRecursividad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial: ");
		int num = sc.nextInt();
		sc.close();
		Factorial factorial = new Factorial();
		System.out.println("El factorial de " + num + " es: " + factorial.calculaFactorial(num));

	}

}
