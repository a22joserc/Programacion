package tareaopcionalrepasoV3;

import java.util.Objects;

public class Vehiculo {
	
	private String matricula;
	private String color;
	private tipoVehiculo tipo;
	private boolean inParking;
	
	
	public Vehiculo(String matricula, String color, tipoVehiculo tipo) {
		this.matricula = matricula;
		this.color = color;
		this.tipo = tipo;
		this.inParking = false;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public tipoVehiculo getTipo() {
		return tipo;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setInParking(boolean inParking) {
		this.inParking = inParking;
	}
	
	public boolean getInParking() {
		return inParking;
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
		Vehiculo otro = (Vehiculo) obj;
		if (this.getMatricula().equals(otro.getMatricula())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getMatricula());
	}
	
	@Override
	public String toString() {
		return "Tipo: " + this.getTipo() + " - Matricula: " + this.getMatricula() + " - Color: " + this.getColor();
	}
	
	

}
