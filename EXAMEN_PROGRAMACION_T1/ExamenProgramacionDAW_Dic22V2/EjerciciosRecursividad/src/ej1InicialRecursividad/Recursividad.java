package ej1InicialRecursividad;

public class Recursividad {
	void imprimir(int x) {
		/*imprimir(x);
		System.out.println(x);*/
		if (x>0) {
			System.out.println(x);
			imprimir(x-1);
		}
	} 
}
