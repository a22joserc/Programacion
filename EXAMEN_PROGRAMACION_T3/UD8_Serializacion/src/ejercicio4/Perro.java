package ejercicio4;

public class Perro extends Animal {
	
	private static final long serialVersionUID = 2L;
	private tipoRabo rabo;

	public Perro(String nombre, int edad, tipoRabo rabo) {
		super(nombre, edad);
		this.rabo = rabo;
	}
	
	public tipoRabo getRabo() {
		return rabo;
	}
	
	@Override
	public void habla() {
		System.out.println("Guau Guau Guau!");
	}
	
	@Override
	public void getTipo() {
		System.out.println("Perro");
		
	}
	
	@Override
	public String toString() {
		return super.toString().concat(" - Tipo: Perro]");
	}
	

}
