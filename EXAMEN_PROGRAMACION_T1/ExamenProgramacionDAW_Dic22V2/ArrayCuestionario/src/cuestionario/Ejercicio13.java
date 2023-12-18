package cuestionario;

public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayVocales1 = cuentaVocales("Pienso, luego existo");
		imprimirArray1D(arrayVocales1);
		int[] arrayVocales2 = cuentaVocales("Eres malo como un CHU");
		imprimirArray1D(arrayVocales2);
	}
	
	public static int[] cuentaVocales(String str) {
		int numVocales[] = {0, 0, 0, 0, 0};
		char vocalesMin[] = {'a','e','i','o','u'};
		char vocalesMay[] = {'A','E','I','O','U'};
		for (int j=0; j<numVocales.length;j++) {
			for (int i=0; i<str.length(); i++) {
				if(str.charAt(i) == vocalesMin[j] || str.charAt(i) == vocalesMay[j]) {
					numVocales[j] += 1; 
				}
			}
		}
		return numVocales;
	}

	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}
}
