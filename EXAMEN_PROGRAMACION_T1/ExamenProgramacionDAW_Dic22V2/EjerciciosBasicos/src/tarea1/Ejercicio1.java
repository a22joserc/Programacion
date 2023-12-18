package tarea1;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int N=5;
		double A=4.56;
		char C='a';
		System.out.println("El valor de N es " + N);
		System.out.println("El valor de A es " + A);
		System.out.println("El valor de C es " + C);
		// Operaciones
		System.out.println("El valor de N + A es: " + (N+A));
		System.out.println("La diferencia A - N es: " + (A-N));
		System.out.println("El valor numerico correspondiente a C es: " + (int)C);*/
		
		String str="               ";
		char[] myStrChars = str.toCharArray();
		for(int i=myStrChars.length-1; i> -1; i--) {
			myStrChars[i]='*';
			System.out.println(String.valueOf(myStrChars));
		}
	}

}
