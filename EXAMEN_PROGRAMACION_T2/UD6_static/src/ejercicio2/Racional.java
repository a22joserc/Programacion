package ejercicio2;

public class Racional {
	// Variables de clase
	public int numerador;
	public int denominador;
	// Constructor
	public Racional(int numerador, int denominador){
		this.numerador=numerador;
		this.denominador=denominador;
	}
	// Método
	public void multiplicar(Racional r1, Racional r2){
		this.numerador=r1.numerador*r2.numerador;
		this.denominador=r1.denominador*r2.denominador;
	}
	
	// Método multiplicar Stático
	public static Racional multiplicarSt(Racional r1, Racional r2) {
		return new Racional(r1.numerador*r2.numerador, r1.denominador*r2.denominador);
	}

}
