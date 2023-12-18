package ej_switch;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el número correspondiente a un mes: ");
		Scanner sc = new Scanner(System.in);
		int mes = sc.nextInt();
		sc.close();
		switch(mes){
			case 1:
				System.out.println("El mes inroducido es Enero");
				break;
			case 2:
				System.out.println("El mes inroducido es Febrero");
				break;
			case 3:
				System.out.println("El mes inroducido es Marzo");
				break;
			case 4:
				System.out.println("El mes inroducido es Abril");
				break;
			case 5:
				System.out.println("El mes inroducido es Mayo");
				break;
			case 6:
				System.out.println("El mes inroducido es Junio");
				break;
			case 7:
				System.out.println("El mes inroducido es Julio");
				break;
			case 8:
				System.out.println("El mes inroducido es Agosto");
				break;
			case 9:
				System.out.println("El mes inroducido es Septiembre");
				break;
			case 10:
				System.out.println("El mes inroducido es Octubre");
				break;
			case 11:
				System.out.println("El mes inroducido es Noviembre");
				break;
			case 12:
				System.out.println("El mes inroducido es Diciembre");
			default:
				System.out.println("Error el número introducido no se corresponde con ningún mes!");
		}

	}

}
