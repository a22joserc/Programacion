package ej3Ordenacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		
		estudiantes.add(new Estudiante("Jose", 32, 'M'));
		estudiantes.add(new Estudiante("Jose", 28, 'M'));
		estudiantes.add(new Estudiante("Maria", 56, 'F'));
		estudiantes.add(new Estudiante("Laura", 28, 'F'));
		estudiantes.add(new Estudiante("Maria", 37, 'F'));
		estudiantes.add(new Estudiante("Andrea", 37, 'F'));
		estudiantes.add(new Estudiante("Andrea", 37, 'M'));
		estudiantes.add(new Estudiante("Andrea", 27, 'F'));
		
		/*
		Collections.sort(estudiantes, new EstudianteComparador());
		estudiantes.forEach(i -> System.out.println(i));
		*/
		
		// Forma más compacta ya no necistamos crear la clase Estdiante Comparador
		
		Collections.sort(estudiantes, new Comparator<Estudiante>() {
			
			public int compare(Estudiante e1, Estudiante e2) {		
				// Si tienen distinto nombre aplicamos el metodo comareTo y ya nos devuelve -1, 0, 1
				if (!e1.getNombre().equals(e2.getNombre())) {
					return e1.getNombre().compareTo(e2.getNombre());
				}
				// Si tienen el mismo nombre y distinto sexo metodo compareTo y ya nos devuelve -1, 0, 1
				if(e1.getSexo() != e2.getSexo()) {
					return Character.compare(e1.getSexo(), e2.getSexo());
				}
				// Si tienen el mismo nombre  y sexo aplicamos el método Integer.compareTo y ya nos devuelve -1, 0, 1
				return Integer.compare(e1.getEdad(), e2.getEdad());
				}
		});
		
		estudiantes.forEach(i -> System.out.println(i));

	}

}
