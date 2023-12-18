package ejmplosBasicosRecursividad;

public class DemoRecursividad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Recursividad recursividad = new Recursividad();
		// Mulpicar un número por si mismo n veces
		System.out.println("RECURSIVIDAD: Sumar numeros hasta un determinado valor");
		System.out.println(recursividad.sumarNumeros(4));
		// Mulpicar un número por si mismo n veces
		System.out.println("RECURSIVIDAD: Imprimir descendentemente numeros");
		recursividad.imprimirNumerosDescendentes(5);
		// Mulpicar un número por si mismo n veces
		System.out.println("RECURSIVIDAD: Calcular recursivamente facorial");
		System.out.println(recursividad.multiplicar(7,5));
		// Factorial recursivo de un número
		System.out.println("RECURSIVIDAD: Calcular recursivamente facorial");
		System.out.println(recursividad.factorial(5));
		int[] array= {1,2,3,5};
		// Recorrer array recursivamente
		System.out.println("RECURSIVIDAD: Recorrer array");
		recursividad.recorrerArray(array, 0);
		// Suma recursiva de todos los elementos de un array
		System.out.println("RECURSIVIDAD: Suma de todos los elementos de un array");
		System.out.println(recursividad.acumuladorRecursivoArray(array,0));
		// Busca recursiva de un elemento de un array
		System.out.println("RECURSIVIDAD: Buscar posción elemento array");
		System.out.println(recursividad.posicionElementoArray(array, 6, 0));
		// Recorrer matriz con recursividad
		System.out.println("RECURSIVIDAD: Recorrer matriz");
		int[][] matrix = {{1, 2, 3},
						  {4, 5, 6, 10, 11},
						  {7, 8, 9}};
		recursividad.recorrerMatrix(matrix, 0, 0);*/
		
		// System.out.println(potencia(5,-2));
		String str = "hola";
		System.out.println(reverseString(str,str.length()-1));
		System.out.println(reverseEntero(254, 2));
		
	}
	
	public static double potencia(int base, int exponente) {
		double potencia;
		if (exponente==0) {
			potencia = 1;
		}
		else if (exponente > 1) {
			potencia = base * potencia(base,exponente-1);
		}
		else {
			potencia = potencia(base, exponente+1) / base;
		}
		
		return potencia;
	}
	
	public static String reverseString(String str, int index) {
		String revStr;
		if(index == 0) {
			revStr = Character.toString(str.charAt(index));
		}
		else {
			revStr = Character.toString(str.charAt(index)) + reverseString(str,index-1);
		}
		return revStr;
		
	}
		
	public static int reverseEntero(int num, int pos) {
		int revNum;
		if (num<10) {
			revNum = num;
		}
		else {
			revNum = (num % 10) * (int) Math.pow(10, pos) + (reverseEntero(num/10, pos-1));
		}
		return revNum;
	}
	
}
