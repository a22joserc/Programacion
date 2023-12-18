package primerainterface;

public class Pelicula implements Producto {
	
	private final double precio;
	private final String titulo;
	private final int durac;
	 
	public Pelicula(String titulo, double precio, int durac) {
		this.titulo = titulo;
	    this.precio = precio;
	    this.durac = durac;
	}

	 @Override
	 public double getPrecio() { 
		 return this.precio; 
	}
	 
	 @Override
	 public String getNombre() { 
		 return this.titulo; 
	 }
	 
	 public int getDuracion() { 
		 return this.durac; 
	 }

}
