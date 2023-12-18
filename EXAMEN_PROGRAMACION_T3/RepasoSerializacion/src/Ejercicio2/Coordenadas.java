package Ejercicio2;

import java.io.Serializable;

public class Coordenadas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String latitude;
	private String longitude;
	
	public Coordenadas(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordenadas() {
		this.longitude = "0 E";
		this.latitude = "0 N";
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Coordenadas [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	

}
