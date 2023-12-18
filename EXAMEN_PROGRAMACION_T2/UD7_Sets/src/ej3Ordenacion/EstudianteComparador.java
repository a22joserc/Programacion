package ej3Ordenacion;

import java.util.Comparator;

public class EstudianteComparador implements Comparator<Estudiante> {
	
	/*
	// Método Júan
	@Override
	public int compare(Estudiante e1, Estudiante e2) {
		// Comparamos si tienen el mismo nombre -> 0
		int comp = e1.getNombre().compareTo(e2.getNombre());
		if (comp !=0) {
			return comp;
		}
		// Si tienen el mismo nombre comparamos por edad
		return Integer.compare(e1.getEdad(), e2.getEdad());
	}
	*/

	
	// Método JV
	@Override
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
	

	
}
