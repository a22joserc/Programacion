package cuestionario;
import java.util.Arrays;
import java.util.Scanner;

public class OperacionesArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mirror Array
		System.out.println("*****************************************");
		int[] array = {1,2,3,4,5};
		imprimirArray1D(array);
		int[] reverseArray = reverseArray1D(array);
		imprimirArray1D(reverseArray);
		// Ordenar Array de menor a Mayor
		System.out.println("*****************************************");
		int[] array2 = {74, 85, 102, 99, 101, 56, 84, 1 ,1};
		ordenarAscArray1D(array2);
		imprimirArray1D(array2);
		// Ordenar Array de menor a Mayor
		System.out.println("*****************************************");
		int[] array3 = {74, 85, 102, 99, 101, 56, 84, 1 ,1};
		ordenarDescArray1D(array3);
		imprimirArray1D(array3);
		// Unique método que devuelve los elementos únicos de vector ordenados menor a mayor
		System.out.println("*****************************************");
		int[] array4 = { 10, 3, 5, 3, 9, 22, 4, 3, 3, 3, 1, 5, 6 };  
		imprimirArray1D(array4);
		int[] array4Unique1 = uniqueAscArray(array4);
		imprimirArray1D(array4Unique1);
		int[] array5 = { 10, 3, 5, 3, 9, 22, 4, 3, 3, 3, 1, 5, 6 };  
		int[] array5Unique = uniqueArray(array5);
		imprimirArray1D(array5Unique);
		// Transpose Matrices
		int[][] array2D = {{1,2,3,4,5},
						   {1,2,3,4,5},
						   {1,2,3,4,5},
						   {1,2,3,4,5},
						   {1,2,3,4,5}};
		
		imprimirArrayDosD(array2D);
		System.out.println("*****************************************");
		transposeSquareMatrix2D(array2D);
		imprimirArrayDosD(array2D);
		System.out.println("*****************************************");
		int[]array1D = {1,2,3,4,5,6,7};
		imprimirArray1D(array1D);
		imprimirArray1D(reverseArray1D(array1D));
		System.out.println("*****************************************");
		int[][] matrix2D = {{1,2,3},
				   		    {1,2,3},
				            {1,2,3},
				            {1,2,3},
				            {1,2,3}};
		imprimirArrayDosD(matrix2D);
		int[][] matrix2DTransposed = transposeMatrix2D(matrix2D);
		System.out.println("*****************************************");
		imprimirArrayDosD(matrix2DTransposed);
		// Flip Left to Right - Right to Left
		int[][] matrix2Dc = {{1,2,3,4,5},
	   		                {1,2,3,4,5},
	                        {1,2,3,4,5},
	                        {1,2,3,4,5}};
		
		imprimirArrayDosD(matrix2Dc);
		System.out.println("*****************************************");
		flipLeftToRightMatrix2D(matrix2Dc);
		imprimirArrayDosD(matrix2Dc);
		System.out.println("*****************************************");
		flipRightToLeftMatrix2D(matrix2Dc);
		imprimirArrayDosD(matrix2Dc);
		System.out.println("*****************************************");
		// Flip Upside Downside 
		int[][] matrix2Db = {{1,1,1,1,1},
	                        {2,2,2,2,2},
                            {3,3,3,3,3},
                            {4,4,4,4,4}};
		imprimirArrayDosD(matrix2Db);
		System.out.println("*****************************************");
		flipUpsideDownMatrix2D(matrix2Db);
		imprimirArrayDosD(matrix2Db);
		System.out.println("*****************************************");
		flipDownsideUpMatrix2D(matrix2Db);
		imprimirArrayDosD(matrix2Db);
		
    }         
		
		
	private static void imprimirArrayDosD(int[][] array) {
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("");
		}
		
	}
	
	
	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}
	
	public static int[] reverseArray1D(int[] array) {
		int[] reverseArray = new int[array.length];			
		for(int i=0; i<array.length; i++) {
			reverseArray[i] = array[array.length-1-i];
		}
		return reverseArray;
	}
	
	public static void reverseVoidArray1D(int[] array) {
		for (int i=0; i<array.length/2; i++) {
			int temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = temp;
		}
		
	}
	
	public static void flipLeftToRightMatrix2D(int[][] matrix2D) {
		for (int i=0; i<matrix2D.length; i++) {
			for (int j=0; j<matrix2D[i].length/2; j++) {
				int temp = matrix2D[i][j];
				matrix2D[i][j] = matrix2D[i][matrix2D[i].length-1-j];
				matrix2D[i][matrix2D[i].length-1-j] = temp;
			}
		}
	}
	
	
	public static void flipRightToLeftMatrix2D(int[][] matrix2D) {
		for (int i=0; i<matrix2D.length; i++) {
			for (int j=0; j<matrix2D[i].length/2; j++) {
				int temp = matrix2D[i][matrix2D[i].length-1-j];
				matrix2D[i][matrix2D[i].length-1-j] = matrix2D[i][j];
				matrix2D[i][j] = temp;
			}
		}
	}
	
	
	public static void flipUpsideDownMatrix2D(int[][] matrix2D) {
		for (int i=0; i<matrix2D[0].length; i++) {
			for (int j=0; j<matrix2D.length/2; j++) {
				int temp = matrix2D[matrix2D.length-1-j][i];
				matrix2D[matrix2D.length-1-j][i] = matrix2D[j][i];
				matrix2D[j][i] = temp;
			}
		}
	}
	
	
	public static void flipDownsideUpMatrix2D(int[][] matrix2D) {
		for (int i=0; i<matrix2D[0].length; i++) {
			for (int j=0; j<matrix2D.length/2; j++) {
				int temp = matrix2D[j][i];
				matrix2D[j][i] = matrix2D[matrix2D.length-1-j][i];
				matrix2D[matrix2D.length-1-j][i] = temp;
			}
		}
	}
	
	
	public static int[][] transposeMatrix2D(int[][] matrix){
		int filas = matrix.length;
		int columnas = matrix[0].length;
		int [][] matrixTransposed = new int[columnas][filas];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				matrixTransposed[j][i] = matrix[i][j]; 
			}
		}
		return matrixTransposed;	
	}
	
	public static void transposeSquareMatrix2D(int[][] array) {
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<i; j++) {
				int temp = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = temp;
			}
		}
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
	
	public static void ordenarDescArray1D(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i; j++) {
				if (array[j+1] > array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	
	// Retorna elementos únicos array en forma ascendente
	public static int[] uniqueAscArray(int[] array) {
		ordenarAscArray1D(array);
		int[] posicionesUnique = new int[array.length];
		int index = 0;
		for (int i=0; i<array.length; i++) {
			while (i<array.length-1 && array[i] == array[i+1]) {
				i++;
			}
			posicionesUnique[index] = i;
			index++;
		}
		int[] arrayUnique = new int[index];
		for (int j=0; j<index; j++) {
			arrayUnique[j] = array[posicionesUnique[j]];
		}
		return arrayUnique;
	}
	
	// Retorna elementos únicos array
	public static int[] uniqueArray(int[] array) {
		int[] posicionesUnique = new int[array.length];
		int index = 0;
		for (int i=0; i<array.length; i++) {
			boolean pos = true;
			for (int j=0; j<i; j++) {	
				if (array[i] == array[j]) {
					pos = false;
					break;
				}
			}
			if (pos == true) {
				posicionesUnique[index] = i;
				index++;
			}
		}
		int[] arrayUnique = new int[index];
		for (int q=0; q<index; q++) {
			arrayUnique[q] = array[posicionesUnique[q]];
		}
		return arrayUnique;
	}

}
