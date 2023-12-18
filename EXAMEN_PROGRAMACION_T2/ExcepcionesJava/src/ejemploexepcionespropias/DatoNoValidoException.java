package ejemploexepcionespropias;

public class DatoNoValidoException extends Exception {
	 int errCode;
	 String valor;
	 
	 public DatoNoValidoException(String valor, int errCode, String msg) {
	    super(msg);
	    this.valor = valor;
	    this.errCode = errCode;
	 }
	 
	 public int getErrorCode() {
	    return this.errCode;
	 }
	 
	 public String toString() {
	    return "[ERR: " + this.errCode + "] " +
	    this.getMessage() + " (value: " + this.valor + ")";
	 }
	 
	}
