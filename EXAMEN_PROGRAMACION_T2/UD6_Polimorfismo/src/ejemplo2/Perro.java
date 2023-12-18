package ejemplo2;

public class Perro extends Animal {
	
	public Perro() {
		System.out.println("Constructor de Perro");
	}
	
	@Override
	public String habla() {
		return "Guau Guau!";
	}

}
