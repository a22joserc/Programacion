package metodos;

public class Bicicleta {
	private double vel;
	private int marcha;
	// Sobrecarga de constructores
	public Bicicleta() {
		vel=0;
		marcha=1;
	}
	
	public Bicicleta(double vel) {
		this.vel=vel;
	}
	
	public Bicicleta(int marcha) {
		this.marcha=marcha;
		
	}
	
	public Bicicleta(double vel, int marcha) {
		this.vel=vel;
		this.marcha=marcha;
	}
	
	public int getMarcha() {
		return marcha;
	}
	
	public double getVel() {
		return vel;
	}
	
	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}
	
	public void setVel(int vel) {
		this.vel = vel;
	}
	
	public void cambiarMarcha(int nuevaMarcha) {
		marcha=nuevaMarcha;
	}
	
	public void acelerar(int incremento) {
		vel=vel+incremento;
	}
	
	public void frenar(int decremento) {
		vel=vel-decremento;
	}
	
	public void imprimirEstado() {
		System.out.println("Marcha: " + marcha);
		System.out.println("Velocidad: " + vel);
	}

}
