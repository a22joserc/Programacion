package ejercicio6;

import java.util.Iterator;
import java.util.LinkedList;

public class MainAvion implements Ejercicio6 {
	
	private LinkedList<Reserva> listaReservas = new LinkedList<>();
	private Reserva current;
	
	public static void main(String[] args) {
		
		MainAvion avion = new MainAvion();
		Reserva reserva1 = new Reserva("SCQ", "NYC", "27C", false, new Persona("Jose", "Fernández", "1234567H", 27, "Española"));
		Reserva reserva2 = new Reserva("SCQ", "LON", "02C", true, new Persona("Maria", "Gómez", "45678912H", 27, "Española"));
		Reserva reserva3 = new Reserva("SCQ", "AMS", "20C", false, new Persona("Antonio", "García", "74185296H", 27, "Española"));
		Reserva reserva4 = new Reserva("SCQ", "DET", "29A", true, new Persona("Ramón", "López", "32145698H", 27, "Española"));
		Reserva reserva5 = new Reserva("SCQ", "LAX", "26B", false, new Persona("Lorena", "Pérez", "21456378H", 27, "Española"));
		Reserva reserva6 = new Reserva("SCQ", "BRU", "06B", true, new Persona("Bonifacio", "Martínez", "95184623H", 18, "Española"));
		//
		
		avion.insert(reserva1);
		avion.insert(reserva1);
		avion.insert(reserva1);
		avion.insert(reserva6);
		avion.current = avion.listaReservas.getLast();
		imprimirLista(avion.listaReservas);
		System.out.println("***************************************************************************************************************************");
		avion.remove(reserva1);
		imprimirLista(avion.listaReservas);
		System.out.println("***************************************************************************************************************************");
		avion.goFirst();
		imprimirLista(avion.listaReservas);
		System.out.println("***************************************************************************************************************************");
		avion.advance();
		imprimirLista(avion.listaReservas);
		System.out.println("***************************************************************************************************************************");
		avion.remove(avion.current);
		imprimirLista(avion.listaReservas);
		System.out.println("***************************************************************************************************************************");
		System.out.println(avion.isOnList());
		imprimirLista(avion.listaReservas);
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
	
	
	// Métodos Interface
	
	public void insert(Object x) {
		// Inserta Objeto reserva
		Reserva reserva = (Reserva) x;
		listaReservas.add(reserva);
	}
	
	public void remove(Object x) {
		// Elimina el primer x
		Reserva reserva = (Reserva) x;
		// listaReservas.removeFirstOccurrence(reserva);
		Iterator<Reserva> iterator = listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(reserva)) {
				iterator.remove();
				break;
			}
		}
	}

	public void removeCurrent() { 
		//Elimina el elemento current
		Iterator<Reserva> iterator = listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(current)) {
				iterator.remove();
			}
		}
	}
	public boolean find(Object x) {
		// Coloca current para poder ver x
		Reserva reserva = (Reserva) x;
		// return listaReservas.contains(reserva);
		Iterator<Reserva> iterator = listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(reserva)) {
				return true;
			}
		}
		return false;
	}
	public void goFirst() {
		int pos = listaReservas.indexOf(current);
		Reserva temp = listaReservas.getFirst();
		listaReservas.set(0, current);
		listaReservas.set(pos, temp);
	}
	
	public void advance() {
		int pos = listaReservas.indexOf(current);
		Reserva temp = listaReservas.get(pos+1);
		listaReservas.set(pos, temp);
		listaReservas.set(pos+1, current);
	}
	public boolean isOnList() {
		Iterator<Reserva> iterator = listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(current)) {
				return true;
			}
		}
		return false;
	}
	public Object getCurrent(){
		//Elemento en la posición current
		int pos = listaReservas.indexOf(current);
		if (pos !=-1) {
			return listaReservas.get(pos);
		}
		else {
			return null;
		}
	}
	
	public Object getPrevious() {
		int pos = listaReservas.indexOf(current)-1;
		if (pos >= 0) {
			return listaReservas.get(pos);
		}
		else {
			return null;
		}
	}
	
}
