package ejerciciosRecursividad;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String[] ciudades = new String[5];
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<ciudades.length; i++) {
			System.out.println("Ingrese el nombre de la ciudad #" + (i+1) + ":");
			ciudades[i] = sc.nextLine();
		}
		sc.close();
		// imprimirArrayString(ciudades);
		recorrerArrayReverso(ciudades, ciudades.length-1);
		//System.out.println("****************************");
		//recorrerArray(ciudades, 0);*/
		
		int[] array = {1, 2, 3, 4};
		System.out.println(posElementoArray(array,5,0));
	}
	
	
	public static void imprimirArrayString(String[] array) {
		for (String str:array) {
			System.out.println(str);
		}
	}
	
	public static void recorrerArrayReverso(String[] array, int pos) {
		if (pos == 0) {
			System.out.println("Ciudad #" + (pos+1) + " : " + array[pos].toUpperCase());
		}
		else {
			System.out.println("Ciudad #" + (pos+1) + " : " + array[pos].toUpperCase() + "\t*");
			recorrerArrayReverso(array,pos-1);
		}
	}
	
	
	public static void recorrerArray(String[] array, int pos) {
		if (pos == array.length-1) {
			System.out.println("Ciudad #" + (pos+1) + " : " + array[pos].toUpperCase());
		}
		else {
			System.out.println("Ciudad #" + (pos+1) + " : " + array[pos].toUpperCase() + "\t*");
			recorrerArray(array,pos+1);
		}
	}
	
	public static int posElementoArray (int[] array, int elementoBuscar, int indice) {
		int pos;
		if (indice == array.length)
			return -1;
		else if (array[indice] == elementoBuscar) {
			return indice;
		}
		else {
			pos = posElementoArray(array,elementoBuscar,indice+1); 
		}
			
		return pos;
		
	}
	
	
}
