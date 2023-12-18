package tareaud8;

import java.io.Serializable;
import java.util.Objects;

public abstract class Jugador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int dorsal;
	
	public Jugador(String nombre, int dorsal) throws NbaException{
		if (dorsal <0 || dorsal > 100) {
			throw new NbaException("ERROR: El dorsal debe estar entre 0 y 100");
		}
		else {
			this.dorsal = dorsal;
		}
		this.nombre = nombre;
	}
	
	// Getters
	
	public int getDorsal() {
		return dorsal;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	// El criterio elegido para diferenciar objetos jugador el nombre y el número de dorsal
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Jugador)) {
			return false;
		}
		Jugador otro = (Jugador) obj;
		if (this.getNombre().equals(otro.getNombre()) && this.getDorsal() == otro.getDorsal()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, dorsal);
	}
	
	public abstract double getSalario();

}
