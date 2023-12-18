package ejercicio5;

public class Producto {
	
	private String id;
	private double precio;
	private int stock;
	
	
	public Producto(String id, double precio, int stock) {
		this.id = id;
		this.precio = precio;
		this.stock = stock;
	}
	
	public String getId() {
		return id;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + " - Precio: " + this.getPrecio() + " € - Stock: " + this.getStock();
	}
	

}
