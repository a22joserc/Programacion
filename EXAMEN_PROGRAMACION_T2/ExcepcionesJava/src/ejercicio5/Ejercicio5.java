package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Producto producto = new Producto("A001", 25.2, 50);
		boolean stock = true;
		Scanner sc = new Scanner(System.in);
		do
			try {
				System.out.println("Introduzca el número de unidades a comprar");
				venderProducto(producto, Integer.parseInt(sc.nextLine()));
				stock = false;
				
			} catch (Exception e) {
				System.out.println("Excepción recibida -> " + e.getMessage());
			}
		while(stock);
		sc.close();
		System.out.println("Continuamos con el programa!");
	}
	
	public static void venderProducto(Producto producto, int unidades) throws StockException {
		
		if (unidades > producto.getStock()) {
			throw new StockException(Integer.toString(unidades), 101, "El stock no es suficiente!");
		}
		else {
			producto.setStock(producto.getStock()-unidades);
		}
		
	}

}
