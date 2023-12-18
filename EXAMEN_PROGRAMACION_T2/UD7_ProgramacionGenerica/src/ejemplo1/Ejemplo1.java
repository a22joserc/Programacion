package ejemplo1;

public class Ejemplo1 {

	public static void main(String[] args) {
		Double[] a1 = { 3.5, 2.0, 4.0, -1.67 };
	    Integer[] a2 = { 5, 0, 4, -1 };
	    String[] a3 = { "mi", "casa, ", "teléfono " };
	    imprimeArray(a1);
	    imprimeArray(a2);
	    imprimeArray(a3);

	}
	
	
	public static <T> void imprimeArray(T[] array) {
		for(T val: array) {
			System.out.printf("%s ", val);
		}
		System.out.println("");
	}

}
