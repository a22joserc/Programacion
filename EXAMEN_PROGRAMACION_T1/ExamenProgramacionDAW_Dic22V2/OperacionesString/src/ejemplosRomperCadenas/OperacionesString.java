package ejemplosRomperCadenas;
import java.util.Scanner;

public class OperacionesString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int num = 3;
		String strInt = String.valueOf(num);
		System.out.println(strInt);
		double dou = 3.5;
		String strDou = String.valueOf(dou);
		System.out.println(strDou);
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un double");
		double dou2 = sc.nextDouble();
		// Limpieza del buffer 
		sc.nextLine();
		String strDou2 = String.valueOf(dou2);
		System.out.println(strDou2);		
		System.out.println("Introduzca otro double");
		String douStr = sc.nextLine();
		sc.close();
		double dou3 = Double.parseDouble(douStr);
		System.out.println("El Double introducido es " + dou3);
		*/
		// ---------------------------------------------------------------------------- //
		char[] cadena = "jalorcho".toCharArray();
		char letra = 'o';
		int cont = 0;
		for (int i=0; i<cadena.length; i++) {
			if (cadena[i] == letra) {
				cont++;
			}
		}
		System.out.println("El número de letras " + letra + " es " + cont);
		System.out.println("********************************************");
		String cadena2 = "jalorcho";
		int cont2=0;
		for (int i=0; i<cadena2.length(); i++) {
			if(cadena2.charAt(i) == letra) {
				cont2++;
			}
		}
		System.out.println("El número de letras " + letra + " es " + cont2);
	}

}
