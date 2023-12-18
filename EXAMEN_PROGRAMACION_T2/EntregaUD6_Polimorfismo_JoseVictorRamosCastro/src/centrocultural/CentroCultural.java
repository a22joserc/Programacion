package centrocultural;

public class CentroCultural {
	
	// Constantes
	public final static int NUM_MAX_CLIENTES = 5;
	public final static int NUM_MAX_DISCOS = 15;
	public final static int NUM_MAX_LIBROS = 15;
	public final static int NUM_MAX_PRESTAMOS_CLIENTE = 6;
	public final static int NUM_MAX_PRESTAMOS_LIBRO_CLIENTE = 3;
	public final static int NUM_MAX_PRESTAMOS_DISCO_CLIENTE = 3;
	// Variables de clase
	private Material[] catalogoMateriales;
	private Cliente[] clientes;
	
	// Constructor
	public CentroCultural() {
		this.clientes = new Cliente[NUM_MAX_CLIENTES];
		this.catalogoMateriales = new Material[NUM_MAX_LIBROS+NUM_MAX_DISCOS];
		this.generarClientes();
		this.generarMateriales();

	}
	
	// GETTERS
	
	public Material[] getCatalogoMateriales() {
		return this.catalogoMateriales;
	}
	
	public Cliente[] getClientes() {
		return this.clientes;
	}
	

	// ----------------------------------- GENERAMOS CLIENTES CENTRO CULTURAL --------------------------------------------------------------// 
	
	public void generarClientes() {
		String[] arrayNombres = {"Yago Gómez","Carmen Martínez","David Márquez","Juan Fernández","Iria López"};
		String[] arrayDni = {"59176260C","35719842Z","13410599N","48664703S","92255053Y"};
		for (int i=0; i<this.clientes.length; i++) {
			this.clientes[i] = new Cliente(arrayNombres[i], arrayDni[i]);
		}
	}
	
	// ----------------------------------- GENERAMOS MATERIALES CENTRO CULTURAL --------------------------------------------------------------// 
	
	public void generarMateriales() {
		// Generamos Libros
		for (int i=0; i<NUM_MAX_LIBROS; i++) {
			this.catalogoMateriales[i] = new Libro(200+i,"Información General del Libro " + (i+1),"LBR-" + (i+1), "Título del Libro " + (i+1), "Estanteria " + (i+1), "Altura " + (i+1),"nombreAutor del Libro " + (i+1));
		}
		// Generamos Discos
		for (int i=NUM_MAX_LIBROS, j=0; i<this.catalogoMateriales.length; i++, j++) {
			this.catalogoMateriales[i] = new Disco("Sony","Información General del Disco " + (j+1),"DSC-" + (j+1), "Título del Disco " + (j+1), "Estanteria " + (j+1), "Altura " + (j+1),"nombreAutor del Disco " + (j+1));
		}
	}
	

	// ------------------------------------ OBTENER CLIENTE POR DNI ---------------------------------------------------------------------//
	
	public Cliente getClienteDni(String dni) {
		for (int i=0; i< this.clientes.length; i++) {
			if (this.clientes[i] != null && this.clientes[i].getDni().equals(dni)) {
				return this.clientes[i];
			}			
		}
		System.out.println("ERROR: El cliente con DNI: " + dni + " no se encuentra registrado en el sistema!");
		return null;
	}
	
	// ------------------------------------ OBTENER MATERIAL POR ID ---------------------------------------------------------------------//
	
		public Material getMaterialId(String idMaterial) {
			for (int i=0; i< this.catalogoMateriales.length; i++) {
				if (this.catalogoMateriales[i] != null && this.catalogoMateriales[i].getCodigoID().equals(idMaterial)) {
					return this.catalogoMateriales[i] ;
				}			
			}
			System.out.println("ERROR: El material con ID: " + idMaterial + " no se encuentra registrado en el sistema!");
			return null;
		}
	
	
	// --------------------------------- MOSTRAR INFO PRESTAMOS CLIENTE POR DNI -------------------------------------------------------//

	public void mostrarPrestamoCliente(String dni) {
		boolean flag = false;
		for (int i=0; i< this.clientes.length; i++) {
			if (this.clientes[i] != null && this.clientes[i].getDni().equals(dni)) {
				this.clientes[i].mostrarInfoPrestamo();
				flag = true;
				break;
			}			
		}
		if (flag == false) {
			System.out.println("ERROR: El cliente con DNI: " + dni + " no se encuentra registrado en el sistema!");
		}
	}
	
	// -------------------------------------- MOSTRAR INFO CLIENTES ---------------------------------------------------------------------//
	
	public void monstrarInfoClientes() {
		System.out.println("CLIENTES: ");
		for (int i=0; i< this.clientes.length; i++) {
			if (this.clientes[i] == null) {
				System.out.println("Cliente_" + (i+1) + ": " + this.clientes[i]);
			}
			else {
				System.out.println("Cliente_" + (i+1) + " - Nombre: " + this.clientes[i].getNombre() + ", DNI: " + this.clientes[i].getDni() + ", Núm Prestamos: " + (this.clientes[i].getNumDiscoPrestamo() + this.clientes[i].getNumLibroPrestamo()));
			}
		}
		
	}
	
	// -------------------------------------- MOSTRAR INFO MATERIALES ---------------------------------------------------------------------//
	
	public void mostrarInfoMateriales() {
		System.out.println("COLECCIÓN ARTÍCULOS: ");
		for (int i=0; i< this.catalogoMateriales.length; i++) {
			if (this.catalogoMateriales[i] == null) {
				System.out.println("Material_" + (i+1) + ": " + this.catalogoMateriales[i]);
			}
			else if (this.catalogoMateriales[i] instanceof Libro){
				System.out.println("Libro_" + (i+1) + " - " + this.catalogoMateriales[i].toString());
			}
			else {
				System.out.println("Disco_" + (i+1) + " - " + this.catalogoMateriales[i].toString());
			}
		}
	}
	
	
	// -------------------------------------- MOSTRAR INFO CENTRO CULTURAL -----------------------------------------------------------//
	
	public void mostrarInfoGeneral() {		
		System.out.println("********* INFORMACIÓN CENTRO CULTURAL **********");
		this.monstrarInfoClientes();
		this.mostrarInfoMateriales();
	}
	
	
}
