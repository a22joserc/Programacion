package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lista = new ArrayList<>();
		
		lista.add("UNO");
		lista.add("DOS");
		lista.add("TRES");
		lista.add("CUATRO");
		lista.add("CINCO");
		
		System.out.println(lista);
		
		swapPairs(lista);
		
		System.out.println(lista);

	}
	
	private static void swapPairs(List<String> lista) {	
		for (int i = 0; i < lista.size()-1; i+=2) {
			String temp = lista.get(i);
			lista.set(i, lista.get(i+1));
			lista.set(i+1, temp);
		}
	}

}
