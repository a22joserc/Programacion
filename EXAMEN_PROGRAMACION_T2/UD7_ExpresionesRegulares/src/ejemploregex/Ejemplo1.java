package ejemploregex;

import java.util.regex.Pattern;

public class Ejemplo1 {

	public static void main(String[] args) {
		 String Str = new String("Welcome to Tutorialspoint.com");

	     System.out.print("Return Value :" );
	     System.out.println(Str.matches("(.*)Tutorials(.*)"));

	     System.out.print("Return Value :" );
	     System.out.println(Str.matches("Tutorials"));

	     System.out.print("Return Value :" );
	     System.out.println(Str.matches("Welcome(.*)"));
	     
	     System.out.println(Pattern.matches("-?\\d+","1234")); 

	}

}
