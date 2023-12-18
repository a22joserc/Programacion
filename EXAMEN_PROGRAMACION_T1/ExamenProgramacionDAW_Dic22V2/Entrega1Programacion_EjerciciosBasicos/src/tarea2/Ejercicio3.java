package tarea2;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el lado mayor del rectángulo en metros (m): ");
		double may = sc.nextDouble();
		System.out.println("Introduzca el lado menor del rectángulo en metros (m): ");
		double men = sc.nextDouble();
		sc.close();
		double per=2*may+2*men;
		double area= may*men;
		System.out.printf("Salida:%nLongitud del primer lado: %.2f m%nLongitud del segundo lado: %.2f m%n",may,men);
		System.out.println("==================================");
		System.out.printf("Perímetro: %.2f m, Área: %.2f m2%n",per,area);
		System.out.println("==================================");
		
	}

}
