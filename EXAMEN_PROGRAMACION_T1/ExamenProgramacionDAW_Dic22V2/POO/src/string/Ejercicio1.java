package string;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca su numero decimal");
		Scanner sc1 = new Scanner(System.in);
		String str = sc1.nextLine();
		sc1.close();
		Scanner sc2 = new Scanner(str);
		sc2.useDelimiter(",");
		System.out.println("Parte entera: " + sc2.next() + " - Parte decimal: " + sc2.next());
		sc2.close();
	}

}
