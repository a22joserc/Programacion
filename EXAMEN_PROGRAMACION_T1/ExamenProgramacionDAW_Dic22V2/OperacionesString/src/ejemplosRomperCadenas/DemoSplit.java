package ejemplosRomperCadenas;


public class DemoSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ---------------------------------------------------------------------------------------------------------------- //
		// Uso de split para partir la cadena
		String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		String[] listaTokens = cadena.split("\\|");
		String[] finalTokens = new String[9];
		int i=0;
		for (String token: listaTokens) {
			String[] listaSubTokens = token.split(":");
			for (String subToken: listaSubTokens) {
				finalTokens[i] = subToken;
				i++;
			}
		}
		// Imprimimos Array
		for (String str: finalTokens) {
			System.out.println(str);
		}
		// ---------------------------------------------------------------------------------------------------------------- //
		System.out.println("******************************************************************************************");
		// Ejemplo split con dos argumentos
		String strMain = "Alfa, Beta, Delta, Gamma, Sigma";   
		String[] arrSplit = strMain.split(", ", 3);   
		for (String str: arrSplit) {
			System.out.println(str);
		}
		// --------------------------------------------------------------------------------------------------------------- //
		System.out.println("******************************************************************************************");
		String cadena2 = "45666783L&Juan&Lopez&45&Ourense%A80192727&Los hermanos S.L.&Calle Principal 5, Lugo&22";
		String[] listaTokensCadena2 = cadena2.split("%");
		String[] arrayStrFinal = new String[9];
		int j=0;
		for(String str: listaTokensCadena2) {
			String[] array = str.split("&");
			for(String substr: array) {
				arrayStrFinal[j]=substr;
				j++;
			}
		}
		// Imprimimos Array
		for (String str2: arrayStrFinal) {
			System.out.println(str2);
		}
	}

}
