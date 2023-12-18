package centrocultural;

public class Cliente {
	
	// Variables de clase
	private String nombre;
	private String dni;
	private Prestamo[] prestamos;
	private int numLibroPrestamo;
	private int numDiscoPrestamo;
	
	// Constructor paso parámetros
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.prestamos = new Prestamo[CentroCultural.NUM_MAX_PRESTAMOS_CLIENTE];
		this.numLibroPrestamo = 0;
		this.numDiscoPrestamo = 0;
	}
	
	
	// SETTERS
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrestamos(Prestamo[] prestamos) {
		this.prestamos = prestamos;
	}
	
	// GETTERS
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Prestamo[] getPrestamos() {
		return this.prestamos;
	}
	
	public int getNumDiscoPrestamo() {
		return this.numDiscoPrestamo;
	}
	
	public int getNumLibroPrestamo() {
		return this.numLibroPrestamo;
	}
		
	// Añadir prestamo por posicion
	
	public void anadirPrestamo(Prestamo prestamo, int pos) {
		
		// Comprobamos si el prestámo es de un libro o un disco
		
		if (prestamo.getMaterial() instanceof Disco) {
			
			if (this.numDiscoPrestamo == CentroCultural.NUM_MAX_PRESTAMOS_DISCO_CLIENTE) {
				System.out.println("ERROR: El numero de préstamos de discos no puede exceder de 3!");
			} 
			else {
				this.prestamos[pos]=prestamo;
				this.numDiscoPrestamo++;
				System.out.println("Préstamo del DISCO - ID: " + prestamo.getMaterial().getCodigoID() + " añadido correctamente!");
			}
		}
			
		else if (prestamo.getMaterial() instanceof Libro) {
			if (this.numLibroPrestamo == CentroCultural.NUM_MAX_PRESTAMOS_LIBRO_CLIENTE) {
				System.out.println("ERROR: El numero de préstamos de libros no puede exceder de 3!");
			}
			else {
				this.prestamos[pos]=prestamo;
				this.numLibroPrestamo++;
				System.out.println("Préstamo del LIBRO - ID: " + prestamo.getMaterial().getCodigoID() + " añadido correctamente!");
			}
		}
		else {
			System.out.println("ERROR: Sólo puede realizar un préstamo de Libros o Discos!");
		}
	}
	
	
	// Mostrar info prestamos cliente
	
	public void mostrarInfoPrestamo() {
		System.out.println("************ INFO PRÉSTAMO CLIENTE DNI: " + this.getDni() + " ************");
		for (int i=0; i<this.prestamos.length; i++) {
			if (this.prestamos[i] != null) {
				System.out.println("PRÉSTAMO " + (i+1) + ": " + this.prestamos[i].toString());
			}
			else {
				System.out.println("PRÉSTAMO " + (i+1) + ": " + this.prestamos[i]);
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + ", DNI: " + this.getDni() + ", Núm Préstamos Libros: " + this.getNumLibroPrestamo() + ", Núm Préstamos Discos: " + this.getNumDiscoPrestamo();
	}
}
