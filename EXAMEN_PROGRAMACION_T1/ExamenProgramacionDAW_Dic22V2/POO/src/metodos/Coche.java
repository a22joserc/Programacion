package metodos;

public class Coche {
	
	int pasajeros;
	int deposito;
	int kpl;
	
	public void arranca() {
		System.out.println("El coche arranca");
	}
	
	public int calcularAutonomia() {
		return kpl*deposito;
	}
	
	public double gasofaNecesaria(int km) {
		return (double) km/kpl;
		
	}

}
