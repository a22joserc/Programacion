package ej_for;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// 0 -> CRUZ
		// 1 -> CARA
		Scanner sc = new Scanner(System.in);
		Random rdm = new Random();
		int tirada;
		int aciertos = 0;
		int partidas = 0;
		String adivina, continuarJuego, strTirada;
		do {
			partidas++;
			tirada = rdm.nextInt(0,2);
			System.out.println("Haga su suposición: CARA/CRUZ ");
			adivina = sc.nextLine();
			if (tirada == 0) {
				strTirada = "CRUZ";
			}
			else {
				strTirada = "CARA";
			}
			if (strTirada.equalsIgnoreCase(adivina)) {
				System.out.println("Exito! Has acertado!");	
				aciertos++;
			}
			else {
				System.out.println("Fail! Has fallado!");
			}
			System.out.println("Desea continuar jugando: SI/NO? ");
			continuarJuego = sc.nextLine();
		}while(continuarJuego.equalsIgnoreCase("si"));
		sc.close();
		System.out.println("Fin del juego! Has jugado " + partidas + " veces y has tenido " + aciertos + " aciertos!");
	}

}
