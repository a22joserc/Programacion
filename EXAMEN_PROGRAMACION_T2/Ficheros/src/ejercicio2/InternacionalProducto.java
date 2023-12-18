package ejercicio2;

import java.util.HashSet;
import java.util.Iterator;

public class InternacionalProducto extends Producto {
	
	private String pais;
	public static final String TIPO = "i";
	
	public InternacionalProducto(String codProd, String nombre, double precio, String pais) {
		super(codProd, nombre, precio);
		this.pais = pais;
	}
	
	public InternacionalProducto(String codProd, String nombre, double precio, HashSet<Proveedor> proveedores, String pais) {
		super(codProd, nombre, precio, proveedores);
		this.pais = pais;
	}
	
	public String getPais() {
		return pais;
	}
	
	
	@Override
	public String toString() {
		String str = "Producto - Nombre: " + this.getNombre() + ", Tipo: " + TIPO + ", Código: " + this.getCodProd() + ", Precio: " + this.getPrecio() + " €, País: " + this.getPais() + ", Proveedores (Códigos): ";
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
