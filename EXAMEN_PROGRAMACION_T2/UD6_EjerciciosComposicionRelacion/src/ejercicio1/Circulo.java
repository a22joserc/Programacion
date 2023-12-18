package ejercicio1;

public class Circulo {
	// Variables de clase
	private Punto centro;
	private int radio;
	// Constructor por defecto
	public Circulo() {
		this.radio = 0;
		this.centro = new Punto();
	}
	
	// Constructor por paso de parámetrps
	public Circulo(int radio, Punto centro) {
		this.radio = radio;
		this.centro = centro;
	}
	
	public Circulo(int radio, int x, int y) {
		this.radio = radio;
		this.centro = new Punto(x,y);
	}
	
	// SETTERS
	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
	// GETTERS
	
	public Punto getCentro() {
		return this.centro;
	}
	
	public int getRadio() {
		return this.radio;
	}
	@Override
	public String toString() {
		return "El círculo con centro de coordenadas:  " + this.centro.toString() + " tiene un radio de " + this.getRadio();
	}
}
