package cuestionario;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastIndexOf(new int[]{74, 85, 102, 99, 101, 85, 56}, 85));
		System.out.println(lastIndexOf(new int[]{74, 85, 102, 99, 101, 85, 56}, 58));
	}
	
	public static int lastIndexOf(int[] array, int num) {
		int pos=-1;
		for (int i=0; i<array.length;i++) {
			if(array[i]==num) {
				pos = i;
			}
		}
		return pos;
		
	}

}
