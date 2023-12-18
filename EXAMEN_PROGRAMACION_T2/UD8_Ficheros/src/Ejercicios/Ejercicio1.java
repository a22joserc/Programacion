package Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner scanner = null;
		try {
		    scanner = new Scanner(new File("test.txt"));
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} finally {
		    if (scanner != null) {
		        scanner.close();
		    }
		}
		*/
		printFileV2();
	}
	
	
	private static void printFileV2() {
	    try(Scanner scanner = new Scanner(new File("test.txt"))) {
	    	while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
	        }
	    }
	    catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
	 }

}
