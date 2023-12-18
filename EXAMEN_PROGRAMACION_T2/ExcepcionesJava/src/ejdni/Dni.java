package ejdni;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNI {
	
	
    private String dni;//8 digitos + letra
    private static final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";

    
    public DNI(String dni) throws DNIException{
	 
		//suponemos que un dni ES CORRECTO SI tiene  8 digitos + una letra. Sin guiones. 
		//comprobamos si llega String null
		if(dni==null) {
			throw new DNIException(dni,"dni nulo");
		}
		//comprobamos si la longitud del string no es exactamente 9
		Pattern pattern =Pattern.compile("([0-9]{1,8})([A-Za-z])");
	    Matcher matcher = pattern.matcher(dni);
	    if (!matcher.matches()){
	        throw new DNIException(dni,"formato incorrecto!. Recuerda que es correcto  de 1 a 8 digitos seguidos de letra");
	     }
	    //si la letra fuera minúscula la pasamos a mayúscula
	    dni=dni.toUpperCase();
		//compruebo el algortimo de la letra que detecta si hay error tanto en letra como en nÃºmero
	    //int numero=Integer.parseInt(dni.substring(0, dni.length()-1));
	    int numero=Integer.parseInt(matcher.group(1));
		//char letraStringEntrada=dni.charAt(dni.length()-1);
	    char letraStringEntrada=matcher.group(2).charAt(0);
	       
	    char letraCorrecta=DNI.calcularLetra(numero);
		if(letraStringEntrada!=letraCorrecta) {
			throw new DNIException(dni, " el dni no cumple algortimo de validación");
		}
		this.dni=dni;
    }


    public String getDNI(){
        return this.dni;
    }
    public String  getDNISoloNumero(){
        return this.dni.substring(0, this.dni.length()-1);
    }	
    public char getDNISoloLetra(){
        return this.dni.charAt(dni.length()-1);
    }


    //utilidad para calcular letra sin crear objeto . tambien usa esta utilidad el constructor
    public static char calcularLetra(int numero){
		//simplificamos y suponemos que que el valor es correcto y estÃ¡ entre 1 99999999
		return LETRAS_DNI.charAt(numero%23);
	 }
    
    public static char calcularLetra(String numeroDNI){
    	//simplificamos y suponemos que que el valor es correcto y estÃ¡ entre "00000001" y "99999999"	
        int numero=Integer.parseInt(numeroDNI.substring(0, numeroDNI.length()));
        return LETRAS_DNI.charAt(numero%23);
    }
}
