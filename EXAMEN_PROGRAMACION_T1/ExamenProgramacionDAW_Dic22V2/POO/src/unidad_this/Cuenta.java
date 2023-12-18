package unidad_this;

public class Cuenta {
	private String numeroCuenta;
	private String nombre;
	private double saldo;
	
	// CONSTRUCTORES
	
	Cuenta(){
		numeroCuenta = "0000000000";
		nombre = "Nombre Persona";
		saldo = 0;
	}
	
	Cuenta(String numeroCuenta, String nombre, double saldo){
		this.numeroCuenta=numeroCuenta;
		this.nombre=nombre;
		this.saldo=saldo;
	}
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumeroCuenta(String numeroCuenta) {
		 this.numeroCuenta = numeroCuenta;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	// Metodo devuelve objeto cuenta con mayor saldo
	public Cuenta comparaCuenta(Cuenta cuenta) {
		return (this.getSaldo()>cuenta.getSaldo()?this:cuenta);
		
	}
}
