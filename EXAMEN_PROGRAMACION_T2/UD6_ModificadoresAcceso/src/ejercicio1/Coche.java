package ejercicio1;

public class Coche {
	private int pasajeros; //número de pasajeros
	private int deposito; //capacidad del depositos en litros
	private int kpl; //kilometros que se pueden recorrer con un litro,
	// Getters
	public int getPasajeros() {
		return pasajeros;
	}
	public int getDeposito() {
		return deposito;
	}
	public int getKpl() {
		return kpl;
	}
	// Setters
	public void setPasajeros(int pasajeros) {
		this.pasajeros=pasajeros;
	}
	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	public void setKpl(int kpl) {
		this.kpl = kpl;
	}
	// Método cálcular autonomia
	public void autonomia(){
		System.out.println("Autonomía:" + deposito*kpl);
	}

}
