package ej_for;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<101; i+=2) {
			System.out.println(i);
		}
		
		for(int j=0; j<101; j++) {
			if(j % 2 == 0) {
				System.out.println(j +" es par!");
			}
		}
	}

}
