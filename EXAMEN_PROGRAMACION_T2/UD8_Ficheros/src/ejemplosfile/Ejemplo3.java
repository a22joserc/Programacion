package ejemplosfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo3 {

	public static void main(String[] args) {
		// Libreria io
		File file = new File("test2.txt");
		boolean result = file.delete();
		
		// Libreria nio
		Path path = Paths.get("test3.txt");
		try {
			Files.delete(path);
		} catch (IOException e) {
			System.out.println("No se ha podido borrar el fichero " + e.getMessage());
		}
	}

}
