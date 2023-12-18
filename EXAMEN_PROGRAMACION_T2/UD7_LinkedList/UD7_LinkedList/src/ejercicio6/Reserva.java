package ejercicio6;

public class Reserva {
	private String origen;
	private String destino;
	private String plaza;
	private boolean bussiness;
	private Persona pasajero;
	
	public Reserva(String origen, String destino, String plaza, boolean bussines, Persona pasajero) {
		this.origen = origen;
		this.destino = destino;
		this.plaza = plaza;
		this.bussiness = bussines;
		this.pasajero = pasajero;
	}
	
	
	@Override
	public String toString() {
		return "RESERVA - Origen: " + this.origen + ", Destino: " + this.destino + ", Plaza: " + this.plaza + ", Bussiness: " + this.bussiness + ", Pasajero: " + this.pasajero.toString();

	}
}
