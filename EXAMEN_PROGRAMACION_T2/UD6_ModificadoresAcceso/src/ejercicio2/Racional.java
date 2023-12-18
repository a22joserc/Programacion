package ejercicio2;

public class Racional {
	// Variables de clase encapsuladas 
	private int numerador;
	private int denominador;
	
	// Constructor
	public Racional(int numerador, int denominador){
		this.numerador=numerador;
		this.denominador=denominador;
	}
	
	// GETTERS
	public int getNumerador() {
		return this.numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	// SETTERS
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	// Método Multiplicar
	public static Racional multiplicar(Racional r1, Racional r2){
		Racional resultado= new Racional(1,1);
		resultado.numerador=r1.numerador*r2.numerador;
		resultado.denominador=r1.denominador*r2.denominador;
		return resultado;
	}


}
