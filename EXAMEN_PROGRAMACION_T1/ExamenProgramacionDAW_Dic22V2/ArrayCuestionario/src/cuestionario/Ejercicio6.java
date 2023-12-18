package cuestionario;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] array = {48,25,22,5,3,1,0};
		imprimirArray1D(array);
		ordenarArray1D(array);
		System.out.println("*************************************************************");
		imprimirArray1D(array);*/
		
		
		
		
		/*for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i; j++) {
				if(array[j+1] < array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			imprimirArray1D(array);
		}*/
		
		int[] array = {74, 85, 102, 99, 101, 56, 84};
		System.out.println(kthLargest(3, array));
		
	}
	
	/*public static int kthLargest(int k, int[] array) {
		ordenarArray1D(array);
		int num = array[array.length-1-k];
		return num;
	}*/
	
	public static int kthLargest(int k, int[] array) {
		// ordenamos array
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i;j++) {
				if(array[j+1] < array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		// Obtenemos valor
		int num = array[array.length-1-k];
		return num;
	}
	
	
	public static void ordenarArray1D(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i;j++) {
				if(array[j+1] < array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void imprimirArray1D(int[] array) {
		for (int num: array) {
			System.out.print(num + "\t");
		}
		System.out.println("");
	}

}
