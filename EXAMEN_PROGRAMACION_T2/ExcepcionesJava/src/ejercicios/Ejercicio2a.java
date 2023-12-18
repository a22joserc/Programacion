package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2a {
	
	public static void main(String[] args) {
		

		boolean flag = true;
		Scanner teclado= new Scanner(System.in);
		int n =0;
		do {
			try {
				System.out.println("Introduce numero: ");
			    n=teclado.nextInt(); //Numero entero introducido por teclado.
			    flag = false;
			} catch (InputMismatchException e) {
				teclado.nextLine();
				System.out.println("Debe introducir un número entero");
			}
		} while (flag);
		teclado.close();
		int factorial=n;
	    String salida=n+"! = "+n;
	    for(int i=n-1;i>0;i--){
	        salida+="*"+i;
	        factorial*=i;
	    }
	    salida+=" = "+factorial;
	    System.out.println(salida);

		
	}

}
