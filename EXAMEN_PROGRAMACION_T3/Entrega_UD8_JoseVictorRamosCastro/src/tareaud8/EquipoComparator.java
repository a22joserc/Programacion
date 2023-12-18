package tareaud8;

import java.util.Comparator;

public class EquipoComparator implements Comparator<Equipo> {
	
	@Override
	public int compare(Equipo equipo1, Equipo equipo2) {
		return equipo1.getNombre().compareTo(equipo2.getNombre());
	}

}
