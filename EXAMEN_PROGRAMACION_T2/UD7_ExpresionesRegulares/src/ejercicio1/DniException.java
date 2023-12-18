package ejercicio1;

public class DniException extends Exception{
	
	private String mensaje;
	
	public DniException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}

}
