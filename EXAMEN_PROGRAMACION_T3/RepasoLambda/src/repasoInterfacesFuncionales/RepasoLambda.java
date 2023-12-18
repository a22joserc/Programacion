package repasoInterfacesFuncionales;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RepasoLambda {
	
	public static void main(String[] args) {
	
		
		// Interfaces Funcionales
		
		// 1.- Consumer -> Recibe un parámetro no devuelve nada
		System.out.println("************************************************************************");
		List<Integer> listaNumeros = Arrays.asList(1,2, 8, 12);
		listaNumeros.forEach(n -> System.out.println(n));
		
		// 1.b.- BiConsumer -> Recibe dos parámetros no devuelve nada
		System.out.println("************************************************************************");
		HashMap<Integer, String> diccionario = new HashMap<>();
		diccionario.put(1, "Pedro");
		diccionario.put(2, "Juan");
		diccionario.put(3, "Luis");
		diccionario.forEach((k,v) -> System.out.println(k + ": " + v));
		
		// 2.- Supplier -> No recibe nada devuelve un parámetro
		System.out.println("************************************************************************");
		// Obtener un número random
		Supplier<Integer> numeroRandom = () -> new Random().nextInt(0, 101);
		System.out.println(numeroRandom.get());
		// Obtener una fecha
		Supplier<LocalDateTime> fechaHoy = () -> LocalDateTime.now();
		LocalDateTime hoy = fechaHoy.get();	
		System.out.println(hoy);
		
		// 3.- Predicate -> Recibe un parámetro de entrada devuelve un booleano --> VIP
		System.out.println("************************************************************************");
		Employee employee = new Employee(1, "Fernanda", "Programador", 25000);
		Predicate<Employee> predicateSalario = (e) -> e.getSalary() > 30000;
		boolean checkSalario = predicateSalario.test(employee);
		System.out.println("El empleado cobra más de 30000 € ? " + checkSalario);
		// Podemos hacer predicados muy complejos con condiciones lógicas
		System.out.println("************************************************************************");
		Predicate<Employee> predicatePuesto = (e) -> e.getPosition().equalsIgnoreCase("programador");
		boolean checkPuesto = predicatePuesto.test(employee);
		System.out.println("El empleado es programador ? " + checkPuesto);
		// Combinamos predicados con expresiones lógicas 
		Predicate<Employee> predicatePuestoAndSalario = predicateSalario.and(predicatePuesto);
		boolean checkPuestoSalario = predicatePuestoAndSalario.test(employee);
		System.out.println("El empleado cobra más de 30000 € Y es programador ? " + checkPuestoSalario);
		// Otra forma de hacerlo
		System.out.println("************************************************************************");
		Predicate<Employee> predicatePuestoV2 = (e) -> {return e.getPosition().equalsIgnoreCase("programador");};
		System.out.println("El empleado es programador ? " + predicatePuestoV2.test(employee));
		
		// 4.- BiPredicate --> Recibe dos parámetros y devuelve un booleano
		System.out.println("************************************************************************");
		BiPredicate<String, Double> biPredicatePuestoSalario = (p, s) -> p.equalsIgnoreCase("programador") && s > 30000;
		System.out.println("El empleado cobra más de 30000 € Y es programador ? " + biPredicatePuestoSalario.test(employee.getPosition(), employee.getSalary()));
		// Otra forma de hacerlo
		System.out.println("************************************************************************");
		BiPredicate<String, Double> biPredicatePuestoSalarioV2 = (p, s) -> {return p.equalsIgnoreCase("programador") && s > 30000;};
		System.out.println("El empleado cobra más de 30000 € Y es programador ? " + biPredicatePuestoSalarioV2.test(employee.getPosition(), employee.getSalary()));
		
	}

}
