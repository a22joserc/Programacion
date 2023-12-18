package arraylists;

public class Libro {
	private String id;
	private String titulo;
	private String autor;
	
	public Libro(String id, String titulo, String autor) {
		this.id =id;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", AUTOR: " + this.getAutor() + ", TÍTULO: " + this.getTitulo();
	}
}
