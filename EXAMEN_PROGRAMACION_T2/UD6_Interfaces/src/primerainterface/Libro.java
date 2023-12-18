package primerainterface;

public class Libro implements Producto{
	 private final double precio;
	 private final String titulo;
	 private final int numpag;

	 public Libro(String titulo, double precio, int numpag) {
	    this.titulo = titulo;
	    this.precio = precio;
	    this.numpag = numpag;
	 }

	 @Override
	 public double getPrecio() { 
		 return this.precio; 
	 }
	 
	 @Override
	 public String getNombre() { 
		 return this.titulo; 
	 }
	 
	 public int getNumpag() { 
		 return this.numpag; 
	 }

}
