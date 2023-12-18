package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el número de filas: ");
		int row = Integer.parseInt(scanner.nextLine());
		System.out.println("Introduzca el número de columnas: ");
		int col = Integer.parseInt(scanner.nextLine());
		double[][] matrix = new double[row][col];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				System.out.println("Introduzca el elemento (" + i + ", " + j + ") de la matriz");
				matrix[i][j] = Double.parseDouble(scanner.nextLine());
			}
		}
		scanner.close();
		imprimirMatriz(matrix);
		System.out.println("********************************************");
		imprimirMatrizFicheroBinario(matrix,"./matrizBinaria.dat");
		System.out.println("********************************************");
		leerMatrizFicheroBinario("./matrizBinaria.dat");

	}
	
	
	public static void imprimirMatriz(double[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static void imprimirMatrizFicheroBinario(double[][] matrix, String path) {
		try(FileOutputStream fieFileOutputStream = new FileOutputStream(path);
			DataOutputStream dataOutputStream = new DataOutputStream(fieFileOutputStream)){
			// Escribimos matriz
			for (int i=0; i<matrix.length; i++) {
				for (int j=0; j<matrix[i].length; j++) {
					dataOutputStream.writeDouble(matrix[i][j]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void leerMatrizFicheroBinario(String path) {
		try(FileInputStream fileInputStream = new FileInputStream(path);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream)){
			while(true) {
				System.out.println(dataInputStream.readDouble());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (EOFException e) {
            System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
