package sets;

import java.util.Arrays;
import java.util.HashSet;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> A = new HashSet<>();
		A.addAll(Arrays.asList(5, 7, 9, 19));
		System.out.println(A);
		
		HashSet<Integer> B = new HashSet<>();
		B.addAll(Arrays.asList(10, 20, 5, 7));
		System.out.println(B);
		
		HashSet<Integer> C = new HashSet<>();
		
		C.addAll(A);
		C.addAll(B);
		System.out.println(C);
		
		C = new HashSet<>();
		C.addAll(A);
		C.removeAll(B);
		System.out.println(C);
		
		C = new HashSet<>();
		C.addAll(A);
		C.retainAll(B);
		System.out.println(C);
		
		
		// Interseccion
		// A.retainAll(B);
		// A.addAll(B);
		//A.removeAll(B);
		//System.out.println(A);
	}

}
