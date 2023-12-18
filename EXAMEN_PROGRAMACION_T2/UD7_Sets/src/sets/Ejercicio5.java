package sets;

import java.util.TreeSet;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> ts = new TreeSet<>();
	    ts.add(4); ts.add(-1); ts.add(0);
	    ts.add(2); ts.add(7); ts.add(5);
	    ts.add(3); ts.add(3); ts.add(3);
	    System.out.println(ts);
	    System.out.println(ts.last());
	    ts.remove(ts.last());
	    System.out.println(ts);
	}

}
