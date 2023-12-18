package democentroacademicoV4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Alumno {
	
	private String numExpediente;
	private String nombre;
	private HashSet<Expediente> expedienteAcademico;
	private double notaMedia;
	
	public Alumno(String numExpediente, String nombre) {
		this.numExpediente = numExpediente;
		this.nombre = nombre;
		this.expedienteAcademico = new HashSet<>();
		this.notaMedia = 0.0;
	}

	// GETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumExpediente() {
		return numExpediente;
	}
	
	public HashSet<Expediente> getExpedienteAcademico() {
		return expedienteAcademico;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}
	
	public void setNotaMedia() {	
		Iterator<Expediente> iterator = this.getExpedienteAcademico().iterator();
		double sum = 0.0;
		while(iterator.hasNext()) {
			Expediente expediente = iterator.next();
			sum += expediente.getNota();
		}
		this.notaMedia = sum / this.getExpedienteAcademico().size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno alumno = (Alumno) obj;
		if (this.getNumExpediente().equals(alumno.getNumExpediente())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(numExpediente);
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + " - Número Expediente: " + this.getNumExpediente();
	}

}

