package ejemplosfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo4 {

	public static void main(String[] args) {
		// Librería io
		File file = new java.io.File("titorial.txt");
		try {
			boolean result = file.createNewFile();
		} catch (IOException e) {
			System.out.println("No se ha podido borrar el fichero " + e.getMessage());
		}
		// Libreria nio
		Path path = Paths.get("titorial2.txt");
		try {
			Path newPath = Files.createFile(path);
		} catch (IOException e) {
			System.out.println("No se ha podido borrar el fichero " + e.getMessage());
		}
		
		// Libreria nio
		Path pathDirectorio = Paths.get("PruebasJava");
		try {
			Path newPath2 = Files.createDirectory(pathDirectorio);
		} catch (IOException e) {
			System.out.println("No se ha podido borrar el fichero " + e.getMessage());
		}
	}

}
