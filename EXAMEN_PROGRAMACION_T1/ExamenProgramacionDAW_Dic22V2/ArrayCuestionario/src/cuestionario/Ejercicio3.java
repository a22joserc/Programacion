package cuestionario;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countInRange(new int[]{14, 1, 22, 17, 36, 7, -43, 5}, 4, 17));

	}

	public static int countInRange(int[] array, int min, int max) {
		int cont=0;
		for (int i=0; i < array.length; i++) {
			if (array[i]>= min && array[i]<=max) {
				cont++;
			}
		}
		return cont;
	}
}
