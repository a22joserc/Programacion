package ejercicio2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		TreeMap<String, Persona> guiaTelefonica = new TreeMap<>();
		
		Persona p1 = new Persona("Manuel López López", 666667665);
		Persona p2 = new Persona("Juan", 111111111);
		Persona p3 = new Persona("Jose", 625987321);
		Persona p4 = new Persona("Luna", 981539770);
		
		// Utilizo nombre de persona como clave
		guiaTelefonica.put(p1.getNombre(), p1);
		guiaTelefonica.put(p2.getNombre(), p2);
		guiaTelefonica.put(p3.getNombre(), p3);
		guiaTelefonica.put(p4.getNombre(), p4);
		
		System.out.println("El telefono de " + p4.getNombre() + " es " + guiaTelefonica.get(p4.getNombre()).getTelefono());
		
		System.out.println("*********************************************************");
		
		Set<Map.Entry<String, Persona>> entries = guiaTelefonica.entrySet();
		 
		for (Map.Entry<String, Persona> entry : entries) {
		    String nombre = entry.getKey();
		    Persona persona = entry.getValue();
		    System.out.println(nombre + " => Tfno: " + persona.getTelefono());
		}
		
		// Actualizar teléfono
		
		System.out.println("*********************************************************");
		p1.setTelefono(982270002);
		guiaTelefonica.replace("pepe", p1);
		
		guiaTelefonica.forEach((nombre, persona) -> System.out.println(nombre + " => Tfno: " + persona.getTelefono()));
		

	}

}
