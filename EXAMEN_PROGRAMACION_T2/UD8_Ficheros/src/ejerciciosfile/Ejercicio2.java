package ejerciciosfile;

import java.io.File;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		// Libreria io
		File file2 = new File("L:\\Programacion\\Ejemplo1Java\\UD8_Ficheros");
		if (file2.isDirectory()) {
			String[] ficheros = file2.list();
			System.out.println("Contenido del directorio: " + file2.getName());
			for(String fichero:ficheros) {
				System.out.println(fichero);
			}
		}
		else {
			System.out.println("El directorio NO existe!");
		}
		
	}

}
