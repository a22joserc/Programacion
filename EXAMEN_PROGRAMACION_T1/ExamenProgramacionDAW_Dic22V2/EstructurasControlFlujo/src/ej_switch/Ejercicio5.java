package ej_switch;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bis = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el año");
		int year = sc.nextInt();
		System.out.println("Introduzca el mes");
		int mes = sc.nextInt();
		sc.close();
		int numDias=0;
		
		// Comprobamos si el año es Bisiesto
		if (((year % 4 == 0) && (year % 100 !=0)) || (year % 400 == 0)){
			bis = true;
		}
		// SWITCH
		switch(mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				numDias = 31;
				break;
			case 2:
				if(bis){
					numDias = 29;
				}
				else {
					numDias = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				numDias = 30;
				break;
			default:
				System.out.println("Error al introducir el mes");
		}
		
		System.out.println("El mes " + mes + " del año " + year + " tiene " + numDias + " días");
		
	}

}
