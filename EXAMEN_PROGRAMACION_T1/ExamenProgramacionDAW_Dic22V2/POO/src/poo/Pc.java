package poo;

public class Pc {
	int kw;
	long serial;
	int puertos;
	Raton raton;
	Teclado teclado;
	
	@Override
	public String toString() {
		return "El PC tiene un numero de serie: " + serial + " y potencia " + kw; 
	}
	

}
