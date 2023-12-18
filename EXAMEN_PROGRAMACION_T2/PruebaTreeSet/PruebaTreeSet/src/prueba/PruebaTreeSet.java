package prueba;

import java.util.TreeSet;

public class PruebaTreeSet {

	public static void main(String[] args) {
		
		TreeSet<Asignatura> listaAsignaturas = new TreeSet<>(new CompararAsignaturas());
		
		
		listaAsignaturas.add(new Asignatura("Programación", "A-001", 9));
		listaAsignaturas.add(new Asignatura("BBDD", "A-001", 9));
		listaAsignaturas.add(new Asignatura("LMSXI", "A-002", 9));
		listaAsignaturas.add(new Asignatura("CD", "A-003", 9));
		
		for (Asignatura asignatura:listaAsignaturas) {
			System.out.println(asignatura);
			
		}

	}

}
