package ejercicios;

import java.util.Scanner;

public class Ejercicio2b {

	public static void main(String[] args) {
				
		boolean flag = true;
		Scanner teclado= new Scanner(System.in);
		int n =0;
		do {
			try {
				System.out.println("Introduce numero: ");
			    n=Integer.parseInt(teclado.nextLine()); //Numero entero introducido por teclado.
			    flag = false;
			} catch (NumberFormatException e) {
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
