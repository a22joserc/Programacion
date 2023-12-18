package ejerciciosColecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona("pedro", 20);
		Persona p2 = new Persona("juan", 25);
		Persona p3 = new Persona("ana", 30);
		List <Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		// Comaparator.comparing
		// Optional<Persona> persona = lista.stream().min(Comparator.comparing(p -> p.getEdad()));
		
		// BiPredict
		Optional<Persona> persona = lista.stream().min((per1, per2) -> Integer.compare(per1.getEdad(),per1.getEdad()));
		
		
		if(persona.isPresent()) {
			System.out.println(persona.get().toString());
		}
		
	}

}
