package sobrecarga.metodos;

import metodos.Bicicleta;

public class MainBicicleta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************ BICICLETA 1 *********************");
		Bicicleta b1 = new Bicicleta(20,2); 
		b1.imprimirEstado();
		System.out.println("**********************************************");
		b1.acelerar(10);
		b1.frenar(5);
		b1.cambiarMarcha(4);
		System.out.println("*************** ESTADO ***********************");
		b1.imprimirEstado();
		System.out.println("**********************************************");
		System.out.println("La velocidad es " + b1.getVel());
		System.out.println("************ BICICLETA 2 *********************");
		Bicicleta b2 = new Bicicleta();
		b2.imprimirEstado();
		System.out.println("**********************************************");
		b2.setMarcha(1);
		b2.acelerar(20);
		b2.frenar(10);
		System.out.println("*************** ESTADO ***********************");
		b2.imprimirEstado();
		System.out.println("**********************************************");
	}
}
