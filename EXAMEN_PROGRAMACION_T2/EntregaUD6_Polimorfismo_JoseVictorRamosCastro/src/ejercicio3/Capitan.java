package ejercicio3;

public class Capitan extends Tripulante {
	
	// variables de clase
	private int horasExperiencia;
	private final static int SUELDO = 4500000;
	private float sueldoTotal;
	private float bono;
	
	// Constructor
	
	public Capitan(int numCarnet, int edad, int tiempoEmpresa, String nombre, String telefono, char sexo, Barco barco, Gps posicion, int horasExperiencia) {
		super(numCarnet, edad, tiempoEmpresa, nombre, telefono, sexo, barco, posicion);
		this.horasExperiencia = horasExperiencia;
		// this.sueldo();
	}
	
	
	// GETTERS
	
	public int getHorasExperiencia() {
		return horasExperiencia;
	}
	
	public float getBono() {
		return bono;
	}
	
	
	public float getSueldoTotal() {
		return sueldoTotal;
	}
	
	// Set Bono
	private void setBono() {
		if (this.horasExperiencia >= 300000) {
			this.bono = 0.75f * SUELDO;
		}
		else if (this.horasExperiencia >= 150000 && this.horasExperiencia < 300000) {
			this.bono = 0.40f * SUELDO;
		}
		else if (this.horasExperiencia >= 5000 && this.horasExperiencia < 15000) {
			this.bono = 0.20f * SUELDO;
		}
		else {
			this.bono = 0f * SUELDO;
		}
	}
	
	// Método Específico de la clase Capitan
	
	public String saludoCapitan() {
		return "A su disposición el Capitán " + this.getNombre() + "!";
	}
	
	
	@Override
	public void sueldo() {
		this.setBono();
		this.sueldoTotal = SUELDO +  this.bono;
	}
	
	@Override
	public void mostrarInfo() {
		System.out.println("******* INFO CAPITÁN *******");
		System.out.println(super.toString());
		System.out.println("Horas experiencia: " + this.getHorasExperiencia());
		System.out.println("Bono: " + this.getBono() + "€");
		System.out.println("Sueldo total: " + this.getSueldoTotal() + "€");
		System.out.println("****************************");
	}
}
