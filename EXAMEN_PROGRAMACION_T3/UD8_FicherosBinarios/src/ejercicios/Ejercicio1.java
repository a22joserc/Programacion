package ejercicios;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		// String path = args[0];
		String path = "proba.txt";
		
        // Leemos fichero proba.txt
        try(FileInputStream fileInputStream = new FileInputStream(path);
        	FileOutputStream fileOutputStream = new FileOutputStream("copiaProba.txt");
        	DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
        	// Leemos fichero
            int ch = fileInputStream.read();
            while(ch != -1) {
                System.out.print((char)ch);
                // fileOutputStream.write(ch);
                dataOutputStream.writeChar(ch);
                ch = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro non encontrado");
        } catch (IOException e) {
            System.err.println("Error na E/S");
        } 
        
	}
		

}
