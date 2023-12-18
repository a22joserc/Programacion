package democentroacademicoV4final;

import java.util.HashSet;
import java.util.Objects;

public class Asignatura {
	
	private String codigo;
	private String nombre;
	private int creditos;
	private HashSet<Alumno> listadoAlumnos;

	
	public Asignatura(String codigo, String nombre, int creditos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.listadoAlumnos = new HashSet<>();
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
	
	public HashSet<Alumno> getListadoAlumnos() {
		return listadoAlumnos;
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

