package ejIniArrays;
import java.util.Random;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		Random rdm = new Random();
		// Generamos Array
		int[][] array2D = new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
		// Rellenamos array
		for (int i=0; i<array2D.length; i++) {
			for(int j=0; j<array2D[i].length; j++) {
				array2D[i][j]=rdm.nextInt(0, 100);
			}
		}
		
		imprimirArray2D(array2D);
		// cambiarDiagonalPrincipalSecundaria(array2D);
		// invertitDiagonalPrincipal(array2D);
		// invertitDiagonalSecundaria(array2D);
		invertitDiagonalPrincipalSecundaria(array2D);
		System.out.println("*********************************************");
		imprimirArray2D(array2D);
	}
	
	
	private static void imprimirArray2D(int[][] array2D) {
		for (int i=0; i<array2D.length; i++) {
			for(int j=0; j<array2D[i].length; j++) {
				System.out.print(array2D[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	private static void cambiarDiagonalPrincipalSecundaria(int[][] array2D) {
		for (int i=0; i<array2D.length; i++) {
			int temp = array2D[i][i];
			array2D[i][i] = array2D[i][array2D.length-1-i];
			array2D[i][array2D.length-1-i] = temp;
		}
		
	}
	
	
	private static void invertitDiagonalPrincipal(int[][] array2D) {
		for (int i=0; i<array2D.length/2; i++) {
			int temp = array2D[i][i];
			array2D[i][i] = array2D[array2D.length-1-i][array2D.length-1-i];
			array2D[array2D.length-1-i][array2D.length-1-i] = temp;
		}
		
	}
	
	
	private static void invertitDiagonalSecundaria(int[][] array2D) {
		for (int i=0; i<array2D.length/2; i++) {
			int temp = array2D[i][array2D.length-1-i];
			array2D[i][array2D.length-1-i] = array2D[array2D.length-1-i][i];
			array2D[array2D.length-1-i][i] = temp;
		}
		
	}
	
	
	private static void invertitDiagonalPrincipalSecundaria(int[][] array2D) {
		for (int i=0; i<array2D.length/2; i++) {
			int tempS = array2D[i][array2D.length-1-i];
			array2D[i][array2D.length-1-i] = array2D[array2D.length-1-i][i];
			array2D[array2D.length-1-i][i] = tempS;
			int temp = array2D[i][i];
			array2D[i][i] = array2D[array2D.length-1-i][array2D.length-1-i];
			array2D[array2D.length-1-i][array2D.length-1-i] = temp;
		}
		
	}
	

}
