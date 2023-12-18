package ejercicio6;

public class OrdenadorException extends Exception {
	
	private String msg;
	private String numDeSerie;
	
	public OrdenadorException(String numSerie, String msg) {
		super(msg);
		this.numDeSerie = numSerie;
	}
	
	@Override
	public String getMessage() {
		return "Error no se puede configurar el ordenador con las características: " + msg;
	}

}
