package democentroacademicoV4;

import java.util.Objects;

public class Expediente {
	
	// Variables de clase
	private Asignatura asignatura;
	private double nota;
	
	// Constructor
	public Expediente(Asignatura asignatura) {
		this.asignatura = asignatura;
		this.nota = 0;
	}
	
	// Getters
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public double getNota() {
		return nota;
	}
	
	// Setters
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return asignatura.toString() + " - Nota: " + this.getNota();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Expediente)) {
			return false;
		}
		Expediente expediente = (Expediente) obj;
		if (this.getAsignatura().getCodigo().equals(expediente.getAsignatura().getCodigo())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getAsignatura().getCodigo());
	}
	
}
