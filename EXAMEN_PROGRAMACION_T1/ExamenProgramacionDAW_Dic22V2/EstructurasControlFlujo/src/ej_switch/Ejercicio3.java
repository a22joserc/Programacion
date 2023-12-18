package ej_switch;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca una letra");
		Scanner sc = new Scanner(System.in);
		char letra = sc.next().charAt(0);
		sc.close();
		switch(letra) {
			case 'a':
			case 'A':
				System.out.println("A de Abejita");
				break;
			case 'e':
			case 'E':
				System.out.println("E de Estepona");
				break;
			case 'i':
			case 'I':
				System.out.println("I de Isabel");
				break;
			case 'o':
			case 'O':
				System.out.println("O de Ogro");
				break;
			case 'u':
			case 'U':
				System.out.println("U de Uva");
				break;
			default:
				System.out.println("La letra inroduducida no es una vocal");
				
		}
		

	}

}
