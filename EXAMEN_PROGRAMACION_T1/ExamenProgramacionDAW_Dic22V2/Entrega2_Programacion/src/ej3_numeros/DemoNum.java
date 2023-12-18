package ej3_numeros;

public class DemoNum {

	public static void main(String[] args) {
		// Instancimos el objeto c1 de la clase complejo con el constructor por defecto
		Complejo c1 = new Complejo();
		// Imprimimos el numero complejo c1
		System.out.println("El número complejo c1 es " + c1.toString());
		// Añadimos la parte real con el setReal
		c1.setReal(3);
		// Añadimos la parte imag con el setImag
		c1.setImag(4);
		// Imprimimos el numero complejo c1 modificado
		System.out.println("Ahora el número complejo c1 es " + c1.toString());
		// Instancimos el objeto c2 de la clase complejo con el constructor por parametros
		Complejo c2 = new Complejo(1,2);
		// Probamos métodos get
		System.out.println("El número complejo c2 tiene una parte real  " + c2.getReal() + " y una parte imagniaria " + c2.getImag());
		// Probamos a sumar al c1 el c2
		c1.sumar(c2);
		System.out.println("Al sumar c2 a c1 el nuevo valor de c1 es " + c1.toString());
		
	}

}
