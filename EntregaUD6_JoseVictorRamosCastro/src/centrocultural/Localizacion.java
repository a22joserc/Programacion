package centrocultural;

public class Localizacion {
	
	// Variables clase 
	private String estanteria;
	private String altura;
	
	// Constructor por defecto
	
	public Localizacion() {
		this.setAltura("0");
		this.setEstanteria("0");
	}
	
	// Constructor por paso de parámetros
	
	public Localizacion(String estanteria, String altura) {
		this.setAltura(altura);
		this.setEstanteria(estanteria);
		
	}
	
	// SETTERS
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}
	
	//GETTERS
	public String getAltura() {
		return this.altura;
	}
	
	public String getEstanteria() {
		return this.estanteria;
	}
	

}
