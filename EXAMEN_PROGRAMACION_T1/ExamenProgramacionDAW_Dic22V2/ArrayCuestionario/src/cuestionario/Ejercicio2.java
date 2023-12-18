package cuestionario;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(range(new int[]{8, 3, 5, 7, 2, 4}));
		System.out.println(range(new int[]{32}));

	}
	
	public static int range(int[] array) {
		int min = array[0];
		int max = array[0];
		for (int i=0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			else if (array[i] < min) {
				min = array[i];
			}
		}
		return max - min + 1;
		
	}

}
