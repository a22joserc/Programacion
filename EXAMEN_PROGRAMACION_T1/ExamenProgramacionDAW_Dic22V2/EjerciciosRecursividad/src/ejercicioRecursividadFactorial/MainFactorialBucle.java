package ejercicioRecursividadFactorial;
import java.util.Scanner;

public class MainFactorialBucle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial: ");
		int num = sc.nextInt();
		sc.close();
		int factorial = 1;
		if (num > 1) {
			for (int i=num; i >0; i--) {
				factorial = factorial*i;
			}
		}
		System.out.println("Su factorial es " + factorial);
	}

}
