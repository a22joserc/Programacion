package ficherostexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo1LeerFichero {

	public static void main(String[] args) throws IOException {
		
		/*
        File doc = new File("test.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doc))){
        String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
        */
		
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("test.txt")))){
        String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }

	}
}
