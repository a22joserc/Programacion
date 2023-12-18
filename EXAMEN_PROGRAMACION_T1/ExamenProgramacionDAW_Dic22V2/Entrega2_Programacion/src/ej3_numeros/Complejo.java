package ej3_numeros;

public class Complejo {
	private double real;
	private double imag;
	
	// CONSTRUCTOR POR DEFECTO
	public Complejo(){
		real=0;
		imag=0;
	}
	
	// CONSTRUCTOR POR PASO DE PARAMETROS
	public Complejo(double real, double imag){
		this.real = real;
		this.imag = imag;
	}
	
	// GETTERS
	public double getReal() {
		return this.real;
	}
	
	public double getImag() {
		return this.imag;
	}
	
	// SETTERS
	public void setReal(double real) {
		this.real = real;
	}
	
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	// Método toString
	@Override
	public String toString() {
		return (real + " + " + imag + "i");
	}
	
	// Metodo para sumar complejos
	public void sumar(Complejo b) {
		this.real += b.getReal();
		this.imag += b.getImag();
		
	}

}
