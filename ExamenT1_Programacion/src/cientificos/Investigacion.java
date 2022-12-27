package cientificos;
import java.math.BigDecimal;

public class Investigacion {
	// Variables de clase
	private String id;
	private String nombre;
	private BigDecimal numInv;
	// Constructor por Defecto
	public Investigacion() {
		this.id = "0000-XXX";
		this.nombre = "Nombre Investigación";
		this.numInv = new BigDecimal("10");
	}
	// Constructor por paso de parámetros
	public Investigacion(String id, String nombre, BigDecimal numInv) {
		this.id = id;
		this.nombre = nombre;
		this.numInv = numInv;
	}
	// SETTERS
	public void setId(String id) {
		this.id = id;
	}
	public void setNumInv(BigDecimal numInv) {
		this.numInv = numInv;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// GETTERS
	public String getId() {
		return id;
	}
	public BigDecimal getNumInv() {
		return numInv;
	}
	public String getNombre() {
		return nombre;
	}
}
