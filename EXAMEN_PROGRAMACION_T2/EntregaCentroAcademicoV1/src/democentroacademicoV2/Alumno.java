package democentroacademicoV2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Alumno {
	
	private String numExpediente;
	private String nombre;
	private HashSet<Asignatura> asignaturasMatriculadas;
	private double notaMedia;
	
	public Alumno(String numExpediente, String nombre) {
		this.numExpediente = numExpediente;
		this.nombre = nombre;
		this.asignaturasMatriculadas = new HashSet<>();
		this.notaMedia = 0.0;
	}
	
	// GETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumExpediente() {
		return numExpediente;
	}
	
	public HashSet<Asignatura> getAsignaturasMatriculadas() {
		return asignaturasMatriculadas;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}
	
	public void setNotaMedia() {	
		Iterator<Asignatura> iterator = this.getAsignaturasMatriculadas().iterator();
		double sum = 0.0;
		while(iterator.hasNext()) {
			Asignatura asignatura = iterator.next();
			sum += asignatura.getListadoCalificaciones().get(this.getNumExpediente());
		}
		this.notaMedia = sum / this.asignaturasMatriculadas.size();
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
