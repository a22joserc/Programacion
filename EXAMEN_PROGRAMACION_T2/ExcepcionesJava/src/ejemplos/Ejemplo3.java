package ejemplos;

import java.util.Scanner;

public class Ejemplo3 {

	public static void main(String[] args) {

		System.out.println("Dame un número: ");
	    try {
	        System.out.println(dameNum());
	    }
	    catch(Exception e) {
	    	System.out.println("Excepción recibida --> " + e);
	    }

	}
	
	 public static int dameNum() {
	    Scanner cin = new Scanner(System.in);
	    int num;
	    try {
	        num = Integer.parseInt(cin.nextLine().trim());
	        cin.close();
	    }
	    catch(NumberFormatException e) {
	        System.out.println("Entrada no válida. Relanzando excepción...");
	        throw e;
	    }
	    return num;
	 }


}
