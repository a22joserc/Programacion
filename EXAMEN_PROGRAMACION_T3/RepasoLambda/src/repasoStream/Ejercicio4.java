package repasoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		List<Factura> listaFacturas = new ArrayList<>();
		listaFacturas.add(new Factura(1, "Escenario", 20000));
		listaFacturas.add(new Factura(2, "Carteleria", 5000));
		listaFacturas.add(new Factura(3, "Dieño", 30000));
		listaFacturas.add(new Factura(4, "Despliegue", 50000));
		
		// 1.- Facturas fitradas por encima de un valor
		System.out.println("************************************************************************");
		List<Factura> listaFacturasFiltradas = obtenerFacturasMayorValor(listaFacturas, 20000);
		listaFacturasFiltradas.forEach(f -> System.out.println(f.toString()));
		
		// 2.- Obtener Faccturas entre dos valores
		System.out.println("************************************************************************");
		List<Factura> listaFacturasFiltradasV2 = obtenerFacturasEntreDosValores(listaFacturas, 20000, 50000);
		listaFacturasFiltradasV2.forEach(f -> System.out.println(f.toString()));
		
		// 3.- Ejercicio 3 -> Supplier número random entre 1 y10
		System.out.println("************************************************************************");
		Supplier<Integer> numeroRandomSupplier = () -> new Random().nextInt(1, 11);
		System.out.println("Ejercicio 3: Número random entre 1 y 10: " + numeroRandomSupplier.get());
		
		// 4.- Ejercicio 3 -> Stream Generate
		System.out.println("************************************************************************");
		Stream<Integer> stream = Stream.generate(numeroRandomSupplier).limit(5);
		stream.forEach(s -> System.out.println(s));
	}
	
	
	public static List<Factura> obtenerFacturasMayorValor(List<Factura> facturas, double valor){
		List<Factura> facturasFiltradas = facturas.stream()
												  .filter(f -> f.getImporte() > valor)
												  .collect(Collectors.toList());
		return facturasFiltradas;
	}
	
	public static List<Factura> obtenerFacturasEntreDosValores(List<Factura> facturas, double valor1, double valor2){
		// Definimos Predicados
		Predicate<Factura> pMayorValor1 = (f) -> f.getImporte() >= valor1;
		Predicate<Factura> pMenorValor2 = (f) -> f.getImporte() <= valor2;
		Predicate<Factura> pFactura = pMayorValor1.and(pMenorValor2);
		// Filtramos
		List<Factura> facturasFiltradas = facturas.stream()
												  .filter(pFactura)
												  .collect(Collectors.toList());
		return facturasFiltradas;
	}
	
	
	
}
