package ejercicio6;

import java.util.Iterator;
import java.util.LinkedList;

public class Avion implements Ejercicio6{
	
	private LinkedList<Reserva> listaReservas = new LinkedList<>();
	private Reserva current;
	
	public void setCurrent(Reserva current) {
		this.current = current;
	}

	public LinkedList<Reserva> getListaReservas() {
		return listaReservas;
	}
	
	
	public void insert(Object x) {
		// Inserta Objeto reserva
		Reserva reserva = (Reserva) x;
		this.listaReservas.add(reserva);
	}
	
	public void remove(Object x) {
		// Elimina el primer x
		Reserva reserva = (Reserva) x;
		// this.listaReservas.removeFirstOccurrence(reserva);
		Iterator<Reserva> iterator = this.listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(reserva)) {
				iterator.remove();
				break;
			}
		}
	}

	public void removeCurrent() { 
		//Elimina el elemento current
		Iterator<Reserva> iterator = this.listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(this.current)) {
				iterator.remove();
			}
		}
	}
	public boolean find(Object x) {
		// Coloca current para poder ver x
		Reserva reserva = (Reserva) x;
		// return listaReservas.contains(reserva);
		Iterator<Reserva> iterator = this.listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(reserva)) {
				return true;
			}
		}
		return false;
	}
	public void goFirst() {
		int pos = this.listaReservas.indexOf(this.current);
		Reserva temp = this.listaReservas.getFirst();
		this.listaReservas.set(0, this.current);
		this.listaReservas.set(pos, temp);
	}
	
	public void advance() {
		int pos = this.listaReservas.indexOf(this.current);
		Reserva temp = this.listaReservas.get(pos+1);
		this.listaReservas.set(pos, temp);
		this.listaReservas.set(pos+1, this.current);
	}
	public boolean isOnList() {
		Iterator<Reserva> iterator = this.listaReservas.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(this.current)) {
				return true;
			}
		}
		return false;
	}
	public Object getCurrent(){
		//Elemento en la posición current
		int pos = this.listaReservas.indexOf(this.current);
		if (pos !=-1) {
			return this.listaReservas.get(pos);
		}
		else {
			return null;
		}
	}
	
	public Object getPrevious() {
		int pos = this.listaReservas.indexOf(this.current)-1;
		if (pos >= 0) {
			return this.listaReservas.get(pos);
		}
		else {
			return null;
		}
	}
	

}
