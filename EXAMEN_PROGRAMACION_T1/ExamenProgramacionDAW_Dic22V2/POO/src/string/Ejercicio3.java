package string;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca un número complejo en formato binomial: ");
		Scanner sc = new Scanner(System.in);
		String strComplejo = sc.nextLine();
		strComplejo = strComplejo.substring(0, strComplejo.length()-1);
		sc.close();
		Scanner sc2 = new Scanner(strComplejo);
		sc2.useDelimiter(" +");
		double real = sc2.nextDouble();
		double imag = sc2.nextDouble();
		sc2.close();
		// System.out.println("Real: " + real + " - Imaginaria: " + imag);
		Complejo c1 = new Complejo(real, imag);
		Complejo c2 = new Complejo(1,1);
		c1.sumar(c2);
		System.out.println(c1);
		

	}

}
