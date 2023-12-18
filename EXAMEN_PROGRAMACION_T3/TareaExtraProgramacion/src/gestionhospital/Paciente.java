package gestionhospital;

import java.sql.Connection;
import java.util.Objects;

public abstract class Paciente {
	
	// Atributos de Clase
	protected String dni;
	protected String nombre;
	protected tipoSexo sexo;
	protected gradoEnfermedad impEnfermedad;
	public final static String COD_HOSPITAL = "HSant01";
	
	// Constructor
	
	public Paciente() {}
	
	public Paciente(String dni, String nombre, tipoSexo sexo, gradoEnfermedad impEnfermedad) {
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.impEnfermedad = impEnfermedad;
	}

	// Método abstracto gurdar base datos
	public abstract void guardarBaseDatos(Connection connection, String dniMedico);
	

	// Método equals -> Criterio de comparacion Dni
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Paciente)) {
			return false;
		}
		Paciente other = (Paciente) obj;
		if (this.getDni().equals(other.getDni())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getDni());
	}
	
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", impEnfermedad=" + impEnfermedad + "]";
	}

	
	// Getters and setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public tipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(tipoSexo sexo) {
		this.sexo = sexo;
	}

	public gradoEnfermedad getImpEnfermedad() {
		return impEnfermedad;
	}

	public void setImpEnfermedad(gradoEnfermedad impEnfermedad) {
		this.impEnfermedad = impEnfermedad;
	}
	
	
	
	
	
	
	
}


