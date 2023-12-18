package ejercicio3;

public class Util {
	
	public static <T> void imprimirArray(T[] array) {
		
		for(T value:array) {
			System.out.print(value.toString() + " ");
		}
		System.out.println("");
		
	}

}
