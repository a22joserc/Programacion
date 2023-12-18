package cuestionario;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayAppend1 = append(new int[]{1, 2}, new int[]{3, 4});
		imprimirArray1D(arrayAppend1);
		int[] arrayAppend2 = append(new int[]{2, 4, 6}, new int[]{1, 2, 3, 4, 5});
		imprimirArray1D(arrayAppend2);
		

	}
	
	public static int[] append(int[] array1, int[] array2) {
		 int[] arrayAppend = new int[array1.length+array2.length];
		 for (int i=0; i<arrayAppend.length; i++) {
			 if (i<array1.length) {
				 arrayAppend[i]=array1[i];
			 }
			 else {
				 arrayAppend[i]=array2[i-array1.length];
			 }
		 }
		 
		 return arrayAppend;
	}
	
	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}

}
