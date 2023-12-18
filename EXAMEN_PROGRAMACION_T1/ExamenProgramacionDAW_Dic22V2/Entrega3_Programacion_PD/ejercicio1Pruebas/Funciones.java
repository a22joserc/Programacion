package ejercicio1Pruebas;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Scanner;

public class Funciones {
	
	public static int obtenerLetrasDNI(String dni) {
		int contLetra = 0;
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				contLetra++;
			}
		}
		return contLetra;
	}
	
	public static int obtenerDigitosDNI(String dni) {
		int contDigito = 0;
		for (int i=0; i<dni.length(); i++) {
			if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				contDigito++;
			}
		}
		return contDigito;
	}
	
	public static boolean validarDNI(String dni) {
		boolean validar;
		int contLetra = 0;
		int contDigito = 0;
		int posLetra=0;
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				contLetra++;
				posLetra = i+1;
			}
			else if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				contDigito++;
			}
		}
		if (contDigito == 8 && contLetra == 1 && posLetra == 9) {
			validar = true;
		}
		else {
			validar = false;
		}
		return validar;
	}
	
	
	
	public static boolean validarDNIV3(String dni) {
		boolean validar = false;
		int posLetra=0;
		String strDigitosDni = "";
		String strLetraDni = "";
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				strLetraDni = strLetraDni.concat(Character.toString(dni.charAt(i)));
				posLetra = i+1;
			}
			else if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				strDigitosDni = strDigitosDni.concat(Character.toString(dni.charAt(i)));
			}
		}
		
		if (dni.length() == 9 && strDigitosDni.length() == 8 && strLetraDni.length() == 1 && posLetra == 9) {
			String letraDni = Funciones.obtenerLetraDNI(strDigitosDni);
			if (strLetraDni.equalsIgnoreCase(letraDni)) {			
				validar = true;
			}
		}
		return validar;
	}
	
	
	public static String leerValidarDNI(Scanner sc) {
		boolean validarDni;
		String dniTrabajador;
		do {
			System.out.println("Introduzca el DNI del trabajador: ");
			dniTrabajador = sc.nextLine();
			validarDni = Funciones.validarDNIV3(dniTrabajador);
			if(!validarDni) {
				System.out.println("ERROR: DNI no valido!");
			}
		} while(!validarDni); // } while(validarDni == false);
		System.out.println("Validación realizada! DNI correcto!");
		return dniTrabajador;
		
	}
	
	/*public static boolean validarEntrada(String entrada) {
		boolean validar=false;
		if (!entrada.isEmpty()) {
			validar = true;
		}
		return validar;
	}*/
	
	
	public static String leerValidarEntrada(Scanner sc) {
		String entrada;
		do {
			entrada = sc.nextLine();
			if (entrada.isEmpty() || entrada.isBlank()) {
				System.out.println("ERROR: Campo alfanumérico obligatrio! Introduzca de nuevo el parámetro: ");
			}
		} while(entrada.isEmpty() == true || entrada.isBlank() == true);
		System.out.println("Validación realizada! Entrada correcta!");
		return entrada;
	}
	

	public static String obtenerLetraDNI(String strDigitosDni) {
		int digitosDni = Integer.parseInt(strDigitosDni);
		int resto = digitosDni % 23;
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
		return letraDni;
	}
	
	
	
	
	public static boolean validarDNIV2(String dni) {
		boolean validar;
		int contLetra = obtenerLetrasDNI(dni);
		int contDigito = obtenerDigitosDNI(dni);
		if (contDigito == 8 && contLetra == 1) {
			validar = true;
		}
		else {
			validar = false;
		}
		return validar;
	}
	
	public static Map<String,String> romperCadenaTipo1(String cadena){
		// Fijamos las claves del diccionario de acuerdo a la secuencia de la cadena
		String[] claves = {"dni","nombre","apellidos","edad","lugNac","cif","nomEmp","dirEmp","numEmp"};
		Map<String,String> dictTokens = new HashMap<>();
		StringTokenizer st = new StringTokenizer(cadena,"|"); 
		int i=0;
		while (st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(),":"); 
			while (st1.hasMoreTokens()) {
				dictTokens.put(claves[i],st1.nextToken());
				i++;
			}
		}
		return dictTokens;
	}
	
	

}
