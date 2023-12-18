package ejerciciosColecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio1DosPuntos {

	public static void main(String[] args) {
		
		
		 List<String> list = new ArrayList<>();
	     list.add("Geeks");
	     list.add("For");
	     list.add("Manolo");
	     list.add("Ana");
	     
	     System.out.println("Ordenamos por orden alfabético: ");
	     list.stream()
	         .sorted((e1, e2) -> e1.compareTo(e2))
	         .forEach(System.out::println);
	     
	     System.out.println("Ordenamos por longitud: ");
	     list.stream()
         .sorted((e1, e2) -> Integer.compare(e1.length(), e2.length()))
         .forEach(System.out::println);
	     
	     System.out.println("Ordenamos por longitud: ");
	     list.stream()
         .sorted(Comparator.comparing(String::length))
         .forEach(System.out::println);
  
  
	  

	}

}
