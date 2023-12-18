package prueba;

import java.util.Objects;

public class Asignatura {
	
	private String nombre;
	private String codigo;
	private int creditos;
	
	public Asignatura(String nombre, String codigo, int creditos) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
	}
	
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
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(codigo, other.codigo);
	}


	@Override
	public String toString() {
		return nombre + " - Código: " + codigo + " - Créditos: " + creditos;
	}

}
