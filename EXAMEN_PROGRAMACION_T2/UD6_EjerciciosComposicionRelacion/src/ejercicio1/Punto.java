package ejercicio1;

public class Punto {
	// Variables de clase
	private int x;
	private int y;
	// Constructor por defecto
	public Punto() {
		this.x=0;
		this.y=0;
	}
	// Constructor por paso de parámetros
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// SETTERS
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	// GETTERS
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	// MéTODO DESPLAZAR
	
	public void desplazar(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	// MéTODO puntosIguales
	public boolean puntosIguales(Punto punto) {
		if (this.getX() == punto.getX() && this.getY() == punto.getY()) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	@Override
	public String toString() {
		return "(X = " + this.getX() + ", Y = " + this.getY() + ")";
	}

}
