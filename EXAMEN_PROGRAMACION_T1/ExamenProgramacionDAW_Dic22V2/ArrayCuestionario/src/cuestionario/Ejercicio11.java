package cuestionario;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arrayCollapse = collapse(new int[]{7, 2, 8, 9, 4, 13, 7, 1, 9, 10});
		int[] arrayCollapse = collapse(new int[]{1,2,3,4,5});
		imprimirArray1D(arrayCollapse);
	}
	
	public static int[] collapse(int[] array) {
		int[] arrayCollapse = {};
		if (array.length % 2 == 0) {
			arrayCollapse = new int[array.length/2];
			int q=0;
			for (int i=0; i<array.length-1; i+=2) {
				arrayCollapse[q] = array[i]+array[i+1];
				q++;
			}
		}
		else {
			arrayCollapse = new int[((array.length-1)/2)+1];
			int q=0;
			for (int i=0; i<array.length-2; i+=2) {
				arrayCollapse[q] = array[i]+array[i+1];
				q++;
			}
			arrayCollapse[arrayCollapse.length-1] = array[array.length-1];
		}
		
		return arrayCollapse;
	}
	
	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}

}
