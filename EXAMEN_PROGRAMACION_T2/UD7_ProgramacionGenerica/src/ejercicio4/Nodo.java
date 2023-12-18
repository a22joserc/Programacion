package ejercicio4;

public class Nodo<T> {
	
	private Nodo sig;
	private T dato;
	
	public Nodo(T dato) {
		this.dato = dato;
	    this.sig=null;
	}
	
	public Nodo(T dato, Nodo sig) {
		this.dato = dato;
	    this.sig = sig;
	}
	
	public void setSiguiente(Nodo sig) {
	    this.sig = sig;
	}
	
	public Nodo getSiguiente() {
	    return sig;
	}
	
	public T getDato() {
	    return dato;
	}
	
}

