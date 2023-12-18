package ejercicio3;

public class Rectangulo {
	// Variables de clase
	private int origenX;
	private int origenY;
	private int ancho ;
	private int alto ;
	
	// Constructor clase
	public Rectangulo(int origenX, int origenY, int ancho, int alto) {
		this.origenX = origenX;
		this.origenY = origenY;
		this.ancho = ancho;
		this.alto = alto;
	}
	//SETTERS
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}

	// MÉTODOS
	
	public void desplazar(int x, int y) {
		this.origenX+=x;
		this.origenY+=y;
	 }
	
	public Rectangulo duplicar(){
		return new Rectangulo(origenX,origenY,ancho,alto);
	}
	
	public boolean esMayor(Rectangulo rect){
		if (this.ancho*this.alto>rect.ancho*rect.alto) {
			return true;
		}
		else {
			return false;
		}
	 }
	
	 public String datosRectangulo(){
		 return "("+ origenX+","+origenY+","+ancho+","+alto+")";
	 }


}
