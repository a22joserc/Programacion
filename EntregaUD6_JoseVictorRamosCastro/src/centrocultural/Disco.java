package centrocultural;

public class Disco extends Material {
	
	//Variables de clase
	private String nombreDiscografica;
	
	// Constructor por paso de parámetros
	
	public Disco(String nombreDiscografica, String infoGral, String codigoID, String titulo, String estanteria, String altura, String autor) {
		super(infoGral, codigoID, titulo, estanteria, altura, autor);
		this.nombreDiscografica = nombreDiscografica;
	}
	
	// SETTER
	
	public void setNombreDiscografica(String nombreDiscografica) {
		this.nombreDiscografica = nombreDiscografica;
	}
	
	
	// GETTER 
	
	public String getNombreDiscografica() {
		return this.nombreDiscografica;
	}
	
	@Override
	public String toString() {
		return "TÍTULO: " + this.getTitulo() + ", ID: " + this.getCodigoID() + ", DISPONIBLE: " + !this.getPrestado();
	}
}
