package cuestionario;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(contains(new int[]{1, 6, 2, 1, 4, 1, 2, 1, 8}, new int[]{1,6,1,4}));
		System.out.println(contains(new int[]{1}, new int[]{0}));
		
	}
	
	public static boolean contains(int[] array, int[]arrayBuscar) {
		for (int i=0; i<array.length-arrayBuscar.length+1; i++) {
			int cont = 0;
			for (int j=0; j<arrayBuscar.length;j++) {
				if (array[i+j] == arrayBuscar[j]) {
					cont++;
				}
			}
			if(cont == arrayBuscar.length) {
				return true;
			}
		}
		return false;
	}
	
	
	/*public static boolean contains(int[] array, int[]arrayBuscar) {
		int cont;
		for (int i=0; i<array.length-arrayBuscar.length+1; i++) {
			cont = 0;
			for (int j=0; j<arrayBuscar.length;j++) {
				 //System.out.println("Comparo Array maestro " + array[i+j] + " con array de busqueda " + arrayBuscar[j]);
				if (array[i+j] == arrayBuscar[j]) {
					cont++;
				}
			}
			//System.out.println("Contador" + cont);
			if(cont == arrayBuscar.length) {
				return true;
			}
			//System.out.println("*********************************************************************************");
		}
		return false;
	}*/
	
	
	
	/*public static boolean contains(int[] array, int[]arrayBuscar) {
		int cont=0;
		for (int i=0; i<array.length-arrayBuscar.length+1; i++) {
			cont = 0;
			for (int j=0; j<arrayBuscar.length;j++) {
				if (array[i+j] == arrayBuscar[j]) {
					cont++;
				}
			}
		}
		if(cont == arrayBuscar.length) {
			return true;
		}
		return false;
	}*/

}
