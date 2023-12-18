package constructores;

public class Coche {
	private int pasajeros;
	private int deposito;
	private int kpl;
	private double precio;
	
	public Coche() {
		pasajeros = 5;
		deposito = 100;
		kpl = 20;
		precio = 28000.5;
		
	}
	
	public Coche(int pasajeros, int deposito, int kpl, double precio) {
		this.pasajeros = pasajeros;
		this.deposito = deposito;
		this.kpl = kpl;
		this.precio = precio;
		
	}
	
	public Coche(int pasajeros, int deposito, int kpl) {
		this.pasajeros = pasajeros;
		this.deposito = deposito;
		this.kpl = kpl;
		
	}
	
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	
	public void setKpl(int kpl) {
		this.kpl = kpl;
	}
	
	public int getDeposito() {
		return deposito;
	}
	
	public int getPasajeros() {
		return pasajeros;
	}
	
	public int getKpl() {
		return kpl;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int calcularAutonomia() {
		return deposito*kpl;
	}
	
	public double gasofaNecesaria(int km) {
		return (double) km/kpl;
	}
	
	public void imprimirEstado() {
		System.out.println("Pasajeros: " + pasajeros);
		System.out.println("Depósito: " + deposito);
		System.out.println("Km por litro: " + kpl);
		System.out.println("Precio: " + precio);
		System.out.println("Autonomia: " + calcularAutonomia());
		
	}
	
	public boolean comparaAutonomia(Coche coche) {
		return this.calcularAutonomia()>coche.calcularAutonomia();
	}
	
	public Coche cocheMasAutonomia(Coche coche) {
		if(this.calcularAutonomia()>coche.calcularAutonomia()) {
			return this;
		}
		else {
			return coche;
		}
	}
	
	/*
	public Coche cocheMasAutonomia2(Coche coche) {
		return (this.calcularAutonomia()>coche.calcularAutonomia()? this:coche);
	}*/
	

}
