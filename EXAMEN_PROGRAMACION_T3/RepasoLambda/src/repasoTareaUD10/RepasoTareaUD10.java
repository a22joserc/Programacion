package repasoTareaUD10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepasoTareaUD10 {

	public static void main(String[] args) {
	
		
		ArrayList<Participante> plantillaEquipo1 = new ArrayList<>();
		plantillaEquipo1.add(new Participante("P1E1", "Fernanda", "Marques", tipoSexo.MUJER, 24));
		plantillaEquipo1.add(new Participante("P2E1", "Javier", "Lopez", tipoSexo.HOMBRE, 30));
		plantillaEquipo1.add(new Participante("P3E1", "Daniel", "Rey", tipoSexo.HOMBRE, 30));
		Equipo equipo1 = new Equipo("EQ_1", "Equipo_1", plantillaEquipo1);
		
		ArrayList<Participante> plantillaEquipo2 = new ArrayList<>();
		plantillaEquipo2.add(new Participante("P1E2", "Luisa", "Marques", tipoSexo.MUJER, 10));
		plantillaEquipo2.add(new Participante("P2E2", "Marco", "Porto", tipoSexo.HOMBRE, 30));
		plantillaEquipo2.add(new Participante("P3E2", "Mariana", "Rey", tipoSexo.MUJER, 12));
		Equipo equipo2 = new Equipo("EQ_2", "Equipo_2", plantillaEquipo2);
		
		// 2.- Unir los equipos en una única coleccion HOMBRE Categoria SENIOR
		System.out.println("************************************************************************");
		List<Participante> listaCombinada = listaCombinadaSeniorHombre(equipo1, equipo2);
		listaCombinada.forEach(p -> System.out.println(p.toString()));
		
		// 2.- Unir los equipos en una única coleccion HOMBRE Categoria SENIOR
		System.out.println("************************************************************************");
		List<Participante> listaCombinada2 = listaCombinadaSeniorHombreV2(equipo1, equipo2);
		listaCombinada2.forEach(p -> System.out.println(p.toString()));
		
		// 3.- Obtener el participante más joven de un equipo
		System.out.println("************************************************************************");
		Optional<Participante> optional = obtenerParticipanteMasJoven(equipo2);
		if (optional.isPresent()) {
			System.out.println(optional.get().toString());
		}
		
		// 3.- Obtener el participante más joven de un equipo V2
		System.out.println("************************************************************************");
		Optional<Participante> optional2 = obtenerParticipanteMasJovenV2(equipo2);
		if (optional2.isPresent()) {
			System.out.println(optional2.get().toString());
		}
		
		// 1 Unir Apellidos
		System.out.println("************************************************************************");
		System.out.println(combinarApellidos(equipo2));
		
	}
	
	
	public static List<Participante> listaCombinadaSeniorHombre(Equipo equipo1, Equipo equipo2){
		
		// Definimos Predicate
		Predicate<Participante> predicateSexo = (p) -> p.getSexo() == tipoSexo.HOMBRE;
		Predicate<Participante> predicateCategoria = (p) -> p.getCategoria() == tipoParticipante.SENIOR;
		Predicate<Participante> predicate = predicateSexo.and(predicateCategoria);
		// Combinamos Listas y después filtramos
		List<Participante> listaCombinada = Stream.concat(equipo1.getPlantilla().stream(), equipo2.getPlantilla().stream())
												  .filter(predicate)
												  .collect(Collectors.toList());
		return listaCombinada;
	}
	
	
	
	public static List<Participante> listaCombinadaSeniorHombreV2(Equipo equipo1, Equipo equipo2){
		
		List<Participante> listaCombinada = new ArrayList<>();
		// Definimos Predicate
		Predicate<Participante> predicateSexo = (p) -> p.getSexo() == tipoSexo.HOMBRE;
		Predicate<Participante> predicateCategoria = (p) -> p.getCategoria() == tipoParticipante.SENIOR;
		Predicate<Participante> predicate = predicateSexo.and(predicateCategoria);
		
		// Filtramos Listas Equipo 1 y 2
		List<Participante> listaEquipo1 = equipo1.getPlantilla().stream()
																.filter(predicate)
																.collect(Collectors.toList());
		List<Participante> listaEquipo2 = equipo2.getPlantilla().stream()
																.filter(predicate)
																.collect(Collectors.toList());
		// Combinamos Listas
		listaCombinada.addAll(listaEquipo1);
		listaCombinada.addAll(listaEquipo2);
		return listaCombinada;
	}
	
	
	public static Optional<Participante> obtenerParticipanteMasJoven(Equipo equipo) {
		// Usando Optional 
		Optional<Participante> optional = equipo.getPlantilla()
												.stream()
												.min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		return optional;
	}
	
	public static Optional<Participante> obtenerParticipanteMasJovenV2(Equipo equipo) {
		// Ordenando la lista y seleccionando el primer elemento
		List<Participante> listaOrdenada = equipo.getPlantilla()
												 .stream()
												 .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
												 .collect(Collectors.toList());
		// Buscamos Primer elemento
		Optional<Participante> optional = listaOrdenada.stream().findFirst();
		return optional;
	}
	
	public static String combinarApellidos(Equipo equipo) {
		
		List<String> listaApellidos = equipo.getPlantilla()
											.stream()
											.map(p -> p.getApellidos())
											.collect(Collectors.toList());
		String cadenaApellidos = listaApellidos.stream().collect(Collectors.joining("|"));
		return cadenaApellidos;
	}
	
}
