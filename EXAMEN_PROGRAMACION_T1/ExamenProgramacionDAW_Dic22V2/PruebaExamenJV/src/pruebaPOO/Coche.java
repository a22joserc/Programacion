package pruebaPOO;

public class Coche {
	// Variables de clase
	private String matricula;
	private String marca;
	private String modelo;
	private double peso;
	private Rueda[] ruedas;
	private Coche cocheSustitucion;
	private tipoCoche tipo;
	// Constructor por defecto
	public Coche() {
		this.matricula = "0000-XXX";
		this.marca = "Marca Coche";
		this.modelo = "Modelo Coche";
		this.peso = 1500;
		this.ruedas = new Rueda[5];
		this.cocheSustitucion = null;
		this.tipo = tipoCoche.Diesel;
	}
	// Constructor por paso de parametros
	public Coche(String matricula, String marca, String modelo, double peso, Rueda[] ruedas, tipoCoche tipo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.peso = peso;
		this.ruedas = ruedas;
		this.cocheSustitucion = null;
		this.tipo = tipo;
	}
	// SETTERS
	public void setCocheSustitucion(Coche cocheSustitucion) {
		this.cocheSustitucion=cocheSustitucion;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setRuedas(Rueda[] ruedas) {
		this.ruedas = ruedas;
	}
	public void setTipo(tipoCoche tipo) {
		this.tipo = tipo;
	}
	// GETTERS 
	public Coche getCocheSustitucion() {
		return this.cocheSustitucion;
	}
	public String getMarca() {
		return marca;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public double getPeso() {
		return peso;
	}
	public Rueda[] getRuedas() {
		return ruedas;
	}
	public tipoCoche getTipo() {
		return this.tipo;
	}
	// Comparar coches por Ano
	public Coche comparaCochePeso(Coche coche) {
		return this.getPeso() > coche.getPeso() ? this:coche;
	}

	// MOSTRAR INFO
	public void mostrarInfoCoche() {
		System.out.println("******** INFO COCHE ********");
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Matrícula: " + this.getMatricula());
		System.out.println("Peso: " + this.getPeso());
		System.out.println("Tipo: " + this.getTipo());
		for (int i=0; i< tipoRueda.values().length; i++) {
			System.out.println("Rueda_" + tipoRueda.values()[i].toString() + ": " + this.ruedas[i].toString());
		}
		if (this.cocheSustitucion == null) {
			System.out.println("Coche sustitucion asignado: " + this.cocheSustitucion);	
		}
		else {
			System.out.println("Coche sustitucion asignado: " + this.cocheSustitucion.getMatricula());	
		}
	}
}
