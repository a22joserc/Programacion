package repasoStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		List<String> nombres = Arrays.asList("Juan", "Fernanda", "Luisa");
	
		// Obtener String mas pequeño
		
		Optional<String> optional = nombres.stream()
										   .min((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		if (optional.isPresent()) {
			System.out.println("El String de menor longitud es: " + optional.get());
		}
		
	}
	
	
	
	
	
}
