package centrocultural;

public abstract class Material {
	
	// Variables de clase
	
	protected String infoGral;
	protected String codigoID;
	protected String titulo;
	protected Localizacion localizacion;
	protected String autor;
	protected boolean prestado;
	
	// Constructor por paso de parámetros

	public Material(String infoGral, String codigoID, String titulo, String estanteria, String altura, String autor) {
		this.infoGral = infoGral;
		this.codigoID = codigoID;
		this.titulo = titulo;
		this.localizacion = new Localizacion(estanteria, altura);
		this.autor = autor;
		this.prestado = false;
	}
	
	// SETTERS
	
	public void setInfoGral(String infoGral) {
		this.infoGral = infoGral;
	}
	
	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}
	
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	// GETTERS
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getCodigoID() {
		return this.codigoID;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public Localizacion getLocalizacion() {
		return this.localizacion;
	}
	
	public String getInfoGral() {
		return this.infoGral;
	}
	
	public boolean getPrestado() {
		return this.prestado;
	}
	
	// Método colocarMaterial
	
	public final void colocarMaterial() {
		System.out.println("El material con código " + this.getCodigoID() + " debe colocarlo en la estanteria " + this.getLocalizacion().getEstanteria() + " y altura " + this.getLocalizacion().getAltura());
	}
	
}
