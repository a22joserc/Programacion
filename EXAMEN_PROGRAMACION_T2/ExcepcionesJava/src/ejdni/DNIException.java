package ejdni;

public class DNIException extends Exception {

	String dni;
	String mensaje;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public DNIException(String dni, String mensaje) {
		this.dni = dni;
		this.mensaje = mensaje;
	}
	
	
}