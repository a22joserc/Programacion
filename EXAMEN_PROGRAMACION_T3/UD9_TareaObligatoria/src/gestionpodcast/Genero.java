package gestionpodcast;

public class Genero {
	
	private int idGenero;
	private String nombre;
	
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.getIdGenero() + " - " + this.getNombre();
	}
	
	

}
