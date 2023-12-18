package ejercicio6;

public class DemoEjercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Utilidades.imprimir(1);
	    Utilidades.imprimir(1.8);
	    Utilidades.imprimir('a');
	    Utilidades.imprimir("un string");
	    Utilidades u1 = new Utilidades();
	    Utilidades.imprimir(u1.sumar('a',2));
	    u1.imprimir(u1.sumar(4,5));
	    Utilidades.imprimir(u1.sumar("hola", " y adios"));
	    //Utilidades.imprimir(Utilidades.sumar('a',2)); ¡ERROR!
			 



	}

}
