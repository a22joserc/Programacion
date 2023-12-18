package variable.referencia;

public class DemoCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coche coche1 = new Coche();
		Coche coche2;
		coche1.pasajeros = 5;
		coche1.deposito = 60;
		coche1.kpl=20;
		coche2 = coche1; //coche2 referencia al mismo objeto que coche1
		System.out.println("El coche 1 es " + coche1);
		System.out.println("El coche 2 es " + coche2);
		coche1 = null;//cambiamos la dirección de coche1 a null, ahora no apunta a ningún objeto
		// prueba a descomentar la siguiente instrucción y observa el error en tiempo de ejecución
		// coche1.deposito=33;
		coche2.deposito = 64;//puedo acceder al objeto creado a través de coche2
		coche2 = null;//el objeto creado es ahora inaccesible, java se encargará de borrarlo de memoria
		coche1 = new Coche();
		System.out.println("El coche 1 es " + coche1);
		//observa en el debugger que ahora coche1 tiene asociada otra dirección, de otro objeto
		coche2 = new Coche();//creamos otro objeto más
		System.out.println("El coche 2 es " + coche2);
		coche2 = coche1; //el objeto al que apuntaba coche2 queda inaccesible y coche2 apunta la mimso objeto que coche1
		System.out.println("El coche 2 es " + coche2);
		Coche coche3 = coche1;//ahora coche3 también apunta al objeto anterior
		coche1 = null;
		System.out.println("El coche 1 es " + coche1);
		coche2 = null;
		System.out.println("El coche 2 es " + coche2);
		coche3.pasajeros=4;//el objeto aun está accesible por coche3
		coche1 = coche3;//el objeto vuelve a estar accesible desde coche1
		coche2 = new Coche();//coche2 apunta a un nuevo objeto creado en memoria
		System.out.println("El coche 2 es " + coche2);
	}

}
