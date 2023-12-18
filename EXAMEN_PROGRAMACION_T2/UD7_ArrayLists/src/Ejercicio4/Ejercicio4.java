package Ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ejercicio4 {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("this");
		lista.add("is");
		lista.add("lots");
		lista.add("of");
		lista.add("fun");
		lista.add("for");
		lista.add("every");
		lista.add("Java");
		lista.add("Programmer");
		
		System.out.println(lista);
		
		// markLength4(lista);
	
		
		/*
		ListIterator<String> iterator = lista.listIterator();
		while(iterator.hasNext()) {
			if(iterator.next().length()==4) {
				System.out.println(iterator.nextIndex());
				iterator.set();
				iterator.add("****");
			}
		}
		*/
		ListIterator<String> iterator = lista.listIterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(str.length()==4) {
				System.out.println(iterator.nextIndex());
				iterator.set("*****");
				iterator.add(str);
			}
		}
		
		System.out.println(lista);
	}
	
	private static void markLength4(List<String> lista) {
		List<Integer> listaPos = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).length()==4) {
				listaPos.add(i);
			}
		}
		int i=0;
		for (Integer integer: listaPos) {
			lista.add((integer+i),"****");
			i++;
		}
		
	}

}
