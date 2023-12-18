package ejercicio2;

import java.util.HashSet;
import java.util.Iterator;

public class NacionalProducto extends Producto {
	
	public static final String TIPO = "n";
	
	public NacionalProducto(String codProd, String nombre, double precio) {
		super(codProd, nombre, precio);
	}
	
	public NacionalProducto(String codProd, String nombre, double precio, HashSet<Proveedor> proveedores) {
		super(codProd, nombre, precio, proveedores);
	}
	
	@Override
	public String toString() {
		String str = "Producto - Nombre: " + this.getNombre() + ", Tipo: " + TIPO + ", Código: " + this.getCodProd() + ", Precio: " + this.getPrecio() + " €, Proveedores (Códigos): ";
		Iterator<Proveedor> iterator = this.getProveedores().iterator();
		while (iterator.hasNext()) {
			Proveedor proveedor = iterator.next();
			str = str.concat(proveedor.getCodProv() + ", ");
		}
		str = str.trim();
		str = str.replaceAll(",$", ".");
		return str;
	}

}
