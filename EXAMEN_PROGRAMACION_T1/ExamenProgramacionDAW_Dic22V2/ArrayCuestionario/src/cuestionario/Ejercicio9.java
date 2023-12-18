package cuestionario;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique(new int[] {}));
		System.out.println(isUnique(new int[] {1}));
		System.out.println(isUnique(new int[] {2, 5, 6}));
		System.out.println(isUnique(new int[] {1, 3, 3}));
		System.out.println(isUnique(new int[] {1, 3, 4, 5, 28, 18, 1}));
		System.out.println("**********************************************");
		System.out.println(isUnique(new int[] {}));
		System.out.println(isUnique(new int[] {1}));
		System.out.println(isUnique(new int[] {2, 5, 6}));
		System.out.println(isUnique(new int[] {1, 3, 3}));
		System.out.println(isUnique(new int[] {1, 3, 4, 5, 28, 18, 1}));
		
	}
	
	
	public static boolean isUnique(int[] array) {
		boolean unique = true;
		if(array.length > 1) {
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
			// Comprobamos si es único
			for (int i=0; i<array.length-1; i++) {
				if(array[i+1] == array[i]) {
					unique = false;
				}
			}
		}
		return unique;
	}
	
	
	
	/*public static boolean isUnique(int[] array) {
		boolean unique = true;
		ordenarArray1D(array);
		if(array.length > 1) {
			for (int i=0; i<array.length-1; i++) {
				if(array[i+1] == array[i]) {
					unique = false;
				}
			}
		}
		return unique;
	}*/
	
	
	
	public static boolean isUniqueV2 (int[] array) {
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<i; j++) {
				if (array[i] == array[j]) {
					return false;
				}
			}
		}
		return true;
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

}
