package string;

public class Complejo {
	private double real;
	private double imag;
	
	public Complejo(){
		real=0;
		imag=0;
	}
	
	public Complejo(double real, double imag){
		this.real = real;
		this.imag = imag;
	}
	
	public double getReal() {
		return this.real;
	}
	
	public double getImag() {
		return this.imag;
	}
	
	public void setReal(double real) {
		this.real = real;
	}
	
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	@Override
	public String toString() {
		return (real + " + " + imag + "i");
	}
	
	public void sumar(Complejo b) {
		this.real += b.getReal();
		this.imag += b.getImag();
		
	}

}