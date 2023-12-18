package streams;

public class Libro {
	
	private String titulo;
	private String genero;
	private int numPag;
	
	public Libro(String titulo, String genero, int numPag) {
		this.titulo = titulo;
		this.genero = genero;
		this.numPag = numPag;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	@Override
	public String toString() {
		return this.getTitulo() + " - " + this.getGenero() + " - " + this.getNumPag();
	}
	
	

}
