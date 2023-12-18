package primerainterface;


public interface Producto {
	
	double IVA_G = 0.21;
	double IVA_R = 0.10;
	double IVA_SR = 0.04;

	double getPrecio();

	String getNombre();
	 
	public static double getTotal(Producto[] lista) {
		double sum = 0.0;
		for(Producto p: lista) sum += p.getPrecio();
		return sum;
	 }

}
