package gestionpodcast;

import java.util.ArrayList;


public class Podcast {
	
	private int idPodcast;
	private String titulo;
	private tipoPodcast tipo;
	private String calidad;
	private int duracion;
	private String pericidad;
	private String formatoVideo;
	private Autor autor;
	private ArrayList<Genero> generos;
	
	
	public int getIdPodcast() {
		return idPodcast;
	}
	
	public void setIdPodcast(int idPodcast) {
		this.idPodcast = idPodcast;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public tipoPodcast getTipo() {
		return tipo;
	}
	
	public void setTipo(tipoPodcast tipo) {
		this.tipo = tipo;
	}
	
	public void setTipo(byte tipo) {
		if (tipo == 0) {
			this.tipo = tipoPodcast.Audio;
		}
		else {
			this.tipo = tipoPodcast.Video;
		}
	}
	
	public String getCalidad() {
		return calidad;
	}
	
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String getPericidad() {
		return pericidad;
	}
	
	public void setPericidad(String pericidad) {
		this.pericidad = pericidad;
	}
	
	public String getFormatoVideo() {
		return formatoVideo;
	}
	
	public void setFormatoVideo(String formatoVideo) {
		this.formatoVideo = formatoVideo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	
	@Override
	public String toString() {
		String string = "Podcast -> IDPodcast: " + this.getIdPodcast() + 
						" - Título: " + this.getTitulo() +
						" - Tipo: " + this.getTipo() +
						" - Calidad: " + this.getCalidad() +
						" - Duración: " + this.getDuracion() +
						" - Periocidad: " + this.getPericidad() +
						" - Formato vídeo: " + this.getFormatoVideo() +
						".\nAutor -> " + this.getAutor().toString() + "\nGeneros: ";
		
		for (Genero genero:this.getGeneros()) {
			string = string.concat(genero.toString() + ", ");
			
		}
		return string;
	}
	
	

}
