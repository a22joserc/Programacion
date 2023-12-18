package ficherostexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroBufferWriter {

	public static void main(String[] args) {
		
		String path = "PruebasFicheros//PruebaEscrituraBufferWriter.txt";
		File file = new File(path);
		// escribirFicheroBufferWriter(file);
		// Elimniamos fichero;
		// file.delete();
		// escribirFicheroBufferWriterV2(file);
		file.delete();
		escribirFicheroBufferWriterV3(file);
	}
	
	private static void escribirFicheroBufferWriter(String path) {
		File file = new File(path);
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("Eres un zorro hijo de mil putas");
			bufferedWriter.newLine();
			bufferedWriter.write("Jalorchonsón come mierda");
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void escribirFicheroBufferWriter(File file) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("Eres un zorro hijo de mil putas");
			bufferedWriter.newLine();
			bufferedWriter.write("Jalorchonsón come mierda");
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void escribirFicheroBufferWriterV2(File file) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("Eres un zorro hijo de mil putas");
			bufferedWriter.newLine();
			bufferedWriter.write("Jalorchonsón come mierda");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	private static void escribirFicheroBufferWriterV3(File file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			bufferedWriter.write("Eres un zorro hijo de mil putas");
			bufferedWriter.newLine();
			bufferedWriter.write("Jalorchonsón come mierda");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
