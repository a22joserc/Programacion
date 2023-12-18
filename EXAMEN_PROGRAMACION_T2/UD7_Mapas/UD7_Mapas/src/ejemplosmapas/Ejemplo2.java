package ejemplosmapas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Ejemplo2 {
	
	public static void main(String[] args) {
		
	    LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
	    map.put(1, "uno"); map.put(2, "dos"); map.put(3, "tres");
	    System.out.println("Claves = " + map.keySet()); // set-vista de claves
	    System.out.println("Valores = " + map.values()); // set-vista de valores
	    System.out.println("Entradas = " + map.entrySet()); // set-vista de entradas
	 
	    Set<Integer> claves = map.keySet();
	    for(Integer k: claves) { 
	    	System.out.println("clave: " + k + "-> val: " + map.get(k)); 
	    }
	    Set<Map.Entry<Integer, String>> entradas = map.entrySet();
	 
	    for(Map.Entry<Integer, String> e: entradas) {
	        System.out.println("clave: " + e.getKey() + "-> val: " + e.getValue());
	    }
		
	}

}
