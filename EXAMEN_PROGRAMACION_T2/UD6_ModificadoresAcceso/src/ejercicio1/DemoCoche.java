package ejercicio1;

public class DemoCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Coche coche1 = new Coche();
 		coche1.pasajeros=5;
 		coche1.deposito=60;
 		coche1.kpl=20;
 		System.out.println("Pasajeros coche1: "+coche1.pasajeros);
 		System.out.println("Deposito coche1: "+coche1.deposito);
 		System.out.println("Kpl coche1: "+coche1.kpl);
 		coche1.autonomia();
		 */
		Coche coche1 = new Coche();
		coche1.setPasajeros(5);
		coche1.setDeposito(60);
		coche1.setKpl(20);
		System.out.println("Pasajeros coche1: " + coche1.getPasajeros());
		System.out.println("Deposito coche1: " + coche1.getDeposito());
		System.out.println("Kpl coche1: " + coche1.getDeposito());
		coche1.autonomia();

	}

}
