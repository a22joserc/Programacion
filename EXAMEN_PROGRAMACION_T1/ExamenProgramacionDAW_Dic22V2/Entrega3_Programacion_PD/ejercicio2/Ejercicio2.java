package ejercicio2;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strDigitosDni, strDni;
		int digitosDni;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduzca los digitos del DNI: ");
			strDigitosDni = sc.nextLine();
			digitosDni = obtenerDigitosDNI(strDigitosDni);
			if(!(strDigitosDni.length()==8 && digitosDni==8)) {
				System.out.println("ERROR: La longitud de la cadena y el número de digitos inttoducidos debe ser 8");
			}
		}while(!(strDigitosDni.length()==8 && digitosDni==8)); 
		// Comprobamos que la cadena tiene longitud 8 y está sólo compuesta por numeros
		sc.close();
		int resto = Integer.parseInt(strDigitosDni) % 23;
		String letraDni = switch(resto) {
			case 0 -> "T";
			case 1 -> "R";
			case 2 -> "W";
			case 3 -> "A";
			case 4 -> "G";
			case 5 -> "M";
			case 6 -> "Y";
			case 7 -> "F";
			case 8 -> "P";
			case 9 -> "D";
			case 10 -> "X";
			case 11 -> "B";
			case 12 -> "N";
			case 13 -> "J";
			case 14 -> "Z";
			case 15 -> "S";
			case 16 -> "Q";
			case 17 -> "V";
			case 18 -> "H";
			case 19 -> "L";
			case 20 -> "C";
			case 21 -> "K";
			case 22 -> "E";
			default -> "Error";
		};
		strDni = strDigitosDni.concat(letraDni);
		System.out.println("La letra del DNI es " + letraDni + ". DNI con letra: " + strDni);

	}
	
	private static int obtenerDigitosDNI(String dni) {
		int contDigito = 0;
		for (int i=0; i<dni.length(); i++) {
			if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				contDigito++;
			}
		}
		return contDigito;
	}
	/*
	private static int obtenerDigitosDNIV2(String dni) {
		int contDigito = 0;
		for (int i=0; i<dni.length(); i++) {
			if (Character.isDigit(dni.charAt(i))) {
				contDigito++;
			}
		}
		return contDigito;
	}*/

}
