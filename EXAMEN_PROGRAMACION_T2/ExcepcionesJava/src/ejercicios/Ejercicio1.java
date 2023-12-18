package ejercicios;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			int[] x= {0,1,2,3,4};
			System.out.println("Probamos exceder límite del array");
			x[5]=5;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("No se puede acceder a x[5]");
		}
		System.out.println("Seguimos ejecutando el resto del programa ... ");

	}

}
