package ejemplo2;

public class Gato extends Animal {
	
	public Gato() {
		System.out.println("Constructor de Gato!");
	}
	
	@Override
	public String habla() {
		return "Miau Miau!";
	}

}
