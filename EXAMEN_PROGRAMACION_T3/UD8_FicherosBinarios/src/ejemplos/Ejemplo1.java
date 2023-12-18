package ejemplos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo1 {
	
	public static void main(String[] args) {
		//Obtéñese o directorio home do sistema onde almacenarase o ficheiro
        String directory = System.getProperty("user.home");
        System.out.println(directory);
        String fileName = "sample.txt";
        String absolutePath = directory + File.separator + fileName;
         // escritura do ficheiro
        try(FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
         String fileContent = "This is a sample text.";
            //almacenamento de bytes
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro non encontrado");
        } catch (IOException e) {
            System.err.println("Error na E/S");
        }
        // lendo o ficheiro
        try(FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
            int ch = fileInputStream.read();
            //ata a fin do stream
            while(ch != -1) {
                System.out.print((char)ch);
                ch = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro non encontrado");
        } catch (IOException e) {
            System.err.println("Error na E/S");
        } 
    }
	
}
