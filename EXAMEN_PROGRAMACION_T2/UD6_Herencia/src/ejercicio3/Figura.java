package ejercicio3;

public class Figura {
	// Variable de clase
	private String color;
	
	// Constructor por paso de parámetros
	public Figura(String color) {
		this.setColor(color);
	}
	
	// SETTER
	public void setColor(String color) {
		this.color = color;
	}
	
	// GETTER 
	
	public String getColor() {
		return color;
	}

}
