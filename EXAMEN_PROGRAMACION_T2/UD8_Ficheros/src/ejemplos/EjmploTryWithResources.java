package ejemplos;

import java.io.FileInputStream;
import java.io.IOException;

public class EjmploTryWithResources {

	public static void main(String[] args) {
		/*
		try {
			printFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		*/
		printFileV2();

	}
	
	private static void printFile() throws IOException {
	    try(FileInputStream input = new FileInputStream("Ficheros\\nomeFicheiro.txt")) {
	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	 }
	
	private static void printFileV2() {
	    try(FileInputStream input = new FileInputStream("Ficheros\\nomeFicheiro.txt")) {
	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	    catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
	 }

}
