package ejercicio6;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		// Instanciamos reservas
		Reserva reserva1 = new Reserva("SCQ", "NYC", "27C", false, new Persona("Jose", "Fernández", "1234567H", 27, "Española"));
		Reserva reserva2 = new Reserva("SCQ", "LON", "02C", true, new Persona("Maria", "Gómez", "45678912H", 27, "Española"));
		Reserva reserva3 = new Reserva("SCQ", "AMS", "20C", false, new Persona("Antonio", "García", "74185296H", 27, "Española"));
		Reserva reserva4 = new Reserva("SCQ", "DET", "29A", true, new Persona("Ramón", "López", "32145698H", 27, "Española"));
		Reserva reserva5 = new Reserva("SCQ", "LAX", "26B", false, new Persona("Lorena", "Pérez", "21456378H", 27, "Española"));
		Reserva reserva6 = new Reserva("SCQ", "BRU", "06B", true, new Persona("Bonifacio", "Martínez", "95184623H", 18, "Española"));
		
		Avion avion = new Avion();
		
		avion.insert(reserva1);
		avion.insert(reserva1);
		avion.insert(reserva1);
		avion.insert(reserva6);
		Reserva current = avion.getListaReservas().getLast();
		avion.setCurrent(current);
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		avion.remove(reserva1);
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		avion.goFirst();
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		avion.advance();
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		avion.remove(current);
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		System.out.println(avion.isOnList());
		imprimirLista(avion.getListaReservas());
		System.out.println("***************************************************************************************************************************");
		System.out.println(avion.getCurrent());
		System.out.println("***************************************************************************************************************************");
		System.out.println(avion.getPrevious());
		
	}
	
	private static void imprimirLista(LinkedList<Reserva> lista) {
		Iterator<Reserva> iterator = lista.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
