package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploSorted {
	
	public static void main(String[] args) {
		
		Libro l1 = new Libro("El señor de los anillos", "fantasia", 1100);
		Libro l2 = new Libro("El Juego de Ender", "ciencia ficcion", 500);
		Libro l3 = new Libro("La fundacion", "ciencia ficcion", 500);
		Libro l4 = new Libro("Los pilares de la tierra", "historica", 1200);
		Libro l5 = new Libro("El Juego de Ender", "ciencia ficcion", 500);
		List <Libro> lista = Arrays.asList(l1, l2, l3, l4, l5);
		
		
		// Ordenamos por nombre
		
		System.out.println("Sorted Libros: ");
		lista.stream().sorted(Comparator.comparing(l -> l.getNumPag()))
		    		  .forEach(System.out::println);
		
		// Ordenamos por nombre bipredicate
		System.out.println("Sorted Libros bipredicate: ");
		lista.stream().sorted((lib1, lib2) -> lib1.getTitulo().compareTo(lib2.getTitulo()))
		  			  .forEach(System.out::println);
		
		// Ordenamos por número páginas
		System.out.println("Sorted Libros bipredicate (Núm Páginas): ");
		lista.stream().sorted((lib1, lib2) -> Integer.compare(lib1.getNumPag(), lib2.getNumPag()))
				  	  .forEach(System.out::println);
		
		// Distinct
		System.out.println("Aplicamos Distinct: ");
		List<String> listaTitulos = lista.stream().filter(x -> x.getGenero().equalsIgnoreCase("ciencia ficcion"))
												  .map(lib -> lib.getTitulo()).distinct().collect(Collectors.toList());
		
		listaTitulos.forEach(lib -> System.out.println(lib));
		
	}
}
