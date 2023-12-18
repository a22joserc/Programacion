package arraylists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listStrings = new ArrayList<>();
		listStrings.add("One");
		listStrings.add("Two");
		listStrings.add("Three");
		listStrings.add("Four");
		// Añadir por índice
		listStrings.add(0,"Five");
		listStrings.add(0,"Six");
		listStrings.add(0,"Seven");
		System.out.println(listStrings);
		// Generamos lista de forma rápida
		List<Integer> listNumbers = List.of(1,2,3,4,5,6);
		System.out.println(listNumbers);
		// Volcado de una lista en otra
		List<Integer> listNumbers2 = new ArrayList<>(listNumbers);
		System.out.println(listNumbers2);
		//
		List<String> listWords = List.of("Bona", "Ventura", "Petita");
		// listStrings.addAll(listWords);
		listStrings.addAll(2, listWords);
		System.out.println(listStrings);
		listStrings.remove(listStrings.indexOf("Bona"));
		System.out.println(listStrings);
		
		Iterator<String> it = listStrings.iterator(); // Iterator que apuntará al inicio de la colección
		while(it.hasNext()) { // mientras haya "siguiente" elemento...
		    if(it.next().equals("Ventura")) {
		    	it.remove();
		    }
		}
		
		System.out.println("Remove iterator: ");
		listStrings.forEach(s -> System.out.println(s));
		
		
		List<String> lista = new ArrayList<>();
		String s = "bye";
		lista.add("hi");
		lista.add(s);
		System.out.println("hello está en la lista? " + lista.contains("hello"));
		System.out.println("bye está en la lista? " + lista.contains("bye"));
		System.out.println(s + " está en la lista? " + lista.contains(s));
		System.out.println("posición de " + s + " en la lista? " + lista.indexOf(s));
		lista.set(1, "Ciao");
		System.out.println(lista);
		System.out.println(s);
		


		
	}

}
