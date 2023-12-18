package ejercicio1;

public class Coordenadas {
	
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
		return "Longitude: " + this.longitude + " - Latitude: " + this.latitude;
	}

}
