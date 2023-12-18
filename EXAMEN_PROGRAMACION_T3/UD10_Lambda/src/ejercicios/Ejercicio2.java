package ejercicios;


public class Ejercicio2 {
	
	@FunctionalInterface
	interface ReverseString {
		public String reverse(String string);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ReverseString reverseString = string -> {
			char[] array = new char[string.length()];
			for (int i=string.length()-1, j=0; i>-1; i--, j++) {
				array[j]=string.charAt(i);
			}
			return String.valueOf(array);
		
		};
		System.out.println(reverseString.reverse("Hola Mundo"));*/
		
		ReverseString reverseString = string -> {return new StringBuffer(string).reverse().toString();};
		System.out.println(reverseString.reverse("Hola Mundo"));
		
	}
	
	
	public static String reverseString(String string) {
		
		char[] array = new char[string.length()];
		for (int i=string.length()-1, j=0; i>-1; i--, j++) {
			array[j]=string.charAt(i);
		}
		return String.valueOf(array);
	}
}


