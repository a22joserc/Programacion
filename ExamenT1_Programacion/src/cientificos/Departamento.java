package cientificos;

public class Departamento {
	// Variables de clase
	private String nombre;
	private int antiguedad;
	private int presupuesto;
	private Cientifico[] plantilla;
	// Constructor por defecto
	public Departamento() {
		this.nombre = "Nombre Departamento";
		this.antiguedad = 0;
		this.setPresupuestoAnual();
		this.plantilla = new Cientifico[4];
	}
	// Constructor por paso de parámetros
	public Departamento(String  nombre, int antiguedad, Cientifico[] plantilla) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.plantilla = plantilla;
		this.setPresupuestoAnual();
	}
	// Consturctor Por paso de parámetros
	public Departamento(String  nombre, int antiguedad) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}
	public void crearPlantilla() {
		this.plantilla = new Cientifico[4];
	}
	public void agregarCientifico(Cientifico cientifico, int pos) {
		this.plantilla[pos]=cientifico;
	}
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	/*public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}*/
	public void setPlantilla(Cientifico[] plantilla) {
		this.plantilla = plantilla;
	}
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public Cientifico[] getPlantilla() {
		return plantilla;
	}
	// Método para eliminar Cientifico por Nombre
	public void eliminarCientifico(String nombreCientifico) {
		for(int i=0; i < this.plantilla.length; i++) {
			if(this.plantilla[i]!=null && this.plantilla[i].getNombre().equals(nombreCientifico)) {
				System.out.println("El científico de Nombre " + this.plantilla[i].getNombre() + " cuya investigación en " + this.plantilla[i].getInvestigacion().getNombre() + " han sido eliminados");
				this.plantilla[i] = null;
			}
		}
	}
	// Método para determinar la antiguedad de los Científicos del departamento
	public int calcularAntiguedadTotal() {
		int antTotal=0;
		for(int i=0; i < this.plantilla.length; i++) {
			if(this.plantilla[i]!= null) {
				antTotal += this.plantilla[i].getAnhos();
			}
		}
		return antTotal;
	}
	// Método para determinar la experiencia total de los Científicos del departamento
	public int calcularExperienciaTotal() {
		int expTotal=0;
		for(int i=0; i < this.plantilla.length; i++) {
			if(this.plantilla[i]!= null && this.plantilla[i].getExperiencia() == tipoExperiencia.Alta) {
				expTotal += 50;
			}
			else if(this.plantilla[i]!= null && this.plantilla[i].getExperiencia() == tipoExperiencia.Media) {
				expTotal += 25;
			}
			else if(this.plantilla[i]!= null && this.plantilla[i].getExperiencia() == tipoExperiencia.Baja) {
				expTotal += 10;
			}
		}
		return expTotal;
	}
	// Método para determinar Número Empleados activos
	public int calcularNumEmpleadosActivos() {
		int numEmpAct=0;
		for(int i=0; i < this.plantilla.length; i++) {
			if(this.plantilla[i]!= null) {
				numEmpAct++;		
			}
		}	
		return numEmpAct;
	}
	
	// Método para calcular Presupuesto Anual
	public void setPresupuestoAnual() {
		this.presupuesto=this.calcularNumEmpleadosActivos()*this.calcularExperienciaTotal()+this.calcularAntiguedadTotal();
	}
	// Método para mostrar información
	public void mostrarInfo() {
		System.out.println("****** INFO DEPARTAMENTO ********");
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Antigüedad: " + this.getAntiguedad());
		System.out.println("Presupuesto: " + this.getPresupuesto() + " €");
		System.out.println("Plantilla: ");
		for (int i=0; i< this.plantilla.length; i++) {
			if (this.plantilla[i] == null) {
				System.out.println("Cientifico " + (i+1) + " - >" + this.plantilla[i]);
			}
			else {
				System.out.println("Cientifico " + (i+1) + " - >" + this.plantilla[i].toString());
			}
		}
	}
	
}
