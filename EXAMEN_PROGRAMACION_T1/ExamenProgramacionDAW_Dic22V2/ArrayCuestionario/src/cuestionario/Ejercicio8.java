package cuestionario;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(percentEven(new int[]{6, 2, 9, 11, 3}));
		System.out.println(percentEven(new int[]{2, 4, 6, 8, 10}));
		System.out.println(percentEven(new int[]{}));
		System.out.println(percentEven(new int[]{1, 3, 5, 7, 9}));
		System.out.println(percentEven(new int[]{1, 2, 5}));
		System.out.println(percentEven(new int[]{1, 2, 4}));

	}
	
	public static double percentEven(int[] array) {
		int contEven = 0;
		double perEven = 0;
		if (array.length>0) {
			for (int i=0; i<array.length; i++) {
				if(array[i] % 2 == 0) {
					contEven++;
				}
			}
			perEven = (((double)contEven*100)/array.length);
		}
		return perEven;
	}
}
