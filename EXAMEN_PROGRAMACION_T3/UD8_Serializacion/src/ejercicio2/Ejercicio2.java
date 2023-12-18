package ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		String path = "mapCiudades.dat";
		// Serializamos
		serializarMap(ciudades, path);
		// Recuperamos Map
		HashMap<String, Coordenadas> mapRecuperadoCiudades = leerSerialMap(path);
		// Imprimimos contenido
		Iterator<String> iterator = ciudades.keySet().iterator();
		while (iterator.hasNext()) {
			String clave = iterator.next();
			System.out.println(clave + " - " + mapRecuperadoCiudades.get(clave));
		}
	}
	
	
	public static void serializarMap(HashMap<String, Coordenadas> ciudades, String path) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
			objectOutputStream.writeObject(ciudades);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static HashMap<String, Coordenadas> leerSerialMap(String path){
		
		HashMap<String, Coordenadas> mapRecuperadoCiudades = new HashMap<>();
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
			mapRecuperadoCiudades = (HashMap<String, Coordenadas>) objectInputStream.readObject();
			// return mapRecuperadoCiudades;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapRecuperadoCiudades;
	}

}
