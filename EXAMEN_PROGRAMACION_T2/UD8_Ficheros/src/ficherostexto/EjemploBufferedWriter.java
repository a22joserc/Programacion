package ficherostexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploBufferedWriter {

	public static void main(String[] args) throws IOException {
		
        BufferedWriter writer = new BufferedWriter(new FileWriter("testBuffered.txt"));
        try (writer) {         
            writer.write("Esto e unha linea");
            writer.newLine();
        }     
	}
		
}	


