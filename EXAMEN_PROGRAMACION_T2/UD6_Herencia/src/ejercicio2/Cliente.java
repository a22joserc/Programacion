package ejercicio2;

public class Cliente extends Persona {
	// Variables de clase
	private double deuda;
	
	// Constructor por paso de parámetros
	public Cliente(String nombre, String direccion, String dni, double deuda) {
		super(nombre, direccion, dni);
		this.deuda = deuda;
	}
	
	// SETTERS
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	
	// GETTERS
	public double getDeuda() {
		return deuda;
	}
	
	// toString()
	@Override
	public String toString() {
		String str = super.toString();
		str = str.replaceFirst("Persona", "Cliente");
		return str + ", Deuda: " + this.getDeuda();
	}
	
	

}
