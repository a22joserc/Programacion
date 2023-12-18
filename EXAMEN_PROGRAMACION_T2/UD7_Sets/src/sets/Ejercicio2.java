package sets;

import java.util.HashSet;


public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona persona1 = new Persona("Pepe", 666667665);
		Persona persona2 = new Persona("Juan", 111111111);
		Persona persona3 = new Persona("Jose", 625987321);
		Persona persona4 = new Persona("Luna", 981539770);
		Persona persona5 = new Persona("Pepe", 666667665);
		
		HashSet<Persona> hset = new HashSet<>();
		hset.add(persona1);
		hset.add(persona2);
		hset.add(persona3);
		hset.add(persona4);
		
		System.out.println(hset);
		
		System.out.println(persona1.equals(persona5));
		System.out.println(persona1.hashCode());
		System.out.println(persona5.hashCode());
		System.out.println(persona2.hashCode());
		
		hset.add(persona5);
		
		System.out.println(hset);
	}

}
