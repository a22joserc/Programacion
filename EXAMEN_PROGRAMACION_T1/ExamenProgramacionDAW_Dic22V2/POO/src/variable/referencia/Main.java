package variable.referencia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Coche coche1 = new Coche();
		Coche coche2;
		coche1.pasajeros=5;
		coche1.deposito=60;
		coche1.kpl=20;
		coche2 = coche1; //coche2 referencia al mismo objeto que coche1
		//demostramos ahora que referencian al mismo objeto
		System.out.println("datos del objeto que referencia coche1:");
		System.out.println("\tpasajeros:" + coche1.pasajeros);
		System.out.println("\tdeposito:" + coche1.deposito);
		System.out.println("\tkpl:" + coche1.kpl);
		coche1.kpl=30;
		System.out.println("datos del objeto que referencia coche2:");
		System.out.println("\tpasajeros:" + coche2.pasajeros);
		System.out.println("\tdeposito:" + coche2.deposito);
		System.out.println("\tkpl:" + coche2.kpl);
		System.out.println("\tkpl:" + coche1.kpl);
	
		//creamos un nuevo objeto y lo referenciamos a través de coche2.
		coche2 = new Coche();
		coche2.pasajeros=7;
		coche2.deposito=70;
		coche2.kpl=25;
		System.out.println("datos del objeto que referencia coche2:");
		System.out.println("\tpasajeros:" + coche2.pasajeros);
		System.out.println("\tdeposito:" + coche2.deposito);
		System.out.println("\tkpl:" + coche2.kpl);
		coche1=null; //desconecto a coche1 del objeto creado, ahora no referencia a ningún objeto
		coche2=null;//idem para coche2
		System.out.println("El objeto coche creado en la primera línea se perdió para siempre");
		System.out.println("\tpasajeros:" + coche2.pasajeros);
		System.out.println("\tdeposito:" + coche2.deposito);
		System.out.println("\tkpl:" + coche2.kpl);*/
		
		
		Coche coche1 = new Coche();
		coche1.pasajeros=5;
		coche1.deposito=60;
		coche1.kpl=20;
		System.out.println("El coche 1 " + coche1);
		Coche coche2 = new Coche();
		coche2.pasajeros=5;
		coche2.deposito=60;
		coche2.kpl=20;
		System.out.println("El coche 2 " + coche2);
		Coche coche3=coche1;
		System.out.println("El coche 3 " + coche3);
		System.out.println("La variable referencia coche3 es " + (coche3==coche2?"igual":"distinta") + " a la variable referencia coche2");
		System.out.println("La variable referencia coche3 es " + (coche3==coche1?"igual":"distinta") + " a la variable referencia coche1");
		System.out.println("La variable referencia coche1 es " + (coche1==coche2?"igual":"distinta") + " a la variable referencia coche2");
		// System.out.println("La variable referencia coche1 es " + (coche1==coche1?"igual":"distinta") + " a la variable referencia coche1");
	}

}
