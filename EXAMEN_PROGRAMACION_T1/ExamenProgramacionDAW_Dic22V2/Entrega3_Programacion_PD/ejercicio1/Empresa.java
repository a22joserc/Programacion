package ejercicio1;

public class Empresa {
	// Variables de Clase
	private String cif;
	private String nombre;
	private String direccion;
	private int numEmpleados;
	
	// Constructor por defecto
	public Empresa() {
		cif = "CIF-XXXXXX";
		nombre = "Empresa XX";
		direccion = "Direccion Empresa XX";
		numEmpleados = 0;
	}
	
	// Constructor con paso de parámetros
	public Empresa(String cif, String nombre, String direccion, int numEmpleados) {
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numEmpleados = numEmpleados;
	}
	
	// SETTERS
	
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}
	
	// GETTERS
	
	public String getCif() {
		return cif;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumEmpleados() {
		return numEmpleados;
	}

	// MÉTODO toString
	
	@Override
	public String toString() {
		return "***************************\nCIF : " + this.getCif() + ";\nNombre: " + this.getNombre() + ";\nDirección: " + this.getDireccion() + ";\nNúm Empleados: " + this.getNumEmpleados() + "\n***************************";
	}
}
