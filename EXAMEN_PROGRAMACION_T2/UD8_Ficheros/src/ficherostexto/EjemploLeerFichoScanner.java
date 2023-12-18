package ficherostexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EjemploLeerFichoScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		String linea;
		
		/*
		 * Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				linea = scanner.next();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
		*/
		//
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNext()) {
				linea = scanner.next();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
