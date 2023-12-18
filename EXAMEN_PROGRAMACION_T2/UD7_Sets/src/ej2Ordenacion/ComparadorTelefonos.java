package ej2Ordenacion;

import java.util.Comparator;


public class ComparadorTelefonos implements Comparator<String>  {
	
	@Override
	public int compare(String o1, String o2) {
		
		
		if (o1.equals(o2)) {
			return 0;
		}
		if (o1.startsWith("+") && !o2.startsWith("+")) {
			return 1;
		}
		if (!o1.startsWith("+") && o2.startsWith("+")) {
			return -1;
		}
		
		long l1 = Long.parseLong(o1);
		long l2 = Long.parseLong(o2);
		
		if (l2<l1) {
			return -1;
		}
		else if (l2 == l1) {
			return 0;
		}
		else {
			return +1;
		}
		
	}

}
