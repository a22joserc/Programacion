package tareaopcionalrepasoV2;

import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Vehiculo {
	
	private String matricula;
	private String color;
	private tipoVehiculo tipo;
	private double facturacion;
	private boolean inParking;
	private HashSet<Estacionamiento> listaRegistrosParkings;
	
	
	public Vehiculo(String matricula, String color, tipoVehiculo tipo) {
		this.matricula = matricula;
		this.color = color;
		this.tipo = tipo;
		this.facturacion = 0;
		this.inParking = false;
		this.listaRegistrosParkings = new HashSet<>();
	}
	
	public HashSet<Estacionamiento> getListaRegistrosParkings() {
		return listaRegistrosParkings;
	}
	
	public double getFacturacion() {
		return facturacion;
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
	
	public void setFacturacion() {
		Iterator<Estacionamiento> iterator = this.getListaRegistrosParkings().iterator();
		while (iterator.hasNext()) {
			Estacionamiento registro = iterator.next();
			if (registro.getFechaSalida() != null) {
				double hours = ChronoUnit.HOURS.between(registro.getFechaEntrada(), registro.getFechaSalida());
				this.facturacion += hours*1.50;
			}
		}
	}
	
	public Estacionamiento getEstacionamiento() {
		Iterator<Estacionamiento> iterator = this.listaRegistrosParkings.iterator();
		while (iterator.hasNext()) {
			Estacionamiento registrosParking = iterator.next();
			if (registrosParking.getFechaSalida() == null) {
				return registrosParking;
			}
		}
		return null;
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
	
	
	@Override
	public String toString() {
		String string = "Tipo: " + this.getTipo() + " - Matricula: " + this.getMatricula() + " - Color: " + this.getColor() + "\n";
		Iterator<Estacionamiento> iterator = this.getListaRegistrosParkings().iterator();
		while (iterator.hasNext()) {
			Estacionamiento registro = iterator.next();
			string = string.concat("Fecha Entrada: " + registro.getFechaEntrada() + " - Fecha Salida: " + registro.getFechaSalida() + "\n"); 
		}
		string = string.trim();
		return string;
	}
	
	

}
