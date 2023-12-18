package ejemplo2;

public class Estudiante extends Animal{
	
	public Estudiante() {
		System.out.println("Constructor estudiante!");
	}
	
	@Override
	public String habla() {
		return "Vamos a palmar!";
	}

}
