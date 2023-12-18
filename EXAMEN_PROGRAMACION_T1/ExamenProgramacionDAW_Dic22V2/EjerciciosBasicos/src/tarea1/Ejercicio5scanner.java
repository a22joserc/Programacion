package tarea1;
import java.util.Scanner;

public class Ejercicio5scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Intorduzca su peso (kg): ");
		double peso = sc.nextDouble();
		System.out.println("Intorduzca su altura (m): ");
		double altura = sc.nextDouble();
		sc.close();
		double IMC=peso/Math.pow(altura, 2);
		System.out.println("Peso: " + peso);
		System.out.println("Altura: " + altura);
		System.out.println("IMC: " + IMC);
		System.out.printf("IMC con dos cifras significativas: %.2f%n", IMC);
		System.out.println("TABLA IMC");
		System.out.println("Delgado: <18.5 ");
		System.out.println("Normal: entre 18.5 y 24.9 ");
		System.out.println("Sobrepeso: entre 25 y 29.9 ");
		System.out.println("Obeso: 30 o más");
		System.out.println("Por lo tanto el paciente tiene un estado: ");
		if (IMC<18.5) {
			System.out.println("Delgado");
		}
		else if(IMC>=18.5 && IMC<=24) {
			System.out.println("Normal");
		}
		else if(IMC>25 && IMC<=29.9) {
			System.out.println("Sobrepeso");
		}
		else if (IMC>30){
			System.out.println("Obeso");
		}
		else {
			System.out.println("El valor obtenido de IMC no se corresponde con ningún rango. Por favor revise los datos introducidos!");
		}
		
		
	}

}
