package centroacademicoexceptions;

public class AsignaturaCreditosException extends Exception{
	
	@Override
	public String getMessage() {
		return "ERROR: La asinatura tiene que tener más de 0 créditos!" ;
	}

}
