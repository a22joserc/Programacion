package ejercicio5;

public class StockException extends Exception {
	
	 private int errCode;
	 private String valor;
	 public StockException(String valor, int errCode, String msg) {
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
