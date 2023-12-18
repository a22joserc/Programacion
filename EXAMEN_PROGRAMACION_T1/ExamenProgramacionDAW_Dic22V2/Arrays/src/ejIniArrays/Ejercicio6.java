package ejIniArrays;
import java.util.Random;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		
		Random rdm = new Random();
		int num;
		// Array Días Mes
		String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Dciembre"};
		int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[][][] arrayTresD = new int[12][][];
		// Generamos ArrayTresD
		for (int i=0; i<arrayTresD.length; i++) {
			arrayTresD[i] = new int[diasMes[i]][24];
		}
		// Rellenamos ArrayTresD
		for (int i=0; i<arrayTresD.length; i++) {
			// System.out.println("Mes: " + (i+1));
			for (int j=0; j<arrayTresD[i].length; j++) {
				// System.out.println("\tDía: " + (j+1));
				for (int q=0; q<arrayTresD[i][j].length; q++) {
					num = rdm.nextInt(0, 1000);
					//System.out.println("\t\tHora " + (q+1) + " = " + num);
					arrayTresD[i][j][q] = num;
				}
			}
		}
		
		// Imprimimos mes a mes los valores de la matriz
		System.out.println("Imprimimos mes a mes los valores de la matriz: ");
		for (int i=0; i<arrayTresD.length; i++) {
			System.out.println(meses[i]);
			imprimirArrayDosD(arrayTresD[i]); 
		}
		// Mostrar el día con conteos de más coche para cada mes
		System.out.println("******************************************************************************************************************************");
		System.out.println("Mostramos el día con más conteos de coches para cada mes: ");
		for(int i=0; i<arrayTresD.length; i++) {
			int[] diaHoraMax = findPosValMaxArrayDosD(arrayTresD[i]);
			System.out.println("Para el mes " + meses[i] + ", el día con más coches es el " + (diaHoraMax[0]+1) + " a las " + (diaHoraMax[1]) + " horas");
		}
		// 3 de marzo hora de mayor conteo
		System.out.println("******************************************************************************************************************************");
		System.out.println("Mostramos la hora a la que se producen más conteos para un mes y día determinados: ");
		int[] pos_max = findValMaxPosArrayUnoD(arrayTresD[2][2]);
		System.out.println("El 3 de Marzo el mayor conteo es: " + pos_max[1] + ", y ocurre a las " + pos_max[0] + " horas");
				
	}
	
	
	private static void imprimirArrayDosD(int[][] array) {
		for (int i=0; i<array.length; i++) {
			if (i==0) {
				System.out.print("\tHora0\tHora1\tHora2\tHora3\tHora4\tHora5\tHora6\tHora7\tHora8\tHora9\tHora10\tHora11\tHora12\tHora13\tHora14\tHora15\tHora16\tHora17\tHora18\tHora19\tHora20\tHora21\tHora22\tHora23\n");
			}
			for (int j=0; j<array[i].length; j++) {
				
				if (j==0) {
					System.out.print("Dia " + (i+1) + "\t" + array[i][j] + "\t");
				}
				else {
					System.out.print(array[i][j] + "\t");
				}
			}
			System.out.println("");
		}
		
	}
	
	private static void imprimirArrayUnoD(int[] array) {
		for (int num:array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}
	
	private static int[] findValMaxPosArrayUnoD(int[] array) {
		int[] pos_max = {0, array[0]};
		for (int i=0; i<array.length; i++) {
			if (array[i]> pos_max[1]) {
				pos_max[0] = i;
				pos_max[1] = array[i];
			}
		}
		return pos_max;
	}
	
	private static int[] findPosValMaxArrayDosD(int[][] array) {
		int[] pos = {0, 0};
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				if (array[i][j]>array[pos[0]][pos[1]]) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
		
	}
}
