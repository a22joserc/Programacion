package ejercicio4;

import ejercicio2.Persona;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		MiListaEnlazada<Persona> miListaEnlazada = new MiListaEnlazada<>();
		miListaEnlazada.insertar(new Persona("Pepe", 98153970));
		miListaEnlazada.insertar(new Persona("Bolo", 98153971));
		miListaEnlazada.insertar(new Persona("Boni", 98153972));
		miListaEnlazada.insertar(new Persona("Piru", 98153973));
		
		System.out.println(miListaEnlazada.obtener(3));
		
		
	}
}
