package ejercicio3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		TreeMap<String, Alumno> alumnos = new TreeMap<>(Collections.reverseOrder());
		Alumno a1 = new Alumno("Manuel", 9.81);
		Alumno a2 = new Alumno("Alberto", 5.81);
		Alumno a6 = new Alumno("Alberte", 5.91);
		Alumno a3 = new Alumno("José", 7.81);
		Alumno a4 = new Alumno("Maria", 6.81);
		Alumno a5 = new Alumno("Elena", 4.81);
		
		alumnos.put(a1.getNombre(), a1);
		alumnos.put(a2.getNombre(), a2);
		alumnos.put(a3.getNombre(), a3);
		alumnos.put(a4.getNombre(), a4);
		alumnos.put(a5.getNombre(), a5);
		alumnos.put(a6.getNombre(), a6);
		
		alumnos.forEach((nombre,alumno) -> System.out.println(nombre + ", Nota media: " + alumno.getNotaMedia()));
		
		System.out.println("*************************************************************");
		
		SortedMap<String, Alumno> porcionAlumnos = alumnos.headMap("José");

		porcionAlumnos.forEach((nombre,alumno) -> System.out.println(nombre + ", Nota media: " + alumno.getNotaMedia()));
		
		System.out.println(alumnos.firstKey());
		System.out.println(alumnos.lastEntry());
		
		
		/*
		HashMap<String, Alumno> alumnos = new HashMap<>();
		Alumno a1 = new Alumno("Manuel", 9.81);
		Alumno a2 = new Alumno("Alberto", 5.81);
		Alumno a6 = new Alumno("Alberte", 5.91);
		Alumno a3 = new Alumno("José", 7.81);
		Alumno a4 = new Alumno("Maria", 6.81);
		Alumno a5 = new Alumno("Elena", 4.81);
		
		
		alumnos.put(a1.getNombre(), a1);
		alumnos.put(a2.getNombre(), a2);
		alumnos.put(a3.getNombre(), a3);
		alumnos.put(a4.getNombre(), a4);
		alumnos.put(a5.getNombre(), a5);
		alumnos.put(a6.getNombre(), a6);

		alumnos.forEach((nombre,alumno) -> System.out.println(nombre + ", Nota media: " + alumno.getNotaMedia()));
		
		System.out.println("*************************************************************");
		*/
		
	}

}
