package cuestionario;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSorted(new double[]{16.1, 12.3, 22.2, 14.4}));
		System.out.println(isSorted(new double[]{1.5, 4.3, 7.0, 19.5, 25.1, 46.2}));
		System.out.println(isSorted(new double[]{42.0}));
		System.out.println(isSorted(new double[]{42.0, 27.0}));
		System.out.println(isSorted(new double[]{1.5, 4.3, 7.0, 19.5, 7.8, 25.1, 46.2}));
	}
	 public static boolean isSorted(double[] array) {
		 boolean sorted = true; 
		 for(int i=0; i<array.length-1; i++) {
			 if(array[i]>array[i+1]) {
				 sorted = false;
				 break;
			 }
		 }
		return sorted;
		 
	 }

}
