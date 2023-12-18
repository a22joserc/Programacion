package gestionhospital;

import java.util.Comparator;

public class PacienteComparator  implements Comparator<Paciente>{
	
	@Override
	public int compare(Paciente p1, Paciente p2) {
		return p1.getImpEnfermedad().compareTo(p2.getImpEnfermedad());
	}

}
