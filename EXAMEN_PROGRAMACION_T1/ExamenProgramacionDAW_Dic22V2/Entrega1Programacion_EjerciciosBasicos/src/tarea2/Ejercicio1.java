package tarea2;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numero de días: ");
		int dia = sc.nextInt();
		System.out.println("Introduzca el numero de horas: ");
		int hor = sc.nextInt();
		System.out.println("Introduzca el numero de minutos: ");
		int min = sc.nextInt();
		System.out.println("Introduzca el numero de segundos: ");
		int seg = sc.nextInt();
		sc.close();
		int seg_total = (dia*24*3600)+ (hor*3600) + (min*60) + seg; 
		System.out.printf("Salida:%n%d días, %d horas, %d minutos y %d segundos son %d segundos",dia,hor,min,seg,seg_total);

	}

}
