package pruebaPOO;

public class Persona {
	// Variables de Clase
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private double salario;
	// Constructor por defecto
	public Persona() {
		this.nombre = "Zutano";
		this.apellidos = "Gómez García";
		this.dni = "12345678H";
		this.direccion = "Direccion nº 123";
		this.salario = 30000.5;
	}
	// Constructor por paso de parametros
	public Persona(String nombre, String apellidos, String dni, String direccion, double salario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.salario = salario;
	}
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {
		return dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public double getSalario() {
		return salario;
	}
	// SETFROMCADENA cadena= "José Víctor|Ramos Castro|12345678H|Travesia 123|45825.5";
	public void setFromCadena(String cadena) {
		String[] tokens = cadena.split("\\|");
		this.setNombre(tokens[0]);
		this.setApellidos(tokens[1]);
		this.setDni(tokens[2]);
		this.setDireccion(tokens[3]);
		this.setSalario(Double.parseDouble(tokens[4]));
	}
	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + ", Apellidos: " + this.getApellidos() + ", DNI: " + this.getDni() + ", Dirección: " + this.getDireccion() + ", Salario: " + this.getSalario() + " €";
	}
	
}
