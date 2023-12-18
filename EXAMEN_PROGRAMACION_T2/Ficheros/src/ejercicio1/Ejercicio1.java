package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		String path = "FicherosEjercicio1//Prueba.txt";
		String pathTmp = "FicherosEjercicio1//Pruebatmp.txt";
		// leerFicheroCrearTempFile(path);
		leerEscribirFichero(path, pathTmp);
		
	}
	
	public static void leerFicheroCrearTempFile(String path) {
		File file = new File(path);
		ArrayList<String> lineas = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String linea = scanner.nextLine();
				linea = linea.replaceAll("\\s", "");
				String fin = linea.substring(1);
				String inicio = linea.substring(0,1).toUpperCase();
				lineas.add(inicio.concat(fin));
				System.out.println(inicio.concat(fin));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			File tmpFile = File.createTempFile("Fichero", ".tmp", new File(".//FicherosEjercicio1"));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
			for (String str: lineas) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void leerFicheroCrearTempFileV2(String path) {
		File file = new File(path);
		ArrayList<String> lineas = new ArrayList<>();
		try {
			// Leemos fichero
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String linea = scanner.nextLine();
				linea = linea.replaceAll("\\s", "");
				String fin = linea.substring(1);
				String inicio = linea.substring(0,1).toUpperCase();
				lineas.add(inicio.concat(fin));
				System.out.println(inicio.concat(fin));
			}
			scanner.close();
			// Creamos fichero temporal
			File tmpFile = File.createTempFile("Fichero", ".tmp", new File(".//FicherosEjercicio1"));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
			for (String str: lineas) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			// Sobreescribimos fichero original;
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void leerEscribirFichero(String pathFichero, String pathFicheroTmp) {
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFichero));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFicheroTmp))){
			// Leemos linea
			String linea = bufferedReader.readLine();
			while(linea !=null) {
				// Modificamos linea
				linea = linea.replaceAll("\\s", "");
				String fin = linea.substring(1);
				String inicio = linea.substring(0,1).toUpperCase();
				String newLinea = inicio.concat(fin);
				// Imprimimos línea
				bufferedWriter.write(newLinea);
				bufferedWriter.newLine();
				// Leemos línea
				linea = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
