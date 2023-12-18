package ejercicio2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public abstract class Producto {
	
	// Variables de clase
	protected String codProd;
	protected String nombre;
	protected double precio;
	protected HashSet<Proveedor> proveedores;
	
	
	public Producto(String codProd, String nombre, double precio) {
		this.codProd = codProd;
		this.nombre = nombre;
		this.precio = precio;
		this.proveedores = new HashSet<>();
	}
	
	public Producto(String codProd, String nombre, double precio, HashSet<Proveedor> proveedores) {
		this.codProd = codProd;
		this.nombre = nombre;
		this.precio = precio;
		this.proveedores = proveedores;
	}
	
	public String getCodProd() {
		return codProd;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public HashSet<Proveedor> getProveedores() {
		return proveedores;
	}
	
	
	public String getCodigosProvedoresfromProductos() {
		String linea = "";
		Iterator<Proveedor> iterator = this.getProveedores().iterator();		
		while (iterator.hasNext()) {
			Proveedor proveedor = iterator.next();
			linea = linea.concat(proveedor.getCodProv() + ",");
		}
		linea = linea.trim();
		linea = linea.replaceAll(",$", "");
		return linea;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Producto)) {
			return false;
		}
		// Comparamos por código de producto
		Producto otro = (Producto) obj;
		if (this.getCodProd().equals(otro.getCodProd())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codProd);
	}
	
}
