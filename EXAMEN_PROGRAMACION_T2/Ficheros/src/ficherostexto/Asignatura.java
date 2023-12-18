package ficherostexto;

import java.util.Objects;

public class Asignatura {
	
	private String codigo;
	private String nombre;
	private int creditos;

	
	public Asignatura(String codigo, String nombre, int creditos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;

	}
	
	// GETTERS
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if(!(obj instanceof Asignatura)){
			return false;
		}
		Asignatura asignatura = (Asignatura) obj;
		if (this.getCodigo().equals(asignatura.getCodigo())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	
	// toString
	@Override
	public String toString() {
		return this.getNombre() + " - Código: " + this.getCodigo() + " - Créditos: " + this.getCreditos();
	}

}

