package sets;

import java.util.Objects;

public class Persona {
	private String nombre;
	private int telefono;
	
	public Persona(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + " - Teléfono: " + this.getTelefono();
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
            return true;
		}
        if (!(obj instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) obj;
        /*
        if (this.nombre.equals(persona.nombre) && this.telefono == persona.telefono) {
        	return true;
        }*/
        
        
        boolean nombreEquals = (this.nombre == null && persona.nombre == null) || (this.nombre != null && this.nombre.equals(persona.nombre));
        
        return nombreEquals && this.telefono == persona.telefono;	

	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(nombre, telefono);
	}
}
