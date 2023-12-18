package ejercicio2;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		/*
		String pathFicheroProveedores = "FicherosEjercicio2//ProveedoresV2.txt";
		String pathFicheroProductos = "FicherosEjercicio2//Productos.txt";
		
		GestionProveedoresPedidos gestionProveedoresPedidos = new GestionProveedoresPedidos(pathFicheroProveedores, pathFicheroProductos);
		gestionProveedoresPedidos.imprimirProductosPantalla();
		gestionProveedoresPedidos.imprimirProveedoresPantalla();
		try {
			gestionProveedoresPedidos.crearPorducto("PR-04", "i", "Corta cesped Honda", 1500.2, "Japon");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		gestionProveedoresPedidos.imprimirProductosPantalla();
		try {
			gestionProveedoresPedidos.asignarProveedor("PR-04","A-001");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		gestionProveedoresPedidos.imprimirProductosPantalla();
		try {
			gestionProveedoresPedidos.crearProveedor("A-005", "Ferreteria o zapateiro", "Sixto 75");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		gestionProveedoresPedidos.imprimirProveedoresPantalla();
		gestionProveedoresPedidos.imprimirProveedoresV2();
		gestionProveedoresPedidos.imprimirProductos();
		*/
		
		String linea = "PR-01:n:Cemento Cola:19.25:A-001,A-002";
		String[] arrayLinea = linea.split("^*:");
		
		for (String str:arrayLinea) {
			System.out.println(str);
		}
		
				
	}
	
}
