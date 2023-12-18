package cuestionario;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mode(new int[]{1, 1, 2, 3}));
		System.out.println(mode(new int[]{1, 1, 2, 3, 3}));
		System.out.println(mode(new int[]{27, 15, 15, 11, 27}));
		System.out.println(mode(new int[]{27, 15, 15, 11, 27, 27}));
		System.out.println(mode(new int[]{27, 15, 15, 27, 11, 11, 11, 14, 15, 15, 16, 19, 99, 100, 0, 27}));
		System.out.println(mode(new int[]{42}));
	}
	
	public static int mode(int[] array) {

		int[] arrayCont = new int[101];
		for (int q=0; q<101; q++) {
			int cont=0;
			for (int i=0; i<array.length; i++) {
				if (array[i]==q) {
					cont++;
				}
			}
			arrayCont[q] = cont;
		}
		int pos_max=0;
		int val_max=arrayCont[0];
		for (int i=0; i<arrayCont.length; i++) {
			if(arrayCont[i]>val_max) {
				val_max=arrayCont[i];
				pos_max=i;
			}
		}
		return pos_max;
	}

}
