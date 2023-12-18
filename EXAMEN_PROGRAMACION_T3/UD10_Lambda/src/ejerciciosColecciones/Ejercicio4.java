package ejerciciosColecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		ArrayList<Factura> listaFacturas = new ArrayList<>();
		listaFacturas.add(new Factura(1, "Factura 1", 25.25));
		listaFacturas.add(new Factura(2, "Factura 2", 250.25));
		listaFacturas.add(new Factura(3, "Factura 3", 275.25));
		listaFacturas.add(new Factura(4, "Factura 4", 295.25));
		listaFacturas.add(new Factura(5, "Factura 5", 325.25));
		listaFacturas.add(new Factura(6, "Factura 6", 425.25));
		
		List<Factura> listaFacturasMayor200 = listaFacturas.stream()
														   .filter(factura -> factura.getImporte() > 200)
														   .collect(Collectors.toList());
		
		listaFacturasMayor200.forEach(x -> System.out.println(x.getConcepto()));
		
		
		Predicate <Factura> p1 = (Factura f) -> f.getImporte() > 200;
		// Es lo mismo Predicate <Factura> p1 = (f) -> f.getImporte() > 200;
		Predicate <Factura> p2 = (Factura f) -> f.getImporte() < 300;
		Predicate <Factura> ptotal = p1.and(p2);
		
		
		List<Factura> listaFacturas200_300 = listaFacturas.stream()
														  .filter(ptotal)
				 										  .collect(Collectors.toList());
		
		// listaFacturas200_300.forEach(x -> System.out.println(x));
		listaFacturas200_300.forEach(System.out::println);
	}

}
