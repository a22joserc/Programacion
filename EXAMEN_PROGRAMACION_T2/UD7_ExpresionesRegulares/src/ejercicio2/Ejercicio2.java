package ejercicio2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		String trozoER="(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])";
	    String ERCompleta=trozoER+"\\."+trozoER+"\\."+trozoER+"\\."+trozoER;	
	    Pattern pattern = Pattern.compile(ERCompleta);
	    Matcher matcher;
	    Scanner teclado= new Scanner(System.in);
        System.out.println("CTRL-C para fin");
	    while (true){
	    	System.out.print("IP: ");
	    	matcher=pattern.matcher(teclado.nextLine());
	    	if(matcher.matches()) {
	    		System.out.println("\tOK");
	    	}
	    	else {
	    		System.out.println("\tMAL"); 
	    	}
    	}

   /*
    * la base de la ER es (25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]), observa:
	va entre paréntesis  para que la opcionalidad de | sea dentro de lo que hay en los paréntesis
	Cada parte de una dirección IP puede tener 1, 2 o 3 dígitos:
	3 dígitos pueden ser números que:
	empiezan por 25: 251,252,253,254 o 255. Lo que se resume con 25[0-5]
	empiezan por 2 pero siendo algo menor que 250. Lo que se resume con 2[0-4][0-9]
	empiezan por 1: 1[0-9][0-9]
	2 digitos, : pero el primero de los números  no puede ser cero [1-9][0-9]
	1 digito [0-9]

	Expresiones regulares más comunes:
	
	1.- Sólo números: ^[0-9]+$
	2.- Sólo letras: ^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$
	3.- Letras con espacios: ^[ a-zA-ZñÑáéíóúÁÉÍÓÚ]+$
	4.- Validación Nombre y apellido: ^[A-ZÑa-zñáéíóúÁÉÍÓÚ'° ]+$
	5.- Validación de Precio con dos decimales: ^[0-9]+[.,]{1,1}\[0-9]{2}$
	
	
	 Comprobar si el String cadena contiene exactamente el patrón (matches) “abc”
     Pattern pat = Pattern.compile("abc");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
	
	
	Comprobar si el String cadena contiene “abc”
     Pattern pat = Pattern.compile(".*abc.*");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
     
     
     También lo podemos escribir usando el método find:
     Pattern pat = Pattern.compile("abc");
     Matcher mat = pat.matcher(cadena);
     if (mat.find()) {
         System.out.println("Válido");                                                                            
     } else {
         System.out.println("No Válido");                                                                         
     }
     
      Comprobar si el String cadena empieza por “abc”
     Pattern pat = Pattern.compile("^abc.*");
     Matcher mat = pat.matcher(cadena);
     if (mat.matches()) {
         System.out.println("Válido");                                                                            
     } else {
         System.out.println("No Válido");                                                                         
     }
     
     Comprobar si el String cadena empieza por “abc” ó “Abc”
    
     Pattern pat = Pattern.compile("^[aA]bc.*");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
     
      Comprobar si el String cadena está formado por un mínimo de 5 letras mayúsculas o minúsculas y un máximo de 10.
     Pattern pat = Pattern.compile("[a-zA-Z]{5,10}");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
	
	Comprobar si el String cadena no empieza por un dígito
    
     Pattern pat = Pattern.compile("^[^\\d].*");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
	
	
	Comprobar si el String cadena no acaba con un dígito
     Pattern pat = Pattern.compile(".*[^\\d]$");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
     
     Comprobar si el String cadena solo contienen los caracteres a ó b
     Pattern pat = Pattern.compile("(a|b)+");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
     
      Comprobar si el String cadena contiene un 1 y ese 1 no está seguido por un 2
     Pattern pat = Pattern.compile(".*1(?!2).*");
     Matcher mat = pat.matcher(cadena);                                                                           
     if (mat.matches()) {
         System.out.println("SI");
     } else {
         System.out.println("NO");                                                                                
     }
     
      expresión regular para comprobar si un email es válido
     
     Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
       Matcher mat = pat.matcher(email);
       if(mat.find()){
          System.out.println("Correo Válido");
       }else{
          System.out.println("Correo No Válido");
     }
     
     Fechas:
     
     String text = "2014-02-02";
  	 Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
     Matcher matcher = pattern.matcher(text);
     
     // Split
     
     String str = "blanco-rojo:amarillo.verde_azul";
     String [] cadenas = str.split("[-:._]");                                                                     
     for(int i = 0; i<cadenas.length; i++){
         System.out.println(cadenas[i]);                                                                          
     }
     
     salida: blanco, rojo, amarillo, verde, azul
     
     
     Telefonos internacionales
     \(\+[0-9]{3}\)[0- 9]{9} ej: (+034)926534675
     
     Teléfonos normales:
     [0-9]{3}-[0-9]{6} ej: 981-539770
	
    * 
    */
		
	}
}
