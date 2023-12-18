package ficherostexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroBufferReader {

	public static void main(String[] args) {
		
		// leerFicheroBufferReader("PruebasFicheros//input.sws");
		// leerFicheroBufferReaderV2("PruebasFicheros//input.sws");
		leerFicheroBufferReaderV3("PruebasFicheros//input.sws");
	}
	
	public static void leerFicheroBufferReader(String path) {
		File file = new File(path);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String linea = bufferedReader.readLine();	
			while (linea != null) {
				System.out.println(linea);
				linea = bufferedReader.readLine();	
			}
			bufferedReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	public static void leerFicheroBufferReaderV2(String path) {
		File file = new File(path);
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String linea = bufferedReader.readLine();	
			while (linea != null) {
				System.out.println(linea);
				linea = bufferedReader.readLine();	
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			
		}	
		finally {
			if (bufferedReader !=null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public static void leerFicheroBufferReaderV3(String path) {
		// Try-with-resources
		File file = new File(path);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String linea = bufferedReader.readLine();	
			while (linea != null) {
				System.out.println(linea);
				linea = bufferedReader.readLine();	
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	
}
