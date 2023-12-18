package sets;

import java.util.HashSet;
import java.util.Iterator;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hset = new HashSet<String>();
        hset.add("123");
	    hset.add("1234");
	    hset.add("12345");
	    hset.add("12345678");
	    hset.add("1");
	    
	    maxLength(hset);
	    
	   
	    
	    //System.out.println(maxLength(hset));
	    
	    HashSet<Integer> hset2 = new HashSet<Integer>();
	    hset2.add(2);
	    hset2.add(4);
	    hset2.add(1);
	    System.out.println(hasOdd(hset2));
	    
	    System.out.println(hset);
	    removeEvenLength(hset);
	    System.out.println(hset);

	}
	
	private static int maxLength(HashSet<String> hset) {
		int max = 0;
		if (hset.size()>0) {
			/*
			Iterator<String> iterator = hset.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next().length());
				if (iterator.next().length() > max) {
					max = iterator.next().length();
					
				}
			}
			 return max;*/
			for (String str: hset) {
				// max = Math.max(max, str.length());
				if(str.length() > max) {
					max = str.length();
				}
			}
			return max;
		}
		
		return max;
	}
	
	
	private static boolean hasOdd(HashSet<Integer> hset) {
		for (Integer integer: hset) {
			if (integer %2 != 0) {
				return true;
			}
		}
		return false;
	}
	
	private static void removeEvenLength(HashSet<String> hset) {
		Iterator<String> iterator = hset.iterator();
		while(iterator.hasNext()) {
			if (iterator.next().length() % 2 == 0) {
				iterator.remove();
			}
		}
		
		
	}
}
