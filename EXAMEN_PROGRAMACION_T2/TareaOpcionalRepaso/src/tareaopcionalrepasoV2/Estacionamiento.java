package tareaopcionalrepasoV2;

import java.time.LocalDateTime;

public class Estacionamiento {
	
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	
	
	public Estacionamiento(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}