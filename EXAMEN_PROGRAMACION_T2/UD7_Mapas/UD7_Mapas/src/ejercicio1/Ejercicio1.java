package ejercicio1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Coordenadas> ciudades = new HashMap<>();
		ciudades.put("Lugo", new Coordenadas("43.01 N", "7.33 O"));
		ciudades.put("Barcelona", new Coordenadas("41.23 N", "2.11 E"));
		ciudades.put("Madrid", new Coordenadas("40.24 N", "3.41 O"));
		ciudades.put("Lima", new Coordenadas("12.03 s", "77.03 O"));
		
		// Recorremos Mapa Iterator
		
		Set<String> claves = ciudades.keySet();
		Iterator<String> iterator = claves.iterator();
		
		while (iterator.hasNext()) {
			String clave = iterator.next();
			System.out.println(clave + " - " + ciudades.get(clave));
		}
		
		System.out.println("*********************************************************");
		
		
		// Elminamos objetos
		ciudades.remove("Lugo");
		// for each lambda
		ciudades.forEach((ciudad, coordenadas) -> System.out.println(ciudad + " - " + coordenadas));
		

		System.out.println("*********************************************************");
		// Reemplazamos objetos
		ciudades.replace("Lima", new Coordenadas());
		ciudades.forEach((ciudad, coordenadas) -> System.out.println(ciudad + " - " + coordenadas));
		
		// Recuperamos un objeto
		System.out.println("*********************************************************");
		System.out.println(ciudades.get("Barcelona"));

	}

}
