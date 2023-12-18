package ej_switch;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca un mes con la primera letra en mayúsculas ");
		Scanner sc = new Scanner(System.in);
		String mes = sc.nextLine();
		sc.close();
		switch(mes){
			case "Enero":
				System.out.println("Número de mes 1");
				break;
			case "Febrero":
				System.out.println("Número de mes 2");
				break;
			case "Marzo":
				System.out.println("Número de mes 3");
				break;
			case "Abril":
				System.out.println("Número de mes 4");
				break;
			case "Mayo":
				System.out.println("Número de mes 5");
				break;
			case "Junio":
				System.out.println("Número de mes 6");
				break;
			case "Julio":
				System.out.println("Número de mes 7");
				break;
			case "Agosto":
				System.out.println("Número de mes 8");
				break;
			case "Septiembre":
				System.out.println("Número de mes 9");
				break;
			case "Octubre":
				System.out.println("Número de mes 10");
				break;
			case "Noviembre":
				System.out.println("Número de mes 11");
				break;
			case "Diciembre":
				System.out.println("Número de mes 12");
			default:
				System.out.println("Error no ha introducido de forma correcta el mes!");
		}


	}

}
