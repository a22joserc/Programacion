package utils;

public class HospitalException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String mensajeError;
	
	public HospitalException(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	
	@Override
	public String getMessage() {
		return mensajeError;
	}

}
