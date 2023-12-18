package Ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		HashMap<String, Coordenadas> ciudades = new HashMap<>();
		ciudades.put("Lugo", new Coordenadas("43.01 N", "7.33 O"));
		ciudades.put("Barcelona", new Coordenadas("41.23 N", "2.11 E"));
		ciudades.put("Madrid", new Coordenadas("40.24 N", "3.41 O"));
		ciudades.put("Lima", new Coordenadas("12.03 s", "77.03 O"));
		
		// Serializamos 
		guardarCiudades(ciudades, "ciudades.dat");
		// Leemos fichero
		HashMap<String, Coordenadas> ciudadesRecuperadas = leerCiudades("ciudades.dat");
		// Mostramos colección
		mostrarCiudades(ciudadesRecuperadas);
		System.out.println("*********************************************************");
		mostrarCiudadesV2(ciudadesRecuperadas);

	}
	
	
	public static void guardarCiudades(HashMap<String, Coordenadas> ciudades, String fichero) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(fichero)))) {
			objectOutputStream.writeObject(ciudades);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static HashMap<String, Coordenadas> leerCiudades(String fichero){
		HashMap<String, Coordenadas> ciudades = new HashMap<>();
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(fichero)));
			ciudades.putAll((HashMap<String, Coordenadas>) objectInputStream.readObject());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}		
		return ciudades;
	}
	
	
	public static void mostrarCiudades(HashMap<String, Coordenadas> ciudades) {
		Iterator<String> iterator = ciudades.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(ciudades.get(iterator.next()).toString());
		}
	}
	
	
	public static void mostrarCiudadesV2(HashMap<String, Coordenadas> ciudades) {
		ciudades.forEach((k, v) -> System.out.println(k + " : " + v));
		
	}
	
}
