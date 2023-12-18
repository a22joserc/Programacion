package ej_for;
import java.util.Random;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rdm = new Random();
		int tirada;
		//
		for (int i=0; i<4; i++) {
			String fila ="";
			for (int j=0; j<5; j++) {
				tirada = rdm.nextInt(1,7);
				fila = fila.concat((Integer.toString(tirada) + " "));	
			}
			System.out.println(fila);
		}
	}
}
