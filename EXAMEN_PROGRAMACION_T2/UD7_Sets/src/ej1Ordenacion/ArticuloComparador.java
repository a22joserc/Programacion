package ej1Ordenacion;

import java.util.Comparator;

public class ArticuloComparador implements Comparator<Articulo>{
	
	@Override
	public int compare(Articulo a1, Articulo a2) {
		// return a1.codArticulo.compareTo(a2.codArticulo);
		return Integer.compare(a1.cantidad, a2.cantidad);
	}
	


}
