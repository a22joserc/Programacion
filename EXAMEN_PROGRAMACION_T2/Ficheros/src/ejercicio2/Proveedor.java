package ejercicio2;

import java.util.Objects;


public class Proveedor {
	
	private String codProv;
	private String nombre;
	private String direccion;
	
	
	public Proveedor(String codProv, String nombre, String direccion) {
		this.codProv = codProv;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String getCodProv() {
		return codProv;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	@Override
	public String toString() {
		return "Proveedor - Código: " + this.getCodProv() + ", Nombre: " + this.getNombre() + ", Dirección: " + this.getDireccion();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Proveedor)) {
			return false;
		}
		Proveedor otro = (Proveedor) obj;
		if (this.getCodProv().equals(otro.getCodProv())) {
			return true;
		}
		return false;	
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codProv);
	}
	
	
	

}
