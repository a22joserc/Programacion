package ejerciciosColecciones;

import java.util.Arrays;
import java.util.Optional;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arrayNombres = {"Pepe", "Maria", "Lola", "Lua", "Romualdo"};
		
		// Arrays.stream(arrayNombres).forEach(System.out::println);
		
		// Optional<String> MIN = Arrays.stream(arrayNombres).min((str1, str2) -> Character.compare(str1.charAt(str1.length()-1), str2.charAt(str2.length()-1)));
		
		Optional<String> MIN = Arrays.stream(arrayNombres).min((str1, str2) -> Integer.compare(str1.length(), str2.length()));
		
		if (MIN.isPresent()) {
			System.out.println(MIN.get());
		}

	}

}
