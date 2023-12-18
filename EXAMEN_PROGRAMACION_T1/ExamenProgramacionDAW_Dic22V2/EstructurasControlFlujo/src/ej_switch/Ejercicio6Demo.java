package ej_switch;
import java.util.Scanner;

public class Ejercicio6Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el dia de la semana L, M, X, J, V, S, D");
		Scanner sc = new Scanner(System.in);
		String dia = sc.nextLine();
		sc.close();
		String lab = obtenerTipoDiaDeLaSemana(dia);
		System.out.println(lab);
		System.out.println(obtenerTipoDiaDeLaSemana2("S"));

	}
	
	private static String obtenerTipoDiaDeLaSemana(String day) {
		String str = switch(day) {
			case "L","M","X","J","V" -> "Laborable";
			case "S","D" -> "No laborable";
			default -> "Error";};
		return str;
	}
	
	private static String obtenerTipoDiaDeLaSemana2(String day) {
		return switch(day) {
			case "L","M","X","J","V" -> "Laborable";
			case "S","D" -> "No laborable";
			default -> "Error";};
	}


}
