package prueba;

import java.util.Comparator;

public class CompararAsignaturas implements Comparator<Asignatura>{
	
	@Override
	public int compare(Asignatura o1, Asignatura o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
