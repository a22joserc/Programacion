package ejerciciosRecursividad;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		acumuladorRecursivo(sc, 1, 0);
	}
	
	
	public static void acumuladorRecursivo(Scanner sc, int contador, int suma) {
		System.out.print("Ingrese el #" + contador + ": ");
		int num = sc.nextInt();
		if (num == 0) {
			System.out.println("Se ingres cero\nSuma total:" + suma + "\nFin!.");
		}
		else {
			acumuladorRecursivo(sc, contador+1, suma+num);
		}
		
	}
	
		
	public static void acumulador(Scanner sc) {
		int num;
		int i = 0;
		int suma = 0;
		do {
			i++;
			System.out.println("Ingrese el #" + i);
			num = sc.nextInt();
			suma += num;
		}while(num!=0);
		System.out.println("Se ingreso cero");
		System.out.println("Suma total:" + suma);
		System.out.println("Fin!.");
	}
	
}
