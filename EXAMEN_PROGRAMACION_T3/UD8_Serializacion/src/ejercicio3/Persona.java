package ejercicio3;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
    private transient String password;
 
    public Persona(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    
    public String getNombre() {
		return nombre;
	}
    
    public String getPassword() {
		return password;
	}
    
    @Override
    public String toString() {
    	return "Persona -> [" + this.getNombre() + " - Password: " + this.getPassword() + "]";
    }
}