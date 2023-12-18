package ejerciciosfile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Libreria io
		File file = new File("test.txt");
		System.out.println(file.getName() + " es un fichero? " + file.isFile());
		System.out.println(file.getName() + " se puede escribir ? " + file.canWrite());
		
		// Libreria nio
		Path path = Paths.get("test.txt");
		System.out.println(path.getFileName() + " es un fichero? " + Files.isRegularFile(path));
		System.out.println(path.getFileName() + " se puede escribir? " + Files.isWritable(path));
	}

}
