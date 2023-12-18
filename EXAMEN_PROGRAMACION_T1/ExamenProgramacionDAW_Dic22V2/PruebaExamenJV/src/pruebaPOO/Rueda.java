package pruebaPOO;

public class Rueda {
	// Variables de clase
	private String marca;
	private int ano;
	private double precio;
	private tipoRueda tipo;
	// Constructot por defecto
	public Rueda() {
		marca = "Marca Neumáticos";
		ano = 2022;
		precio = 100;
		tipo = tipoRueda.DD;
	}
	// Constructor por paso de parámetros
	public Rueda(String marca, int ano, double precio, tipoRueda tipo) {
		this.marca = marca;
		this.ano = ano;
		this.precio = precio;
		this.tipo = tipo;
	}
	// SETTERS
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setTipo(tipoRueda tipo) {
		this.tipo = tipo;
	}
	// GETTERS
	public String getMarca() {
		return this.marca;
	}
	public int getAno() {
		return ano;
	}
	public double getPrecio() {
		return precio;
	}
	public tipoRueda getTipo() {
		return tipo;
	}
	// toString
	@Override
	public String toString() {
		return "Marca: " + this.getMarca() + " - Año: " + this.getAno() + " - Precio: " + this.getPrecio() + " - Tipo: " + this.getTipo();
	}
	
}
