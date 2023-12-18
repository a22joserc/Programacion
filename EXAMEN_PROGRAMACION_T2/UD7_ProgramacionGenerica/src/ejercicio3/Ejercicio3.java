package ejercicio3;

import ejercicio2.Persona;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] array1 = {1, 2, 3, 4, 5};
		Double[] array2 = {5.5, 6.5, 7.5, 8.5};
		Persona[] array3 = {new Persona("Pepe", 98153970), new Persona("Sebas", 98153956)};
		
		Util.imprimirArray(array1);  // Util.<Integer>imprimirArray(array1);
		Util.imprimirArray(array2);  // Util.<Double>imprimirArray(array2);
		Util.imprimirArray(array3);  // Util.<Persona>imprimirArray(array3);

	}

}
