package ejIniArrays;
import java.util.Random;


public class Ejercicio6Repaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", " Noviembre", "Diciembre"};
		int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[][][] array3D = new int[diasMes.length][][];
		// Creamos Array 3D vacio
		for (int i=0; i< array3D.length; i++) {
			array3D[i] = new int[diasMes[i]][24];
		}
		
		Random rdm = new Random();
		// Rellenamos array con la clase Random
		for (int i=0; i < array3D.length; i++) {
			for (int j=0; j < array3D[i].length; j++) {
				for (int q=0; q < array3D[i][j].length; q++) {
					array3D[i][j][q] = rdm.nextInt(0, 1000);
				}
			}
		}
		
		// Imprimimos mes a mes los valores de la matriz
		System.out.println("Imprimimos mes a mes los valores de la matriz: ");
		imprimirArrayMensualemente(array3D,meses);
		System.out.println("******************************************************************************************************************************");
		// Mostramos el día de cada mes con más coches
		System.out.println("Mostramos el día con más conteos de coches para cada mes: ");
		for (int i=0; i<array3D.length; i++) {
			int[] diaHoraMax = findPosMaxValueArray2D(array3D[i]);
			System.out.println("Para el mes " + meses[i] + " el día con más coches es el " + (diaHoraMax[0]+1) + ", a la hora " + diaHoraMax[1]);
		}
		System.out.println("******************************************************************************************************************************");
		// Mostramos la hora que registra mayor conteo para el 3 de Marzp
		int[] horaValorMax = findPosValueMaxArray1D(array3D[2][2]);
		System.out.println("El 3 de Marzo, el mayor conteo se registra a la Hora " + horaValorMax[0] + ". (Su valor es " + horaValorMax[1] + ")");
	}
	
	
	private static void imprimirArrayMensualemente(int[][][] array3D, String[] meses) {
		
		for (int i=0; i < array3D.length; i++) {
			System.out.println(meses[i]);
			imprimirArray2D(array3D[i]);
		}
			
	}
		

	private static void imprimirArray2D(int[][] array2D) {
		for (int q=0; q < array2D[0].length; q++) {
			System.out.print("\tHora" + q);
		}
		System.out.println("");
		for (int i=0; i< array2D.length; i++) {
			for (int j=0; j <array2D[i].length; j++) {
				if (j==0) {
					System.out.print("Dia " + (i+1) + "\t" + array2D[i][j] + "\t");
				}
				else {
					System.out.print(array2D[i][j] + "\t");
				}
			}
			System.out.println("");
		}
	}
	
	private static int[] findPosMaxValueArray2D(int[][] array2D) {
		int[] pos = {0,0};
		for (int i=0; i<array2D.length; i++) {
			for (int j=0; j<array2D[i].length; j++) {
				if (array2D[i][j] > array2D[pos[0]][pos[1]]) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
		
	}
	
	private static int[] findPosValueMaxArray1D(int[] array1D) {
		int[] posVal = {0, array1D[0]};
		for (int i=0; i < array1D.length; i++) {
			if(array1D[i]> array1D[posVal[0]]) {
				posVal[0] = i;
				posVal[1] = array1D[i];
			}
		}
		return posVal;
		
	}
	

}
