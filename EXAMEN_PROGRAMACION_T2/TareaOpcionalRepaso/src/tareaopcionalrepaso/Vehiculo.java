package tareaopcionalrepaso;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehiculo {
	
	protected String matricula;
	protected String color;
	protected boolean inParking;
	protected LocalDate horaEntrada;
	protected LocalDate horaSalida;
	protected double facturacion;
	
	public Vehiculo(String matricula, String color) {
		this.matricula = matricula;
		this.color = color;	
		this.inParking = false;
		this.facturacion = 0;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public LocalDate getHoraEntrada() {
		return horaEntrada;
	}
	
	public LocalDate getHoraSalida() {
		return horaSalida;
	}
	
	public double getFacturacion() {
		return facturacion;
	}
	
	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}
	
	public boolean getInParking() {
		return inParking;
	}
	
	public void setInParking(boolean inParking) {
		this.inParking = inParking;
	}
	
	public void setHoraEntrada(LocalDate horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public void setHoraSalida(LocalDate horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	@Override
	public String toString() {
		return "Matricula: " + this.getMatricula() + " - Color: " + this.getColor() + " - Fecha Entrada: " + this.getHoraEntrada() + " - Fecha Salida: " + this.getHoraSalida();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof Vehiculo)) {
			return false;
		}
		Vehiculo other = (Vehiculo) obj;
		if (this.getMatricula().equals(other.getMatricula())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getMatricula());
	}

}
