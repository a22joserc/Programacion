package ejercicio1juan;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Ejercicio1 {
   public static void main(String[] args) {
        String nomFicheiro = "f_texto.txt";
        File f = new File(nomFicheiro);
        if (!f.exists()) {
            System.out.println("Ficheiro " + nomFicheiro + " non existe.");
            return;
        }
  
        try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
            File fTemp = File.createTempFile(nomFicheiro, "");
            System.out.println("Creado fich. temporal " + fTemp.getAbsolutePath());
            
            try (BufferedWriter bfw = new BufferedWriter(new FileWriter(fTemp))) {
                String linea = bfr.readLine();
               
                while (linea != null) {   // En resumen, lee de bfr, escribe no bfw
                    boolean principioLinea = true, espazos = false, primerAlfab = false;
                    for (int i = 0; i < linea.length(); i++) {
                        char c = linea.charAt(i);
                        if (Character.isWhitespace(c)) {
                            if (!espazos && !principioLinea) {
                                bfw.write(c);
                            }
                            espazos = true;
                        } else if (Character.isAlphabetic(c)) {
                            if (!primerAlfab) {
                                bfw.write(Character.toUpperCase(c));
                                primerAlfab = true;
                            } else {
                                bfw.write(c);
                            }
                            espazos = false;
                            principioLinea = false;
                        }
                    }
                    bfw.newLine();
                    linea = bfr.readLine();
                }
            }
           
            String nomFichBackup = nomFicheiro
                    + "." + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".bak";
            if (f.renameTo(new File(nomFichBackup))) {  // Copia de seguridad
                System.out.printf("Fichero %s renombrado como %s", nomFicheiro, nomFichBackup);
                if (fTemp.renameTo(new File(nomFicheiro))) {  // Temporal sustitue a orixinal
                    System.out.println("Fich. temporal renomeado coma " + nomFicheiro);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }}
}