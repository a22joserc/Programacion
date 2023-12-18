package ej4_libro;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private int numPag;
	
	//CONSTRUTOR POR DEFECTO
	public Libro(){
		isbn = "000-0-00-000000-0";
		titulo = "Título del libro";
		autor = "Nombre Apellidos";
		numPag = 0;
	}
	
	// CONSTRUCTOR CON PASO DE PARÁMETROS
	public Libro(String isbn, String titulo, String autor, int numPag) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		if (numPag < 0) {
			this.numPag = 0;
		}
		else {
			this.numPag = numPag;
		}
	}
	
	// GETTERS
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getNumPag() {
		return numPag;
	}
	
	// SETTERS
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	// MÉTODO PARA COMPARAR LIBROS: Devuelve instancia de clase libro con más pág.
	public Libro comparaPaginas(Libro libro) {
		return (this.getNumPag() > libro.getNumPag()?this:libro);
	}
	
	// MÉTODO toSring
	@Override
	public String toString() {
		return "***************************\nTitulo : " + this.getTitulo() + ";\nAutor: " + this.getAutor() + ";\nISBN: " + this.getIsbn() + ";\nNúm pag: " + this.getNumPag() + "\n***************************";
	}
}
