package ficherostexto;

import java.io.PrintWriter;

public class EjemploPrintWriter {

	public static void main(String[] args) {
		
		try {
            //se non existe se crea
            PrintWriter printWriter = new PrintWriter("testPrintWriter.txt");
            for (int i = 1; i < 4; i++) {
                //se sobreescribe o contido, de necesitar agregar debese usar apend
                printWriter.println("Esta e a linea numero: " + i);          
            }
            printWriter.close();
        } 
		catch (Exception e) {
            e.printStackTrace();
		}

	}

}
