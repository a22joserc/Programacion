package ejmplosBasicosRecursividad;

public class Repaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		recorrerArray(new int[] {42,25,38,54,27,46,99,93,26,58,24,11}, 0);
		System.out.println(acumularArray(new int[] {1,2,3,6,10}, 0));
		System.out.println(posElementoArray(new int[] {1,2,3,6,2}, 2, 0));
		System.out.println(contarElementoArray(new int[] {1,2,3,6,2}, 2, 0));
		System.out.println(contarElementoArray(new int[] {1,2,3,6,2}, 3, 0));*/
		// System.out.println(sumaDigitos(123));
		
	    System.out.println(fibonacciRecursivo(8));

	 }

	
	public static void recorrerArray(int[] array, int indice) {
		if (indice == array.length-1) {
			System.out.println(array[indice]);
		}
		else {
			System.out.print(array[indice] + "\t");
			recorrerArray(array, indice+1);
		}
	}
	
	
	public static int acumularArray(int[] array, int indice) {
		int suma;
		if (indice == array.length-1) {
			suma = array[indice];
		}
		else {
			suma = array[indice]+acumularArray(array,indice+1);
		}
		return suma;
	}
	
	
	public static int posElementoArray(int[] array, int elemento, int indice) {
		int pos;
		if (indice == array.length-1) {
			if(array[indice] == elemento) {
				pos = indice;
			}
			else {
				pos = -1;
			}
		}
		else {
			if(array[indice] == elemento) {
				pos = indice;
			}
			else {
				pos = posElementoArray(array, elemento, indice+1);
			}
		}
		return pos;
	}
	
	
	public static int contarElementoArray(int[] array, int elemento, int indice) {
		int cont;
		if (indice == array.length-1) {
			if(array[indice] == elemento) {
				cont = 1;
			}
			else {
				cont = 0;
			}
		}
		else {
			if(array[indice] == elemento) {
				cont = contarElementoArray(array, elemento, indice+1) + 1;
			}
			else {
				cont = contarElementoArray(array, elemento, indice+1);
			}
		}
		return cont;
	}
	
	
	// SUMAR DIGITOS Número recursivamente
	 public static int sumaDigitos(int numero){
         
	        if(numero < 10){ //caso base
	            return numero; //devuelvo el numero
	        }else{
	        	System.out.println(numero/10);
	            return (numero % 10) + sumaDigitos(numero/10); //Cojo el digito y llamo a la funcion
	        }
	         
	         
	    }
	 

	 public static int fibonacciRecursivo(int n) {
	
	     //CASO BASE, si es cero devuelve un cero
	     //Puedes poner n&lt;=0 tamvien para incluir negativos
	     if (n == 0) {
	         return 0;
	     //CASO BASE, si es 1 devuelve un 1    
	     } else if (n == 1) {
	         return 1;
	     } else {
	         //Hago la suma
	         return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
	     }
	
	 }

}