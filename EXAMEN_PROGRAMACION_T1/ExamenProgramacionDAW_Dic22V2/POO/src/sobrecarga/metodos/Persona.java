package sobrecarga.metodos;

public class Persona {
	private int edad;
	private String nombre;
	
	Persona(){
		edad = 0;
		nombre = "";
	}
	
	Persona(int edad){
		this.edad = edad;
	}
	
	Persona(String nombre){
		this.nombre = nombre;
	}
	
	Persona(int edad, String nombre){
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
		
	public boolean mayorEdad() {
		return (edad<18?false:true);
	}
	
	public Persona revelaMasViejo(Persona persona) {
		return (this.getEdad()>persona.getEdad()?this:persona);
	}
}
