package ej1Ordenacion;

public class Articulo{
	
	String codArticulo;
	String descripcion;
	int cantidad;
	
	public Articulo(String codArticulo, String descripcion, int cantidad) {
		this.codArticulo = codArticulo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	
	@Override
	public String toString() {
		return "Código: " + this.codArticulo + " Descripción: " + this.descripcion + " Cantidad: " + this.cantidad;
	}


}
