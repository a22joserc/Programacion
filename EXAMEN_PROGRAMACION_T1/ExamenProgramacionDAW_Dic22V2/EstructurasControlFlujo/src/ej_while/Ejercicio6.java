package ej_while;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca una palabra: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String lista = "";
		while(! str.equals("fin")) {
			// lista = lista + str + " ";
			// lista += str + " ";
			lista = lista.concat((str + " "));
			System.out.println("Introduzca una palabra: ");
			str = sc.nextLine();
		}
		sc.close();
		System.out.println("lista de palabaras introducidas: " + lista);
		System.out.println("Fin del programa!!!");
		
		//
		/*String str;
		String lista="";
		do {
			System.out.println("Introduzca una palabra: ");
			Scanner sc = new Scanner(System.in);
			str = sc.nextLine();
			lista = lista.concat((str + " "));
		}while(! str.equals("fin"));
		System.out.println("lista de palabaras introducidas: " + lista);
		System.out.println("Fin del programa!!!");*/
		
		
	}

}
