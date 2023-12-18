package tareaopcionalrepasoV3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Estacionamiento {
	
	private Vehiculo vehiculo;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private double facturacion;
	
	public Estacionamiento(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.facturacion = 0;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public double getFacturacion() {
		return facturacion;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public void setFacturacion() {
		if (this.getFechaEntrada() !=null && this.getFechaSalida() != null) {
			this.facturacion = ChronoUnit.HOURS.between(this.getFechaEntrada(),this.getFechaSalida()) * Parking.PRECIO_HORA_PARKING;
		}
		else {
			this.facturacion = 0;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaEntrada, fechaSalida, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Estacionamiento)) {
			return false;
		}
		Estacionamiento otro = (Estacionamiento) obj;
		if (this.getVehiculo().equals(otro.getVehiculo()) && this.getFechaEntrada().equals(otro.getFechaEntrada()) && this.getFechaSalida().equals(otro.getFechaSalida())) {
			return true;
		}	
		return false;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamiento other = (Estacionamiento) obj;
		return Objects.equals(fechaEntrada, other.fechaEntrada) && Objects.equals(fechaSalida, other.fechaSalida)
				&& Objects.equals(vehiculo, other.vehiculo);
	}
	*/
	
	@Override
	public String toString() {
		return this.getVehiculo().toString() + " - Fecha Entrada: " + this.getFechaEntrada() + " - Fecha Salida: " + this.getFechaSalida() + " - Facturación: " + this.getFacturacion() + " €";
	}

}
