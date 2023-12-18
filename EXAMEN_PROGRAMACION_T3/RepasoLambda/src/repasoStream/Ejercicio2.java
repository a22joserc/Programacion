package repasoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(new Persona("pedro", 20, "perez"));
		listaPersonas.add(new Persona("juan", 35, "perez"));
		listaPersonas.add(new Persona("ana", 30, "perez"));
		
		// 
		System.out.println("************************************************************************");
		Persona persona =obtenerPersonaMenorEdad(listaPersonas);
		System.out.println(persona.toString());
		System.out.println("************************************************************************");
		Persona persona2 =obtenerPersonaMenorEdadV2(listaPersonas);
		System.out.println(persona2.toString());
	}
	
	// Ordenando la lista y obteniendo el primer elemento
	public static Persona obtenerPersonaMenorEdad(List<Persona> personas) {
		// Obtenemos la lista ordenada de menor a mayor edad
		List<Persona> personasOrdenadas = personas.stream()
												  .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
												  .collect(Collectors.toList());
		// Seleccionamos el primer elemento de la lista
		Persona persona = personasOrdenadas.get(0);
		return persona;
	}
	
	// Usando Optional
	public static Persona obtenerPersonaMenorEdadV2(List<Persona> personas) {
		
		Optional<Persona> optional = personas.stream()
											 .min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
