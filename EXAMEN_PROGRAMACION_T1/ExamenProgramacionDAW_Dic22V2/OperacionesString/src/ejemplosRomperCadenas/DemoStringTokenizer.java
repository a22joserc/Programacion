package ejemplosRomperCadenas;

import java.util.StringTokenizer;


public class DemoStringTokenizer {

	public static void main(String[] args) {
		// ---------------------------------------------------------------------------------------------------------------------------//
		// Uso de StringTokenizer de forma manual
		String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		StringTokenizer st = new StringTokenizer(cadena,"|");
		// Contamos número de tokens
		System.out.println("El número de tokens es: " + st.countTokens());
		// Seguimos partiendo las subcadenas
		String cadena1 = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(cadena1,":"); 
		String dni = st1.nextToken();
		String nombre = st1.nextToken();
		String apellidos = st1.nextToken();
		int edad = Integer.parseInt(st1.nextToken());
		String lugar = st1.nextToken();
		String cadena2 = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(cadena2,":"); 
		String cif = st2.nextToken();
		String nomEmpresa = st2.nextToken();
		String direccion = st2.nextToken();	
		String cadena3 = st.nextToken();
		int empleados = Integer.parseInt(cadena3);
		
		//-------------------------------------------------------------------------------------------------------------------------//
		// Uso de StringTokenizer metiendo los valores en array de Strings de forma dinámica
		String cadenaArray = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		StringTokenizer stA = new StringTokenizer(cadenaArray,"|");  
		String[] listaTokens = new String[9]; // Creamos un array de la longitud del los Tokens que queremos.
		int i=0;
		while (stA.hasMoreTokens()) {
			StringTokenizer stA1 = new StringTokenizer(stA.nextToken(),":"); 
			while (stA1.hasMoreTokens()) {
				listaTokens[i]=stA1.nextToken();
				i++;
			}
		}
		// Imprimios Array
		for(String token: listaTokens) {
			System.out.println(token);
		}

	}

}
