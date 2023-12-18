package ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char chI = 'Z';
		char chF = 'A';
		int a = 0;
		for (int j = chI; j >= chF; j--) {
			for (int i = chI - a; i >= chF; i--) {
				System.out.print((char)i);
			}
			a++;
			System.out.println("");
		}
	}

}
