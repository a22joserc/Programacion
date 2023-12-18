package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Ejercicio1 {

	public static void main(String[] args) {

		List<Persona>agenda = new ArrayList<>();
		agenda.add(new Persona("Pepe", 666667665));
		agenda.add(new Persona("Juan", 111111111));
		agenda.add(new Persona("Jose", 625987321));
		agenda.add(new Persona("Luna", 981539770));
		
		// Tamaño de la lista
		System.out.println("El tamaño de la agenda es: " + agenda.size());
		
		// Elementos de la lista
		System.out.println("Recorrer la agenda con Iterator");
		Iterator<Persona> it = agenda.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Recorremos lista
		System.out.println("Recorrer la agenda con for");
		for(Persona persona:agenda) {
			System.out.println(persona);
		}
		
		// Recorremos lista
		System.out.println("Recorrer la agenda con for-each");
		agenda.forEach(persona -> System.out.println(persona));
		
		// Eliminar elemento por posición 
		System.out.println("Eliminamos elemento posición 0");
		agenda.remove(0);
		
		// Eliminamos persona con número de Teléfono
		System.out.println("Eliminamos Número telefono 111111111");
		Iterator<Persona> it2 = agenda.iterator();
		while(it2.hasNext()) {
			if(it2.next().getTelefono()==111111111) {
				it2.remove();
				System.out.println("Elemento eleminado");
			}
		}
	
		System.out.println("Recorrer la agenda con for-each");
		agenda.forEach(numero -> System.out.println(numero));
		
		System.out.println("Reseteamos la agenda");
		agenda.clear();
		System.out.println(agenda);
	
		
	}

}
