package tarea1;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a=false, b=false;
		System.out.println("Tabla de la verdad &&");
		System.out.println("falso\t\t&&\t\tfalso\t\t\t=\t\t" + (a && b));
		System.out.println("falso\t\t&&\t\tverdadero\t\t=\t\t" + (a && !b));
		System.out.println("verdadero\t&&\t\tfalso\t\t\t=\t\t" + (!a && b));
		System.out.println("verdadero\t&&\t\tverdadero\t\t=\t\t" + (!a && !b));
		System.out.println("Tabla de la verdad ||");
		System.out.println("falso\t\t||\t\tfalso\t\t\t=\t\t" + (a || b));
		System.out.println("falso\t\t||\t\tverdadero\t\t=\t\t" + (a || !b));
		System.out.println("verdadero\t||\t\tfalso\t\t\t=\t\t" + (!a || b));
		System.out.println("verdadero\t||\t\tverdadero\t\t=\t\t" + (!a || !b));
	}

}
