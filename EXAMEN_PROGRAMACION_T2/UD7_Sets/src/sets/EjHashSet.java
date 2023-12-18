package sets;

import java.util.HashSet;

public class EjHashSet {
	
	public static void main(String[] args) {
		
		/*
		HashSet<String> hset = new HashSet<String>();
        // Agregar elementos al HashSet
        hset.add("Apple");
	    hset.add("Mango");
	    hset.add("Grapes");
	    hset.add("Orange");
	    hset.add("Fig");
	    //Agregar (intentar) objetos duplicados
	    hset.add("Apple");
	    hset.add("Mango");
	    //Esta permitido agregar valores nulos
	    hset.add(null);

	    System.out.println(hset);
	    */
		
		HashSet<Integer> numbersValues = new HashSet<Integer>();
		  
        numbersValues.add(4);
        numbersValues.add(6);
        numbersValues.add(8);
        numbersValues.add(10);
        numbersValues.add(12);

        System.out.println("Initial hashSet " + numbersValues);

        HashSet<Integer> numbersValuesToRetain = new HashSet<Integer>();
        numbersValuesToRetain.add(4);
        numbersValuesToRetain.add(6);
        numbersValuesToRetain.add(8);

        System.out.println("Values to retain" + numbersValuesToRetain);
        numbersValues.retainAll(numbersValuesToRetain);

        System.out.println("HashSet after retainAll " + numbersValues);
		
	}

}
