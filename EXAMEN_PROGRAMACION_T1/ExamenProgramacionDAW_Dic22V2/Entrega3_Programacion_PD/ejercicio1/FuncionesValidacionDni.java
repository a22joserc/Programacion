package ejercicio1;

public class FuncionesValidacionDni {
	
	public static boolean validarDNI(String dni) {
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
			String letraDni = FuncionesValidacionDni.obtenerLetraDNI(strDigitosDni);
			if (strLetraDni.equalsIgnoreCase(letraDni)) {			
				validar = true;
			}
		}
		return validar;
	}
	
	// MÉTODO MÁS ELEGANTE
	public static boolean validarDNIv2(String dni) {
		boolean validar = false;
		String strDigitosDni = "";
		String strLetraDni = "";
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				strLetraDni = strLetraDni.concat(Character.toString(dni.charAt(i)));
			}
			else if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				strDigitosDni = strDigitosDni.concat(Character.toString(dni.charAt(i)));
			}
		}
		
		if (dni.length() == 9 && strDigitosDni.length() == 8 && strLetraDni.length() == 1 && Character.isLetter(dni.charAt(8)) == true) {
			String letraDni = FuncionesValidacionDni.obtenerLetraDNI(strDigitosDni);
			if (strLetraDni.equalsIgnoreCase(letraDni)) {			
				validar = true;
			}
		}
		return validar;
	}
	
	
	// MÉTODO AÚN MÁS ELEGANTE
	public static boolean validarDNIv3(String dni) {
		if (dni.length() == 9) {
			for (int i=0; i<dni.length()-1; i++) {
				if (Character.isDigit(dni.charAt(i)) == false) {
					return false;
				}
			}
			if (Character.isLetter(dni.charAt(dni.length()-1)) == false) {
				return false;
			}
			String strDigitosDni = dni.substring(0,dni.length()-1);
			String letraDni = FuncionesValidacionDni.obtenerLetraDNI(strDigitosDni);
			if (Character.toString(dni.charAt(dni.length()-1)).equals(letraDni)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
	// IMPORTANTE ObtnerLetraDNI se declara private para que sólo 
	// pueda ser accesible desde la clase ya que este método se ha 
	// diseñado para poder ser usado por validarDNI

	private static String obtenerLetraDNI(String strDigitosDni) {
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

}