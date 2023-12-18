package claseoptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<String> list = Arrays.asList("A", "B", "C", "D");
		
		Optional<String> resultFirst = list.stream().findFirst();

	   // Optional<String> resultFirst = list.stream().filter(x -> x.startsWith("X"))
	   //		.findFirst();

	   if (resultFirst.isPresent()){
		   System.out.println(resultFirst.get());	
	   }


	}

}
