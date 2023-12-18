package ejemplo1;

public class Animal {
	private int edad;
	private String nombre;
	
	public Animal() {
		this.nombre = "Sin nombre";
		this.edad = 0;
		//this("Sin nombre",0);
		System.out.println("> Constructor de Animal");
	}
	
	public Animal(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
		System.out.println("> Constructor de Animal");
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Animal: " + this.getNombre() + ", Edad:" + this.getEdad();
	}
	

}
