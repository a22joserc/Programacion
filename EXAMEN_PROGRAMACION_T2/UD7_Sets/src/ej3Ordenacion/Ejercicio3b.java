package ej3Ordenacion;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3b {

	public static void main(String[] args) {
		
		
		ArrayList<Student> estudiantes = new ArrayList<>();
		
		estudiantes.add(new Student("Jose", 32));
		estudiantes.add(new Student("Jose", 28));
		estudiantes.add(new Student("Maria", 56));
		estudiantes.add(new Student("Laura", 28));
		estudiantes.add(new Student("Maria", 37));
		estudiantes.add(new Student("Andrea", 37));
		estudiantes.add(new Student("Andrea", 37));
		estudiantes.add(new Student("Andrea", 27));
		
		
		Collections.sort(estudiantes);
		estudiantes.forEach(i -> System.out.println(i));
		

	}

}
