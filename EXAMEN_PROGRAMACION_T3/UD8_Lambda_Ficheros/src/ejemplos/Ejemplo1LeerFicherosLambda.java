package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ejemplo1LeerFicherosLambda {

	public static void main(String[] args) {
		
		// NIO
		Path file = Paths.get("test.txt");
		try(Stream<String>lines = Files.lines(file).onClose(() -> System.out.println("Fin de lectura"))){
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// JAVAIO
		try(BufferedReader br = Files.newBufferedReader(file);
			Stream<String> lines = br.lines().onClose(() -> System.out.println("Fin de lectura de ficheiro."))){
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
