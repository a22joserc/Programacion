package constructores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche coche1 = new Coche(5, 100, 5);
		Coche coche2 = new Coche(5, 150, 7);
		// Coche coche1 = new Coche();
		coche1.imprimirEstado();
		coche2.imprimirEstado();
		System.out.println("El coche 1 tiene mayor autonomica que el coche 2: " + coche1.comparaAutonomia(coche2));
		System.out.println("El coche con mayor autonomia es: " + coche1.cocheMasAutonomia(coche2));
		System.out.println("El coche con mayor autonomia es: " + coche2.cocheMasAutonomia(coche1));
	}

}
