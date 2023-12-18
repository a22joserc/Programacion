package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
	public static void main(String[] args) {
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(3);
		lista.add(8);
		lista.add(92);
		lista.add(4);
		lista.add(2);
		lista.add(17);
		lista.add(9);
		
		System.out.println(lista);		
		minToFront(lista);
		System.out.println(lista);
	}
	
	
	private static void minToFront(List<Integer> lista) {
		Integer min = lista.get(0);
		Integer pos = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) <min) {
				min =lista.get(i);
				pos = i;
			}
		}
		Integer temp =lista.get(0);
		lista.set(0, min);
		lista.set(pos, temp);
	}
}
