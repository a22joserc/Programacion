package ficherostexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class EscribirFicheroPrintWriter {

	public static void main(String[] args) {
		
		String path = "PruebasFicheros//PruebaEscrituraPrintWriter.txt";
		File file = new File(path);
		file.delete();
		escribirFicheroPrintWriterV1(file);
		file.delete();
		escribirFicheroPrintWriterV2(file);
		file = new File("PruebasFicheros//PruebaEscrituraPrintWriterObjeto.txt");
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		asignaturas.add(new Asignatura("A-001", "Programación", 9));
		asignaturas.add(new Asignatura("A-002", "Sistemas Informáticos", 7));
		asignaturas.add(new Asignatura("A-003", "Lenguajes de Marcas", 5));
		asignaturas.add(new Asignatura("A-004", "Bases de Datos", 7));
		Iterator<Asignatura> iterator = asignaturas.iterator();
		file.delete();
		escribirFicheroPrintWriterV3(file, asignaturas);
	
	}
	
	
	private static void escribirFicheroPrintWriterV1(File file) {

		try {
			PrintWriter printWriter = new PrintWriter(file);
			for (int i = 0; i < 5; i++) {
				printWriter.println("Esta es la línea " + (i+1));
			}
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirFicheroPrintWriterV2(File file) {
		
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(file);
			for (int i = 0; i < 5; i++) {
				printWriter.println("Esta es la línea " + (i+1));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	private static void escribirFicheroPrintWriterV3(File file, ArrayList<Asignatura> asignaturas) {
		
		
		try {
			PrintWriter printWriter = new PrintWriter(file);
			Iterator<Asignatura> iterator = asignaturas.iterator();
			while (iterator.hasNext()) {
				Asignatura asignatura = iterator.next();
				printWriter.println(asignatura);
			}
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
