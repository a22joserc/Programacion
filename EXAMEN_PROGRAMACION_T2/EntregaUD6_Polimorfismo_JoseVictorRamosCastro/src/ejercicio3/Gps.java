package ejercicio3;

public class Gps {
	// Variables de clase
	private String coordenadaX;
	private String coordenadaY;
	private String fecha;
	private String hora;
	private int diasTripulado;
	
	// Constructor con paso de parámetros	
	public Gps(String coordenadaX, String coordenadaY, String fecha, String hora, int diasTripulado) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.fecha = fecha;
		this.hora = hora;
		this.diasTripulado = diasTripulado;
	}
	
	// Getters
	
	public String getCoordenadaX() {
		return coordenadaX;
	}
	
	public String getCoordenadaY() {
		return coordenadaY;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getHora() {
		return hora;
	}
	public int getDiasTripulado() {
		return diasTripulado;
	}
	
	
	@Override
	public String toString() {
		return "Coordenada X = " + this.getCoordenadaX() + ", Coordenada Y = " + this.getCoordenadaY() + ", Fecha = " + this.getFecha() + ", Hora = " + this.getHora() + ", Días Tripulado  = " + this.getDiasTripulado();
	}
	

}

