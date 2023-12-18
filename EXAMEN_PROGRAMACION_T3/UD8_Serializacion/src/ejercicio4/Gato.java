package ejercicio4;

public class Gato extends Animal {
	
	private static final long serialVersionUID = 3L;
	private tipoBigote bigote;

	public Gato(String nombre, int edad, tipoBigote bigote) {
		super(nombre, edad);
		this.bigote = bigote;
	}
	
	public tipoBigote getBigote() {
		return bigote;
	}
	
	@Override
	public void habla() {
		System.out.println("Miau Miau Miau!");
	}
	

	@Override
	public void getTipo() {
		System.out.println("Gato");
	}
	
	/*@Override
	public Gato getTipo() {
		return this;
	}
	*/
	
	@Override
	public String toString() {
		return super.toString().concat(" - Tipo: Gato]");
	}
}
