package ejercicio1.ud3;
import java.util.Scanner;

public class PersonaDemo {
	
	public static void main(String[] args) {
		Persona p1 = new Persona();
		System.out.println("**************************** Constructor por defecto *********************************");
		System.out.println("La persona de nombre " + p1.getNombre() + " tiene una edad " + p1.getEdad() + " y una altura de " + p1.getAltura());
		System.out.println("**************************** Constructor por parámetros ******************************");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la persona");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la edad de la persona");
		int edad = sc.nextInt();
		System.out.println("Introduzca la altura de la persona");
		float altura = sc.nextFloat();
		sc.close();
		Persona p2 = new Persona(nombre,edad,altura);
		System.out.println("La persona de nombre " + p2.getNombre() + " tiene una edad " + p2.getEdad() + " y una altura de " + p2.getAltura());
		/*System.out.println("********************************* Comparamos personas *********************************");
		Persona p3 = new Persona("Sthepen Curry",33,1.91f);
		System.out.println("La persona de nombre " + p3.getNombre() + " tiene una edad " + p3.getEdad() + " y una altura de " + p3.getAltura());
		System.out.println("La persona más mayor es " + p2.revelaMasViejo(p3).getNombre());
		System.out.println("La persona más alta es " + p2.revelaMasAlto(p3).getNombre());*/
	}
}
