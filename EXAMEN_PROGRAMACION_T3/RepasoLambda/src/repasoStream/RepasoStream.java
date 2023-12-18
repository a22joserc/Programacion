package repasoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RepasoStream {

	public static void main(String[] args) {
		
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(new Persona("pedro", 20, "lopez"));
		listaPersonas.add(new Persona("juan", 35, "perez"));
		listaPersonas.add(new Persona("ana", 30, "perez"));
		listaPersonas.add(new Persona("amanda", 32, "marquez"));
		listaPersonas.add(new Persona("amanda", 32, "marquez"));
		
		// Uso Map Mostrar el nombre de las personas
		System.out.println("************************************************************************");
		listaPersonas.stream().map(p -> p.getNombre()).forEach(p -> System.out.println(p));
		
		// Uso Filter y Map para mostrar el nombre de las personas mayores de 20 años
		System.out.println("************************************************************************");
		listaPersonas.stream().filter((p) -> p.getEdad() > 20)
							  .map(p -> p.getNombre())
							  .forEach(p -> System.out.println(p));
		
		// Uso Filter y Map para mostrar el nombre de las personas mayores de 20 años y cuyo nombre comienza por A
		System.out.println("************************************************************************");
		Predicate<Persona> predicateEdad = (p) -> p.getEdad() > 20;
		Predicate<Persona> predicateNombre = (p) -> p.getNombre().startsWith("a");
		Predicate<Persona> predicatePersona = predicateEdad.and(predicateNombre);
		listaPersonas.stream().filter(predicatePersona)
							  .map(p -> p.getNombre())
							  .forEach(p -> System.out.println(p));

		// Contar elementos que cumplen una determinada condición. Ej: personas mayores de 20 años y cuyo nombre comienza por A
		System.out.println("************************************************************************");
		Long numPer = listaPersonas.stream().filter(predicatePersona).count();
		System.out.println("Número personas mayores de 20 años y cuyo nombre comienza por A: " + numPer);
		
		// Crear una lista de personas cuya edad sea superior a 30 años
		System.out.println("************************************************************************");
		List<Persona> listaPersonasMas30 = listaPersonas.stream()
														.filter((p) -> p.getEdad() >30)
														.collect(Collectors.toList());
		listaPersonasMas30.forEach(p -> System.out.println(p.toString()));
		
		// Volcar a una Lista de nombres el nombre de las personas mayores de 20 años y cuyo nombre comienza por A
		System.out.println("************************************************************************");
		List<String> listaNombres = listaPersonas.stream()
												 .filter(predicatePersona)
												 .map(p -> p.getNombre())
												 .collect(Collectors.toList());
		listaNombres.forEach(System.out::println);
		
		// Ordenamos personas por edad
		System.out.println("************************************************************************");
		System.out.println("Ordenamos por edad: ");
		List<Persona> listaPersonasOrdenadasEdad = listaPersonas.stream()
					 											.sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
					 											.collect(Collectors.toList());
		listaPersonasOrdenadasEdad.forEach(p -> System.out.println(p));
		
		// Ordenamos personas por Nombre
		
		System.out.println("************************************************************************");
		System.out.println("Ordenamos por nombre: ");
		List<Persona> listaPersonasOrdenadasNombre =listaPersonas.stream()
					 											 .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
					 											 .toList();
		listaPersonasOrdenadasNombre.forEach(p -> System.out.println(p));
		
		// Uso distinct para obtener una Lista con los nombres de las personas que empliezan por a
		System.out.println("************************************************************************");
		List<String> listaNombresA = listaPersonas.stream()
												   .filter((p) -> p.getNombre().startsWith("a"))
												   .map(p -> p.getNombre())
												   .distinct()
												   .collect(Collectors.toList());
		listaNombresA.forEach(System.out::println);
		
		// Find First -> Optional
		System.out.println("************************************************************************");
		Optional<Persona> optional = listaPersonas.stream()
												  .findFirst();
		if (optional.isPresent()) {
			System.out.println(optional.get().toString());
		}
		
	}

}
