package cientificos;
import java.util.Scanner;
import java.math.BigDecimal;

public class Cientifico {
	// Variables de clase
	private String nombre;
	private String apellidos;
	private tipoExperiencia experiencia;
	private int anhos;
	private Investigacion investigacion;
	// Constructor por defecto
	public Cientifico() {
		this.nombre = "Nombre Científico";
		this.apellidos = "Apellidos Científico";
		this.experiencia = tipoExperiencia.Baja;
		this.anhos = 0;
		this.investigacion = null;
	}
	// Constructor por paso de parámetros
	public Cientifico(String nombre, String apellidos, tipoExperiencia experiencia, int anhos, Investigacion investigacion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.experiencia = experiencia;
		this.anhos = anhos;
		this.investigacion = investigacion;
	}
	public Cientifico(Investigacion investigacion) {
		this.investigacion = investigacion;
	}
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setExperiencia(tipoExperiencia experiencia) {
		this.experiencia = experiencia;
	}
	public void setAnhos(int anhos) {
		this.anhos = anhos;
	}
	public void setInvestigacion(Investigacion investigacion) {
		this.investigacion = investigacion;
	}
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getAnhos() {
		return anhos;
	}
	public tipoExperiencia getExperiencia() {
		return experiencia;
	}
	public Investigacion getInvestigacion() {
		return investigacion;
	}
	// Dar alta cientifico -- Mejor Método Static
	public void darAltaCientifico(Scanner sc) {
		System.out.println("Defina el nombre del científico: ");
		this.setNombre(sc.nextLine());
		System.out.println("Defina los apellidos del científico: ");
		this.setApellidos(sc.nextLine());
		System.out.println("Defina los años de experiencia del científico: ");
		this.setAnhos(Integer.parseInt(sc.nextLine()));
		System.out.println("Defina el nombre de la investigación del científico: ");
		this.investigacion.setNombre(sc.nextLine());
		System.out.println("Defina el ID de la investigación del científico: ");
		this.investigacion.setId(sc.nextLine());
		System.out.println("Defina el Número (Alta precisión) de la investigación del científico: ");
		this.investigacion.setNumInv(new BigDecimal(sc.nextLine()));
		boolean flag = false;
		do {
			System.out.println("Introduzca la experiencia del científico: ALTA - MEDIA - BAJA");
			String experiencia = sc.nextLine();
			if (experiencia.equalsIgnoreCase("ALTA")) {
				this.setExperiencia(tipoExperiencia.Alta);
				flag = true;
			}
			else if (experiencia.equalsIgnoreCase("MEDIA")) {
				this.setExperiencia(tipoExperiencia.Media);
				flag = true;
			}
			else if (experiencia.equalsIgnoreCase("BAJA")) {
				this.setExperiencia(tipoExperiencia.Baja);
				flag = true;
			}
			else {
				System.out.println("Error: El tipo de experiencia introducida no se admite en el sitema");
			}
		}while(flag==false);
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + " Apellidos: " + this.getApellidos() + " Expericiena: " + this.getExperiencia() + " Años trabajados: " + this.getAnhos() + " Investigación Asociada: " + this.investigacion.getNombre();
	}
	// Método MostrarInfo Científico
	public void mostrarInfo() {
		System.out.println("***** INFO CIENTIFICO *******");
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Apellidos: " + this.getApellidos());
		System.out.println("Años: " + this.getAnhos());
		System.out.println("Experiencia: " + this.getExperiencia());
		System.out.println("Nombre Investigación: " + this.getInvestigacion().getNombre() + " - ID: " + this.getInvestigacion().getId());
	}
	
}
