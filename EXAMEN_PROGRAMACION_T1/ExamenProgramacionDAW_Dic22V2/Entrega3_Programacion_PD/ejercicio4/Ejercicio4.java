package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strChar, strUsuario;
		String strCompleta = "";
		Scanner sc = new Scanner(System.in);
		// ENTRADA AL PROGRAMA
		do {
			System.out.print("Introduce un carácter: ");
			strChar = sc.nextLine();
			if(strChar.length()!=1 || strChar.isBlank()==true) {
				System.out.println("Error! Debe introducir un único caracter. Espacio en blanco tampoco es valido!");
			}	
		} while(!(strChar.length()==1) || strChar.isBlank()==true);
		// ENTRADA DATOS USUARIO
		System.out.println("Escribe lo que quieras (<> para Finalizar)");
		do {
			strUsuario = sc.nextLine();
			strCompleta = strCompleta.concat(strUsuario);
		}while(!strUsuario.endsWith("<>"));
		// CONTAMOS NÚMERO DE A
		int contChar = 0;
		for (int i=0; i<strCompleta.length(); i++) {
			if (strCompleta.charAt(i) == strChar.charAt(0)) {
				contChar++;
			}
		}
		sc.close();
		System.out.println("Aparaciones de \' " + strChar + " \': " + contChar);
		
		/*
		do {
			System.out.print("Introduce un carácter: ");
			strChar = sc.nextLine();
			if(!(strChar.length()>0 && strChar.length()<=1)) {
				System.out.println("Error! Debe introducir un único caracter. Espacio en blanco tampoco es valido!");
			}	
		} while(!(strChar.length()>0 && strChar.length()<=1));*/
		
	}

}
