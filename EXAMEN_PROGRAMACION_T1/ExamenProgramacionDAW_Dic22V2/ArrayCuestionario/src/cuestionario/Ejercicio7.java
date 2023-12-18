package cuestionario;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] array = {1.0, 2.0,3.0,4.0};//{2.0, 3.0,1.0,4.0,5.0,6.0,7.0,8.0,9.0};
		/*ordenarArray1D(array);
		double median=0;
		if (array.length < 2) {
			median = array[0];
		}
		else if (array.length % 2 == 0) {
			median = (array[(array.length/2)-1]+array[(array.length/2)])/2;
		}
		else if (array.length % 2 != 0) {
			median = array[(array.length/2)];
		}*/
		
		System.out.println(median(array));

	}
	
	public static double median(double[] array) {
		// ordenamos array
		double median=0;
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i;j++) {
				if(array[j+1] < array[j]) {
					double temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		if (array.length < 2) {
			median = array[0];
		}
		else if (array.length % 2 == 0) {
			median = (array[(array.length/2)-1]+array[(array.length/2)])/2;
		}
		else if (array.length % 2 != 0) {
			median = array[(array.length/2)];
		}
		return median;
	}
	
	
	public static void ordenarArray1D(double[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i;j++) {
				if(array[j+1] < array[j]) {
					double temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

}
