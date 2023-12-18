package ejemploexepcionespropias;

public class EjemploExcepcionesPropias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        validaEdad(15);
	    }
	    catch(Exception e) {
	        System.out.println("Excepción recibida --> " + e.getMessage());
	    }
	}
	
	
	public static void validaEdad(int edad) throws DatoNoValidoException {
	    if(edad < 18) {
	        throw new DatoNoValidoException(Integer.toString(edad), 101, "Menor de edad");
	    }
	}

}
