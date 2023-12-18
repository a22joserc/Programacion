package centrocultural;
import java.time.LocalDate;

public class Prestamo {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Material material;
	
	// Constructor por paso de parámetros
	
	public Prestamo(Material material) {
		this.fechaInicio = LocalDate.now();
		this.fechaFin = LocalDate.now().plusDays(15);
		this.material = material;
		this.material.setPrestado(true);
	}
	
	
	// GETTERS
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	@Override
	public String toString() {
		if (this.material instanceof Libro) {
			return "LIBRO - Título: " + this.getMaterial().getTitulo() + ", ID: " + this.getMaterial().getCodigoID() + ", Fecha inicio: " + this.getFechaInicio() + ", Fecha fin: " + this.getFechaFin();
		}
		else {
			return "DISCO - Título: " + this.getMaterial().getTitulo() + ", ID: " + this.getMaterial().getCodigoID() + ", Fecha inicio: " + this.getFechaInicio() + ", Fecha fin: " + this.getFechaFin();
		}
	}

}
