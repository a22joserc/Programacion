package ejIniArrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrayDosD = {{11,12,13,14},{21,22},{31,32,33}};
		for (int[] fila: arrayDosD) {
			for(int num: fila) {
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}

}
