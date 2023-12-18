package pruebaPOO;

public class Concesionario {
	// Instancias o variables de clase
	private Persona manager;
	private Coche[] flotaCoches;
	// Constructor por defecto
	public Concesionario() {
		this.manager = null;
		this.flotaCoches = new Coche[5];
	}
	// Constructor paso parámetros
	public Concesionario(Persona manager) {
		this.manager = manager;
	}
	// SETTERS
	public void setFlotaCoches(Coche[] flotaCoches) {
		this.flotaCoches = flotaCoches;
	}
	public void setManager(Persona manager) {
		this.manager = manager;
	}
	// GETTERS
	public Coche[] getFlotaCoches() {
		return flotaCoches;
	}
	public Persona getManager() {
		return manager;
	}
	// Crear flota Coches
	public void crearFlotaCoches(int numCoches) {
		this.flotaCoches = new Coche[numCoches];
	}
	// Agregar Coche Flota Posicion
	public void agregarCoche(Coche coche, int pos) {
		this.flotaCoches[pos]=coche;
	}
	// Eliminar Coche Flota Matrícula
	public void eleminarCoche(String matricula) {
		for(int i=0; i< this.flotaCoches.length; i++) {
			if(this.flotaCoches[i] != null && this.flotaCoches[i].getMatricula().equals(matricula)) {
				this.flotaCoches[i] = null;
			}
		}
	}
	// Contar Tipo Coches en la Flota
	public int[] contarTipoCoche() {
		int[] contTipoCoche = new int[tipoCoche.values().length];
		for (int i=0; i<tipoCoche.values().length; i++) {
			for (int j=0; j<this.flotaCoches.length; j++) {
				if (this.flotaCoches[j]!=null && this.flotaCoches[j].getTipo() == tipoCoche.values()[i]) {
					contTipoCoche[i] += 1;
				}
			}
		}
		return contTipoCoche;
	}

}
