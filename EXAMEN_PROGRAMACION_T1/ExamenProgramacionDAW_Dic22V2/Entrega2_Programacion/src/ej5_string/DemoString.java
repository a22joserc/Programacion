package ej5_string;

public class DemoString {

	public static void main(String[] args) {
		String cadena = "   esto es un ejemplo de una cadena de ejemplo   "; 
		System.out.println("****** Cadena ORIGINAL ******");
		System.out.println(cadena);
		System.out.println("La cadena orignial tiene " + cadena.length() + " caracteres");
		System.out.println("****** Cadena sin espacios ******");
		String cadena2 = cadena.trim();
		System.out.println(cadena2);
		System.out.println("La cadena sin espacios tiene " + cadena2.length() + " caracteres");
		// Buscamos la cadena cola. 
		// Obtenemos los ínidices iniciales y finales del substring buscado
		String subStrCola = "cadena de ejemplo";
		// indexOf da el indíce inicial de ocurrencia del substring
		// Sumando al valor del índice inicial la longitud del substring obtenemos el índice final del substring
		int indexColaIni = cadena2.indexOf(subStrCola);
		int indexColaFin = indexColaIni + subStrCola.length();
		// Aplicando el método substring obtenemos la subacadena a partir de su índice inicial
		String cola = cadena2.substring(indexColaIni, indexColaFin);
		System.out.println("****** Cadena COLA ******");
		System.out.println(cola);
		System.out.println("****** Cadena COLA cambiando ejemplo por muestra ******");
		// Reemplazamos ejemplo por muestra
		String cola2 = cola.replace("ejemplo", "muestra");
		System.out.println(cola2);
		// Cadena Principio
		// indexOf da el indíce inicial de ocurrencia del substring
		// Sumando al valor del índice inicial la longitud del substring obtenemos el índice final del substring
		String subStrIni = "esto es un ejemplo de una";
		int indexPrincipioIni = cadena2.indexOf(subStrIni);
		int indexPrincipioFin = indexPrincipioIni + subStrIni.length();
		String principio = cadena2.substring(indexPrincipioIni,indexPrincipioFin);
		System.out.println("****** Cadena PRINCIPIO ******");
		System.out.println(principio);
		String frase = principio + " " + cola2;
		System.out.println("****** Cadena FRASE ******");
		// Concatenamos frase
		System.out.println(frase);
		System.out.println("****** Cadena FRASE con la primera mayúscula ******");
		String str1 = frase.substring(0,1);
		String str2 = frase.substring(1,frase.length());
		String strf = str1.toUpperCase().concat(str2);
		System.out.println(strf);
	
	}

}
