package ejemplo1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.NoSuchElementException;
import java.util.Scanner;
//Clase para serializar e gardar obxectos da clase Account
public class CreateSequentialFile {
	
   private static ObjectOutputStream output; // obxecto con fluxo de saída   
   
   public static void main(String[] args) {
      openFile();
      addRecords();
      closeFile();
   }
   
   //método de abrir ficheiro
   public static void openFile() {
      try {
         output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")));
        // output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")), StandardOpenOption.APPEND);
      }
      catch (IOException ioException)
      {
         System.err.println("Error na apertura de ficheiro. Pechando.");
         System.exit(1); 
      } 
   } 
   // método de agregar obxectos
   public static void addRecords()
   {
      
      boolean fin= false; 
      Scanner input = new Scanner(System.in);   
      System.out.println("Introduza o número de conta, primer nome, apelido e balance.");
      while (!fin) 
      {
         try 
         {                        
            // crease un novo obxecto; asúmese datos correctos
            Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
            // serializa e garda o obxecto no ficheiro
            output.writeObject(record); 
            System.out.println("Desexa continuar? S|N");
            String sair= input.next();
            if (sair.equalsIgnoreCase("N")) fin = true;   
         } 
         catch (NoSuchElementException elementException) {
            System.err.println("Datos incorrectos.");
            input.nextLine(); // descartamos datos de entrada 
         } 
         catch (IOException ioException) {
            System.err.println("Error na escritura. Pechando.");
            break;
         } 
      }
   } 
   
   //método de pechar ficheiro
   public static void closeFile() {
      try 
      {
         if (output != null)
            output.close();
      } 
      catch (IOException ioException)
      {
         System.err.println("Erro pechando ficheiro. Pechando.");
      } 
   } 
} 