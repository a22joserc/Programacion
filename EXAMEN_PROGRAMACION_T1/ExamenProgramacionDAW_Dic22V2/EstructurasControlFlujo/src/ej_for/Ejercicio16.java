package ej_for;

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*double num = 28;
		String str="";
		for (int i=0; i<4; i++) {
			if (num % 2 == 0) {
				str = str.concat("0");
			}
			else {
				str = str.concat("1");
			}
			num = Math.floor(num/2);
		}
		str = str.concat("1");
		// Revertimos el string para obtener el binario
		String binario="";
		for (int i=str.length()-1; i> - 1; i--) {
			binario = binario + str.charAt(i);
		}
		System.out.println(" -> Núm Binario = " + binario);
		*/
		
		double num = 29;
		System.out.print("Núm. decimal = " + num);
		String str="";
		while (num > 1) {
			if (num % 2 == 0) {
				str = str.concat("0");
			}
			else {
				str = str.concat("1");
			}
			num = Math.floor(num/2);
		}
		str = str.concat("1");
		// Revertimos el string para obtener el binario
		String binario="";
		for (int i=str.length()-1; i> - 1; i--) {
			binario = binario + str.charAt(i);
		}
		System.out.println(" -> Núm Binario = " + binario);
	}

}
