package ejemplosRomperCadenas;
import java.util.Scanner;

public class DemoScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Uso de Scanner para romper cadenas. Forma Manual
		String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Scanner scC = new Scanner(cadena);
		scC.useDelimiter("\\|");
		String cadena1 = scC.next();
		System.out.println(cadena1);
		Scanner sc1 = new Scanner(cadena1);
		sc1.useDelimiter(":");
		String dni = sc1.next();
		String nombre = sc1.next();
		String apellidos = sc1.next();
		int edad = sc1.nextInt();
		String lugar = sc1.next();
		String cadena2 = scC.next();
		System.out.println(cadena2);
		Scanner sc2 = new Scanner(cadena2);
		sc2.useDelimiter(":");
		String cif = sc2.next();
		String nomEmpresa = sc2.next();
		String direccion = sc2.next();
		int empleados = scC.nextInt();
		//-------------------------------------------------------------------------------------------------------------------------//
		// Uso de StringTokenizer metiendo los valores en array de Strings de forma dinámica
		String[] listaTokens = new String[9];
		String cadenaArray = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Scanner scA = new Scanner(cadenaArray);
		scA.useDelimiter("\\|");
		int i =0;
		while(scA.hasNext()) {
			Scanner sc = new Scanner(scA.next());
			sc.useDelimiter(":");
			while(sc.hasNext()) {
				listaTokens[i] = sc.next();
				i++;
			}
		}
		// Imprimios Array
		System.out.println("******************************************************************************************");
		for(String token: listaTokens) {
			System.out.println(token);
		}
		//-----------------------------------------------------------------------------------------------------------------------//
		// Scanner and Split
		Scanner scS = new Scanner("45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22");
		String strS = scS.nextLine();
		String[] listaTokenSplit = strS.split("\\|");
		for (String tokenSplit: listaTokenSplit) {
			System.out.println(tokenSplit);
		}

		
	}

}
