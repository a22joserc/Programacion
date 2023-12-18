package ejercicio2.ud3;

public class Factura {
	private String numeroPieza;
	private String descrpPieza;
	private int cantPieza;
	private double precioPieza;
	
	// CONSTRUCTOR POR DEFECTO
	public Factura(){
		numeroPieza = "0000";
		descrpPieza = "Descripcion Pieza";
		cantPieza = 1;
		precioPieza = 0.0;
	}
	// CONSTRUCTOR POR PASO DE PARÁMETROS
	public Factura(String numeroPieza, String descrpPieza, int cantPieza, double precioPieza){
		this.numeroPieza = numeroPieza;
		this.descrpPieza = descrpPieza;
		this.cantPieza = cantPieza;
		this.precioPieza = precioPieza;
	}
	// SETTERS
	public void setNumeroPieza(String numeroPieza) {
		this.numeroPieza = numeroPieza;	
	}
	
	public void setDescripPieza(String descripPieza) {
		this.descrpPieza = descripPieza;	
	}
	
	public void setCantPieza(int cantPieza) {
		this.cantPieza = cantPieza;	
	}
	
	public void setPrecioPieza(double precioPieza) {
		this.precioPieza = precioPieza;	
	}
	// GETTERS
	public String getNumeroPieza() {
		return numeroPieza;
	}
	
	public int getCantPieza() {
		return cantPieza;
	}
	
	public double getPrecioPieza() {
		return precioPieza;
	}
	
	public String getDescrpPieza() {
		return descrpPieza;
	}
	
	/*public double obtenerMontoFactura() {
		return this.getCantPieza()*this.getPrecioPieza();
	}*/
	
	public double obtenerMontoFactura() {
		return cantPieza*precioPieza;
	}
	
	public Factura comparaPrecioFactura(Factura factura) {
		return (this.obtenerMontoFactura()>factura.obtenerMontoFactura()?this:factura);
	}
	
	public void imprimirEstado() {
		System.out.println("**************************");
		System.out.println("===DETALLE DE FACTURA===");
		System.out.println("Nombre artículo: " + this.getDescrpPieza());
		System.out.println("ID artículo: " + this.getNumeroPieza());
		System.out.println("Cantidad artículo: " + this.getCantPieza());
		System.out.println("Precio artículo: " + this.getPrecioPieza() + " €");
		System.out.println("**************************");
		System.out.println("IMPORTE TOTAL: " + this.obtenerMontoFactura() + " €");
		System.out.println("**************************");
		
	}
	
	public void imprimirEstado2() {
		System.out.println("**************************");
		System.out.println("===DETALLE DE FACTURA===");
		System.out.println("Nombre artículo: " + descrpPieza);
		System.out.println("ID artículo: " + numeroPieza);
		System.out.println("Cantidad artículo: " + cantPieza);
		System.out.println("Precio artículo: " + precioPieza + " €");
		System.out.println("**************************");
		System.out.println("IMPORTE TOTAL: " + this.obtenerMontoFactura() + " €");
		System.out.println("**************************");
		
	}

}
