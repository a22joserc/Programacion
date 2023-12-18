package ejemplos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {

		try {
		    BufferedReader reader = new BufferedReader(new FileReader("Ficheros\\nomeFicheiro.txt"));
		    String linea = reader.readLine();
		    while(linea != null) {
		        // procesar o texto da liña
		    	System.out.println(linea);
		        linea = reader.readLine();
		    }
		    reader.close();
		  }
		  catch(FileNotFoundException e) {
			  // non se atopou o ficheiro
			  System.out.println(e.getMessage());
			  
		  }
		  catch(IOException e) {
			  // algo foi mal ó ler ou pechar o ficheiro
			  System.out.println(e.getMessage());
		  }
		
	}

}
