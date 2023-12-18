package ej1Ordenacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("C04", "Raqueta", 100));
		articulos.add(new Articulo("C00", "Camisa", 50));
		articulos.add(new Articulo("C02", "Chaqueta", 25));
		articulos.add(new Articulo("C20", "Chaqueta", 25));
		
		// Collections.sort --> Sólo aplica para las listas!!
		Collections.sort(articulos, new ArticuloComparador());
		for (Articulo articulo:articulos) {
			System.out.println(articulo);
		}
		
		// Probamos a eliminar los artículos de con stock de más de 50 unidades
		
		Iterator<Articulo> iterator = articulos.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCantidad()>=50) {
				iterator.remove();
			}
		}
		
		System.out.println("************************************************");
		for (Articulo articulo:articulos) {
			System.out.println(articulo);
		}
		
		
	}

}
