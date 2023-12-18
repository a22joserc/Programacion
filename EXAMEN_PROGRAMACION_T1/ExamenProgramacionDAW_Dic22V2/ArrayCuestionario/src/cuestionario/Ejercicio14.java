package cuestionario;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordLengths(new Scanner("a b c"));
		Scanner sc2 = new Scanner("Este texto tiene una palabra especialmente larga");
		System.out.println("********************************************");
		wordLengths(sc2);
		System.out.println("********************************************");
		wordLengths(new Scanner(" "));
	}
	
		
	public static void wordLengths(Scanner sc) {
		String str = sc.nextLine();
		sc.close();
		// Partimos la cadena en un array de strins
		String[] arrayStr = str.split(" ");
		// Generamos array de número de letras de cada palabra
		int[] arrayNumLetras = new int[arrayStr.length];
		for (int i=0; i<arrayNumLetras.length; i++) {
			arrayNumLetras[i] = arrayStr[i].length();
		}
		// Obtenemos un array Unico del número de letras de cada palabra
		int[] arrayUnico = unicoAscArray(arrayNumLetras);
		// Contamos el número de ocurrencias de cada p
		for (int i=0; i<arrayUnico.length; i++) {
			int cont = 0;
			String ast = "";
			for (int j=0; j<arrayNumLetras.length; j++) {
				if(arrayUnico[i] == arrayNumLetras[j]) {
					cont++;
					ast = ast.concat("*");
				}
			}
			System.out.println(arrayUnico[i] + ": " + cont + "\t" + ast);
		}
	}
	
	
	
	public static void imprimirArray1D(String[] array) {
		for (String str: array) {
			System.out.print(str + " ");
		}
		System.out.println("");
	}
	
	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}
	
	public static void ordenarAscArray1D(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static int[] unicoArray(int[] array) {
		int index = 0;
		int[] posIndices = new int[array.length];
		for (int i=0; i<array.length; i++) {
			boolean insertar = true;
			for (int j=0; j<i; j++) {
				if (array[i] == array[j]) {
					insertar = false;
				}
			}
			if (insertar==true) {
				posIndices[index] = i;
				index++;
			}
		}
		int[] arrayUnico = new int[index];
		for (int q=0; q<index; q++) {
			arrayUnico[q] = array[posIndices[q]];
		}
		return arrayUnico;
	}
	
	public static int[] unicoAscArray(int[] array) {
		ordenarAscArray1D(array);
		int index = 0;
		int[] posIndices = new int[array.length];
		for (int i=0; i<array.length; i++) {
			while (i<array.length-1 && array[i] == array[i+1]) {
				i++;
			}
			posIndices[index] = i;
			index++;
		}
		int[] arrayUnico = new int[index];
		for (int q=0; q<arrayUnico.length; q++) {
			arrayUnico[q] = array[posIndices[q]];
		}
		return arrayUnico;
	}
	

}
