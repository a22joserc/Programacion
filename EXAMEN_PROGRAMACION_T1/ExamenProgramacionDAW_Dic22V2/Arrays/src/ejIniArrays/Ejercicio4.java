package ejIniArrays;

import java.util.Random;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Random rnd = new Random();
		//int[][] arrayDosD= new int[4][4];
		int[][] arrayDosD= new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		for(int i=0; i<arrayDosD.length; i++) {
			for (int j=0; j<arrayDosD[i].length; j++) {
				arrayDosD[i][j] = rnd.nextInt(0,100);
			}
		}
		System.out.println("Array Original");
		imprimirArray(arrayDosD);

		// Creamos una copia de array para poder cambiar la diagonal
		int[][] arrayCopia = new int[4][4];
		for(int i=0; i<arrayCopia.length; i++) {
			for (int j=0; j<arrayCopia[i].length; j++) {
				arrayCopia[i][j]=arrayDosD[i][j];
			}
		}
		//Cambiamos diagonal principal
		for (int i=0; i<arrayDosD.length; i++) {
			arrayCopia[i][i]=arrayDosD[i][arrayDosD.length-1-i];
			arrayCopia[i][arrayDosD.length-1-i]=arrayDosD[i][i];
		}
		// Imprimimos el array con la diagonal cambiada
		System.out.println("Array con diagonal principal cambiada");		
		imprimirArray(arrayCopia);*/
		
		
		// JUAN CREA UNA VARIABLE TEMPORAL int en la que almacena la diagonal//
		
		
		// Generamos array
		Random rnd = new Random();
		int[][] arrayDosD= new int[4][4];
		//int[][] arrayDosD= new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
		for(int i=0; i<arrayDosD.length; i++) {
			for (int j=0; j<arrayDosD[i].length; j++) {
				arrayDosD[i][j] = rnd.nextInt(0,100);
			}
		}
		// Imprimimos Array Original
		System.out.println("Array Original");
		imprimirArray(arrayDosD);
		
		//Cambiamos diagonal principal
		for (int i=0; i<arrayDosD.length; i++) {
			int temp = arrayDosD[i][i];
			arrayDosD[i][i]=arrayDosD[i][arrayDosD.length-1-i];
			arrayDosD[i][arrayDosD.length-1-i]=temp;
		}
		// Imprimimos el array con la diagonal cambiada
		System.out.println("Array con diagonal principal cambiada");		
		imprimirArray(arrayDosD);
		
		
	}
	
	public static void imprimirArray(int[][] array) {
		for(int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("");
		}
	
	}

}
