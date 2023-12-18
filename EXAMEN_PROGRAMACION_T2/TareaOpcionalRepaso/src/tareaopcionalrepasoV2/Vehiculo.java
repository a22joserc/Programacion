package tareaopcionalrepasoV2;

import java.time.LocalDateTime;
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
	private HashSet<Estacionamiento> listaEstacionamientos;
	
	
	public Vehiculo(String matricula, String color, tipoVehiculo tipo) {
		this.matricula = matricula;
		this.color = color;
		this.tipo = tipo;
		this.facturacion = 0;
		this.inParking = false;
		this.listaEstacionamientos = new HashSet<>();
	}
	
	public HashSet<Estacionamiento> getListaEstacionamientos() {
		return listaEstacionamientos;
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
		Iterator<Estacionamiento> iterator = this.getListaEstacionamientos().iterator();
		double facturacion = 0;
		while (iterator.hasNext()) {
			Estacionamiento registro = iterator.next();
			if (registro.getFechaSalida() != null) {
				double horas = ChronoUnit.HOURS.between(registro.getFechaEntrada(), registro.getFechaSalida());
				facturacion += horas*1.50;
			}
		}
		this.facturacion = facturacion;
	}
	
	public double getFacturacionDiaPrevio(LocalDateTime fechaReferencia) {
		double facturacionDiaPrevio = 0;
		Iterator<Estacionamiento> iterator = this.getListaEstacionamientos().iterator();
		while (iterator.hasNext()) {
			Estacionamiento estacionamiento = iterator.next();
			if (estacionamiento.getFechaEntrada().isAfter(fechaReferencia.minusHours(24))  && estacionamiento.getFechaSalida() != null) {
				double horas = ChronoUnit.HOURS.between(estacionamiento.getFechaEntrada(), estacionamiento.getFechaSalida());
				facturacionDiaPrevio += horas*1.50;
			}
		}
		return facturacionDiaPrevio;
	}
	
	public Estacionamiento getEstacionamiento() {
		Iterator<Estacionamiento> iterator = this.listaEstacionamientos.iterator();
		while (iterator.hasNext()) {
			Estacionamiento estacionamiento = iterator.next();
			if (estacionamiento.getFechaSalida() == null) {
				return estacionamiento;
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
		String string = "Tipo: " + this.getTipo() + " - Matricula: " + this.getMatricula() + " - Color: " + this.getColor() + "\n";
		Iterator<Estacionamiento> iterator = this.getListaEstacionamientos().iterator();
		while (iterator.hasNext()) {
			Estacionamiento registro = iterator.next();
			string = string.concat("Fecha Entrada: " + registro.getFechaEntrada() + " - Fecha Salida: " + registro.getFechaSalida() + "\n"); 
		}
		string = string.trim();
		return string;
	}
	
	

}
