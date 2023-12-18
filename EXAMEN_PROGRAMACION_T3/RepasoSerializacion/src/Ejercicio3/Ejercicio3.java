package Ejercicio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Jose", "Pérez", "abc123."));
		personas.add(new Persona("Juan", "Pérez", "abc123."));
		personas.add(new Persona("Pedro", "Pérez", "abc123."));
		// Guardamos fichero
		guardarPersonas(personas, "personas.dat");
		// Leemos Personas
		ArrayList<Persona> listaPesonasRecuperada =leerPersonas("personas.dat");
		// Recorremos lista recuperada
		listaPesonasRecuperada.forEach(p -> System.out.println(p.toString()));
		// Guardamos fichero V2
		guardarPersonasV2(personas, "personasV2.dat");
		// Mostramos Fichero V2
		mostrarPersonas("personasV2.dat");
		
		
	}
	
	public static void guardarPersonas(ArrayList<Persona> personas, String fichero) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero))) {
			objectOutputStream.writeObject(personas);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static ArrayList<Persona> leerPersonas(String fichero) {
		
		ArrayList<Persona> listaPesonas = new ArrayList<>();
		
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fichero))) {
			listaPesonas.addAll((ArrayList<Persona>) objectInputStream.readObject());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return listaPesonas;
	}
	
	// Métodos para guardar int o datos primitivos junto con objetos
	
	public static void guardarPersonasV2(ArrayList<Persona> personas, String fichero) {
		
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero))) {
			objectOutputStream.writeInt(personas.size());
			objectOutputStream.writeObject(personas);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void mostrarPersonas(String fichero) {
		
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fichero))) {
			int numPersonas = objectInputStream.readInt();
			ArrayList<Persona> personas = (ArrayList<Persona>) objectInputStream.readObject();
			System.out.println("*************************************************************");
			System.out.println("Número personas: " + numPersonas);
			personas.forEach(p -> System.out.println(p));
			System.out.println("*************************************************************");
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
