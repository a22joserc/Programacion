package ejercicio3;

public class JefeFlota extends Tripulante {
	
	// Variables de clase
	private int pesoPescado;
	private int pesoMarisco;
	private final static int SUELDO = 350000000;
	private float sueldoTotal;
	private float bonoPescado;
	private float bonoMarisco;
	
	//
	public JefeFlota(int numCarnet, int edad, int tiempoEmpresa, String nombre, String telefono, char sexo, Barco barco, Gps posicion, int horasExperiencia, int pesoPescado, int pesoMarisco) {
		super(numCarnet, edad, tiempoEmpresa, nombre, telefono, sexo, barco, posicion);
		this.pesoPescado = pesoPescado;
		this.pesoMarisco = pesoMarisco;
		// this.sueldo();
	}
	
	private void setBonoMarisco() {
		this.bonoMarisco = 2 * this.pesoMarisco;
	}
	
	private void setBonoPescado() {
		this.bonoPescado = this.pesoPescado;
	}
	
	// GETTERS
	
	public int getPesoMarisco() {
		return pesoMarisco;
	}
	
	
	public int getPesoPescado() {
		return pesoPescado;
	}
	
	public float getBonoMarisco() {
		return bonoMarisco;
	}
	
	public float getBonoPescado() {
		return bonoPescado;
	}
	
	public float getSueldoTotal() {
		return sueldoTotal;
	}
	
	// Método Específico de la clase Jefe de Flota
	
	public String saludoJefeFlota() {
		return "A su disposición el Jefe de Flota " + this.getNombre() + "!";
	}
	
	
	@Override
	public void sueldo() {
		this.setBonoPescado();
		this.setBonoMarisco();
		this.sueldoTotal = SUELDO + this.bonoMarisco + this.bonoPescado;	
	}
	
	@Override
	public void mostrarInfo() {
		System.out.println("******* INFO JEFE FLOTA *******");
		System.out.println(super.toString());
		System.out.println("Peso Pescado: " + this.getPesoPescado() + "(Bono Marisco = " + this.getBonoPescado() + " €)");
		System.out.println("Peso Marisco: " + this.getPesoMarisco() + "(Bono Marisco = " + this.getBonoMarisco() + " €)");
		System.out.println("Bono: " + (this.getBonoPescado() + this.getBonoMarisco()) + "€");
		System.out.println("Sueldo total: " + this.getSueldoTotal() + "€");
		System.out.println("****************************");
	}
}
