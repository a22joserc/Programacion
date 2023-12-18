package string;
import java.util.Scanner;


public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca su numero decimal");
		Scanner sc1 = new Scanner(System.in);
		String str = sc1.nextLine();
		sc1.close();
		String decimal = str.substring(str.length()-2, str.length());
		String entero = str.substring(0, str.length()-3);
		System.out.println("Parte entera: " + entero + " - Parte decimal: " + decimal);


	}

}
