package excepciones;

public class GestionCarreraException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String mensajeError;
	
	public GestionCarreraException(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	
	@Override
	public String getMessage() {
		return this.getMensajeError();
	}

}
