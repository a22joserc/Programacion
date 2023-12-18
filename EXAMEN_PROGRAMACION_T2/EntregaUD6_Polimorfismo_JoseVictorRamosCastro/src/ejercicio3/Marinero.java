package ejercicio3;

public class Marinero extends Tripulante{
	
	// Variables de clase
	private int pesoPescado;
	private final static int SUELDO = 90000;
	private float sueldoTotal;
	private float bono;
	
	// Constructor
	public Marinero(int numCarnet, int edad, int tiempoEmpresa, String nombre, String telefono, char sexo, Barco barco, Gps posicion, int horasExperiencia, int pesoPescado) {
		super(numCarnet, edad, tiempoEmpresa, nombre, telefono, sexo, barco, posicion);
		this.pesoPescado = pesoPescado;
		// this.sueldo();
	}
	
	private void setBono() {
		if (this.pesoPescado > 1) {
			this.bono = 0.25f * this.pesoPescado;
		}
		else {
			this.bono = 0;
		}
	}
	
	// GETTERS
	
	public int getPesoPescado() {
		return pesoPescado;
	}
	
	public float getSueldoTotal() {
		return sueldoTotal;
	}
	
	public float getBono() {
		return bono;
	}
	
	// Método Específico de la clase Marinero
	
	public String saludomarinero() {
		return "A su disposición el Marinero " + this.getNombre() + "!";
	}
	
	
	@Override
	public void sueldo() {
		this.setBono();
		this.sueldoTotal = SUELDO + this.bono;
	}
	
	
	@Override
	public void mostrarInfo() {
		System.out.println("******* INFO MARINERO *******");
		System.out.println(super.toString());
		System.out.println("Peso Pescado: " + this.getPesoPescado());
		System.out.println("Bono: " + this.getBono() + "€");
		System.out.println("Sueldo total: " + this.getSueldoTotal() + "€");
		System.out.println("****************************");
		
	}
}

