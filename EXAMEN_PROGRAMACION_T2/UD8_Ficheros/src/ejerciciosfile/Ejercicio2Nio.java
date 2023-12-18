package ejerciciosfile;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2Nio {
	
	public static void main(String[] args) {
		String directorio = "L:\\Programacion\\Ejemplo1Java\\UD8_Ficheros";
		List<String> fileList = getFileList(directorio);
		for (String fichero: fileList) {
			System.out.println(fichero);
		}
	}

	public static List<String> getFileList(String directorio){
		List<String> fileList = new ArrayList<>();
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directorio))){
			for (Path path:directoryStream) {
				fileList.add(path.toString());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return fileList;
	}
}
