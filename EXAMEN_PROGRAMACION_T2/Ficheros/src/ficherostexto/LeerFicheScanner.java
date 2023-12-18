package ficherostexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerFicheScanner {

	public static void main(String[] args) {
		
		leerFicheroScanner("PruebasFicheros//input2.sws");
		leerFicheroScannerV2("PruebasFicheros//input.sws");
	}
	
	public static void leerFicheroScanner(String path) {
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static void leerFicheroScannerV2(String path) {
		File file = new File(path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
