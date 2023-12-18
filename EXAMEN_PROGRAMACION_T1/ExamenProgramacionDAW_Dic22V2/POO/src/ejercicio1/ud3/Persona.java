package ejercicio1.ud3;

public class Persona {
	private String nombre;
	private int edad;
	private float altura;
	
	// CONSTRUCTORES
	Persona(){
		nombre = "X";
		edad = -1;
		altura = -1;
	}
	
	Persona(String nombre){
		this.nombre = nombre;
	}
	
	Persona(int edad){
		this.edad = edad;
	}
	
	Persona(float altura){
		this.altura = altura;
	}
	
	Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}
	
	Persona(String nombre, float altura){
		this.nombre = nombre;
		this.altura = altura;
	}
	
	Persona(int edad, float altura){
		this.edad = edad;
		this.altura = altura;
	}
	
	Persona(String nombre, int edad, float altura){
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}
	// SETTERS 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public float getAltura() {
		return altura;
	}
	// MÉTODO COMPRUEBA MAYOR DE EDAD
	
	public boolean mayorEdad() {
		return (edad<18?false:true);
	}
	
	// METODO DEVULEVE OBJETO PERSONA DE MAYOR EDAD
	public Persona revelaMasViejo(Persona persona) {
		return (this.getEdad()>persona.getEdad()?this:persona);
	}
	
	// METODO DEVULEVE OBJETO PERSONA DE MAYOR ALTURA
	public Persona revelaMasAlto(Persona persona) {
		return (this.getAltura()>persona.getAltura()?this:persona);
	}
	
}
