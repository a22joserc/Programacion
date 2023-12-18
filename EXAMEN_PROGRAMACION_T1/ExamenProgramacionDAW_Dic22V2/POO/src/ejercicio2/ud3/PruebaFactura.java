package ejercicio2.ud3;

public class PruebaFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Constructor por defecto
		Factura factura1 = new Factura();
		// Métodos getters para obtener los atributos de clase
		System.out.println("****************** FACTURA 1 ***************************");
		System.out.println("La factura contiene:");
		System.out.println("\tProducto: " + factura1.getDescrpPieza());
		System.out.println("\tID: " + factura1.getNumeroPieza());
		System.out.println("\tCantidad: " + factura1.getCantPieza());
		System.out.println("\tPrecio: " + factura1.getPrecioPieza());
		// Métodos setter para modificar los atributos de clase
		factura1.setDescripPieza("Tornillo");
		factura1.setNumeroPieza("TOR-001");
		factura1.setCantPieza(10);
		factura1.setPrecioPieza(0.58);
		// Mostramos de nuevo la información de factura1
		System.out.println("La factura ahora contiene:");
		System.out.println("\tProducto: " + factura1.getDescrpPieza());
		System.out.println("\tID: " + factura1.getNumeroPieza());
		System.out.println("\tCantidad: " + factura1.getCantPieza());
		System.out.println("\tPrecio: " + factura1.getPrecioPieza());
		// Mostramos el importe de la factura
		System.out.println("El importe de la factura es: " + factura1.obtenerMontoFactura() + " €");
		// Constructor con paso de parámetros
		Factura factura2 = new Factura("TUE-001","Tuerca",10,0.25);
		// Mostramos la fucionalidad del método imprimirEstado()
		System.out.println("****************** FACTURA 2 ***************************");
		factura2.imprimirEstado();
		// Método que devuelve el objeto factura de mayor precio
		Factura factura = factura1.comparaPrecioFactura(factura2);
		System.out.println("El importe de la factura de mayor precio es " + factura.obtenerMontoFactura() + " €");
	}

}
