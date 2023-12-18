package centrocultural;

public class Libro extends Material {
	
	//Variables de clase
	private int numPag;
	
	// Constructor por paso de parametros
	public Libro(int numPag, String infoGral, String codigoID, String titulo, String estanteria, String altura, String autor) {
		super(infoGral, codigoID, titulo, estanteria, altura, autor);
		this.numPag = numPag;
	}
	
	// SETTERS
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	// GETTERS
	
	public int getNumPag() {
		return this.numPag ;
	}	
	
	// toString
	
	@Override
	public String toString() {
		return "TÍTULO: " + this.getTitulo() + ", ID: " + this.getCodigoID() + ", DISPONIBLE: " + !this.getPrestado();
	}
	
	//equals
	
	@Override
	public boolean equals(Object obj) {
		Libro libro = (Libro) obj;
		if (this.getTitulo().equals(libro.getTitulo()) && this.getNumPag() == libro.getNumPag()) {
			return true;
		}
		else {
			return false;
		}
	}

}
