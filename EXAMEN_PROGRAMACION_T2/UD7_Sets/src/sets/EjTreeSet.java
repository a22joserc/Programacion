package sets;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EjTreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
	    ts.add(4); ts.add(-1); ts.add(0);
	    ts.add(2); ts.add(7); ts.add(5);
	    ts.add(3); ts.add(3); ts.add(3); // Sólo almacenará uno
	    System.out.println("ts: " + ts); // Estarán ordenados de menor a mayor
	    System.out.println("Mayor: " + ts.last() + ", Menor: " + ts.first());
	    System.out.println("Primer elemento mayor que 0: " + ts.higher(0));
	    System.out.println("Primer elemento menor o igual que 6: " + ts.floor(6));
	    NavigableSet<Integer> range = ts.subSet(-5, true, 3, false);
	    System.out.println("Elementos en el rango [-5, 3): " + range);
	    
	    
	    TreeSet<Integer> ts2 = new TreeSet<Integer>();

	    ts2.addAll(Arrays.asList(10, 61, 87, 39));

	    System.out.print("TreeSet:");

	    // Usando forEach
	    ts2.forEach(i -> System.out.print(i + " "));
	    System.out.println();

	    System.out.print("TreeSet:");

	    // Usando stream con map (mapear cada elemento), el Collectors lo transforma en una lista
	    System.out.print(ts2.stream().map(i -> String.valueOf(i)).collect(Collectors.toList()));

	}

}
