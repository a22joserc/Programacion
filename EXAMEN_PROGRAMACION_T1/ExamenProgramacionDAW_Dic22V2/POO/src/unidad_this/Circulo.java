package unidad_this;

public class Circulo {
	private int coordX;
	private int coordY;
	private int radio;
	
	Circulo(){
		coordX=0;
		coordY=0;
		radio=1;
	}
	
	Circulo(int coordX, int coordY, int radio){
		this.coordX = coordX;
		this.coordY = coordY;
		this.radio = radio;	
	}
	
	// SETTERS
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
	// GETTERS
	public int getCoordX() {
		return coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public int getRadio() {
		return radio;
	}
	// Método Circulo Radio mayor
	
	public Circulo getMayorRadio(Circulo circulo) {
		if(this.getRadio()>circulo.getRadio()) {
			return this;
		}
		else {
			return circulo;
		}
	}
		
	public Circulo getMayorRadio2(Circulo circulo) {
		return (this.getRadio()>circulo.getRadio()?this:circulo); 
	}
	
	public Circulo getMayorRadioV2(Circulo circulo) {
		Circulo circuloMayor = new Circulo();
		if(this.getRadio()>circulo.getRadio()) {
			circuloMayor = this;
		}
		else {
			circuloMayor = circulo;
		}
		return circuloMayor;
	}
	
	public Circulo getMayorRadioV3(Circulo circulo) {
		Circulo circuloThis = new Circulo(this.getCoordX(),this.getCoordY(),this.getRadio());
		Circulo circuloComp = new Circulo(circulo.getCoordX(),circulo.getCoordY(),circulo.getRadio());
		if(this.getRadio()>circulo.getRadio()) {
			return circuloThis;
		}
		else {
			return circuloComp;
		}
	}
	
	public void imprimirEstado() {
		System.out.println("***********************");
		System.out.println(this);
		System.out.println("Coordenada X = " + this.getCoordX());
		System.out.println("Coordenada Y = " + this.getCoordY());
		System.out.println("Radio R = " + this.getRadio());
		System.out.println("***********************");
		
	}

}
