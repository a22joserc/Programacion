package ej_for;
import java.util.Random;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se asume que cara es el valor 1
		Random rdm = new Random();
		int tirada, i;
		int caras = 0;
		double prob;
		// BUCLE FOR
		for (i=0; i<600000; i++) {
			tirada = rdm.nextInt(0,2);
			if (tirada == 1) {
				caras++;
			}
		}
		// CALCULAMOS PROB
		// prob = caras / i;
		prob = ((double)caras/i)*100;
		System.out.println("Tras " + i + " tiradas, el número de CARAS fue " + caras);
		System.out.printf("%.5f", prob);
	}

}
