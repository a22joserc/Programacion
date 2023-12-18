package tareaud8;

public class NbaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	public NbaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String getMessage() {
		return this.mensaje;
	}
	
}
