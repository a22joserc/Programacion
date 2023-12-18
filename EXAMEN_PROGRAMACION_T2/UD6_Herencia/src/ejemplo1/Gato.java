package ejemplo1;

public class Gato extends Animal {
	
	public Gato() {
		System.out.println("> Constructor de Gato");
	}
	
	public Gato(int edad, String nombre) {
		super(edad,nombre);
		System.out.println("> Constructor de Gato");
	}
		
	public String habla() {
		return "miau!!";
	}
	
	@Override
	public String toString() {
		return "Gato: " + this.getNombre() + ", Edad:" + this.getEdad();
	}
}
