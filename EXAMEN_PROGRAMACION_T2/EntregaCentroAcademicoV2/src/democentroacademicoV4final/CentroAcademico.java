package democentroacademicoV4final;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;


public class CentroAcademico implements PlantillaCentroAcademico {
	
	// Variables de clase
	private HashSet<Alumno> listaAlumnos;
	private TreeMap<String,Asignatura> listaAsignaturas;
	
	// Constructor
	public CentroAcademico() {
		listaAlumnos = new HashSet<>();
		listaAsignaturas = new TreeMap<>();
	}
	
	// Getters
	/** Declaramos los getters privados para evitar que desde el main se puedan modificar
	las colecciones de objetos Alumnos y Asignaturas sólo utilizando los métodos definidos
	por la interface */
	private HashSet<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	
	private TreeMap<String,Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}
	
	@Override
	public boolean crearAlumno(String expediente,String nombre){
		boolean addAlumno = listaAlumnos.add(new Alumno(expediente, nombre));
		if (addAlumno) {
			System.out.println("El alumno con con número de expediente " + expediente + " se ha añadido en el sistema del centro academico");
		}
		else {
			System.out.println("ERROR: El alumno con con número de expediente " + expediente + " ya se encuentra registrado en el sistema");
		}
		return  addAlumno;
		// return listaAlumnos.add(new Alumno(expediente, nombre));
	}
	
	@Override
	public boolean crearAsignatura(String codigo,String nombre, String creditos) {
		if (this.getAsignatura(codigo) == null) {
			Asignatura asignatura = new Asignatura(codigo, nombre, Integer.parseInt(creditos));
			listaAsignaturas.put(asignatura.getCodigo(), asignatura);	
			System.out.println("La asignatura con código " + codigo + " se ha añadido en el sistema del centro academico");
			return true;
		}
		else {
			System.out.println("ERROR: La asignatura con código " + codigo + " ya se encuentra registrado en el sistema");
			return false;
		}
	}
	
	@Override
	public boolean matricular(String expediente, String codigo) {
		if (this.getAlumno(expediente) == null) {
			System.out.println("ERROR: El alumno con número de expediente " + expediente + " no se encuentra registrado en el sistema");
			return false;
		}
		if (this.getAsignatura(codigo) == null) {
			System.out.println("ERROR: La asignatura con código " + codigo + " no se encuentra registrada en el sistema");
			return false;
		}
		if (this.getAlumno(expediente).getExpedienteAcademico().add(new Expediente(this.getAsignatura(codigo)))) {
			this.getAsignatura(codigo).getListadoAlumnos().add(this.getAlumno(expediente));
			System.out.println("El alumno con con número de expediente " + expediente + " se ha matriculado con éxito de la asignatura con código " + codigo);
			return true;
		}
		System.out.println("ERROR: El alumno con número de expediente " + expediente + " ya se encuentra matriculado de la asignatura con código " + codigo);
		return false;
	}
	
	@Override
	public void imprimirAlumno(String expediente) {
		if (this.getAlumno(expediente) == null) {
			System.out.println("ERROR: El alumno con número de expediente " + expediente + " no se encuentra registrado en el sistema");
		}
		else {
			System.out.println("Nombre: " + this.getAlumno(expediente).getNombre() + " - Número Expediente: " + this.getAlumno(expediente).getNumExpediente());
			Iterator<Expediente> iterator = this.getAlumno(expediente).getExpedienteAcademico().iterator();
			while (iterator.hasNext()) {
				Expediente expedienteAcademico = iterator.next();
				System.out.println("\t" + expedienteAcademico.getAsignatura().getNombre() + ": " + expedienteAcademico.getNota());
				
			}
			System.out.println("\tNota media: " + this.getAlumno(expediente).getNotaMedia());
		}
	}
	
	@Override
	public void imprimirAlumnos() {
		if (this.getListaAlumnos().isEmpty()) {
			System.out.println("Actualmente el centro académico no tiene alumnos matriculados");
		}
		
		Iterator<Alumno> iterator = this.getListaAlumnos().iterator();
		while (iterator.hasNext()) {
			Alumno alumno = iterator.next();
			this.imprimirAlumno(alumno.getNumExpediente());
		}
	}
	
	
	@Override
	public boolean agregarCalificacion(String expediente, String codigo, double calificacion) {
		
		if (this.getAlumno(expediente) == null) {
			System.out.println("ERROR: El alumno con número de expediente " + expediente + " no se encuentra registrado en el sistema");
			return false;
		}
		if (this.getAsignatura(codigo) == null) {
			System.out.println("ERROR: La asignatura con código " + codigo + " no se encuentra registrada en el sistema");
			return false;
		}
		Iterator<Expediente> iterator = this.getAlumno(expediente).getExpedienteAcademico().iterator();
		while(iterator.hasNext()) {
			Expediente expedienteAcademico = iterator.next();
			if(expedienteAcademico.getAsignatura().getCodigo().equals(codigo)) {
				expedienteAcademico.setNota(calificacion);
				this.getAlumno(expediente).setNotaMedia();
				System.out.println("Asignado nota " + calificacion  +  " a la asignatura con código " + codigo + " al alumno con número de expediente " + expediente);
				return true;
			}
		}
		System.out.println("ERROR: El alumno con número de expediente " + expediente + " no se encuentra matriculado de la asignatura con código " + codigo);
		return false;
	}
	
	@Override
	public void imprimirAsignatura(String codigo) throws AsignaturaException {
		if (this.getAsignatura(codigo) == null) {
			throw new AsignaturaException(this.getAsignatura(codigo), codigo); 
		}
		else if (this.getAsignatura(codigo).getListadoAlumnos().size() == 0) {
			throw new AsignaturaException(this.getAsignatura(codigo)); 
		}
		else {
			System.out.println("Listado alumnos asignatura " + this.getAsignatura(codigo).getNombre() + "(" + this.getAsignatura(codigo).getCodigo() + ")");
			Iterator<Alumno> iterator = this.getAsignatura(codigo).getListadoAlumnos().iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
				
			}
			System.out.println("Número total de alumnos: " + this.getAsignatura(codigo).getListadoAlumnos().size());
		}
	}
	
	@Override
	public void compararAlumno (String expediente1, String expediente2) {
		Alumno alumno1 = this.getAlumno(expediente1);
		Alumno alumno2 = this.getAlumno(expediente2);
		if (alumno1 == null && alumno2 == null) {
			System.out.println("ERROR: Ninguno de los dos alumnos se encuentran registrados en el sistema!");
		}
		else if (alumno1 == null) {
			System.out.println("ERROR: El alumno con con número de expediente " + expediente1 + " no se encuentra registrado en el sistema!");
		}
		else if (alumno2 == null) {
			System.out.println("ERROR: El alumno con con número de expediente " + expediente2 + " no se encuentra registrado en el sistema!");
		}
		else if (alumno1.getNotaMedia() > alumno2.getNotaMedia()) {
			System.out.println("El alumno con con número de expediente " + expediente1 + " (" + alumno1.getNombre() + ") tiene mejor nota media (" + alumno1.getNotaMedia() + ")");
		}
		else if (alumno1.getNotaMedia() < alumno2.getNotaMedia()) {
			System.out.println("El alumno con con número de expediente " + expediente2 + " (" + alumno2.getNombre() + ") tiene mejor nota media (" + alumno2.getNotaMedia() + ")");
		
		}
		else {
			System.out.println("Los alumnos con números de expediente " + expediente1 + " (" + alumno1.getNombre() + ")"  + " y " + expediente2 + " (" + alumno2.getNombre() + ") tienen la misma nota media (" + alumno2.getNotaMedia() + ")");
		}
	}
	
	public void imprimirAsignaturas() {
		if (this.getListaAsignaturas().isEmpty()) {
			System.out.println("Actualmente el centro académico no tiene asignaturas disponibles");
		}
		else {
			TreeMap<String, Asignatura> listaAsignaturasOrdenadas = this.ordenarAsignaturasNombre(this.getListaAsignaturas());
			Iterator<String> iterator = listaAsignaturasOrdenadas.keySet().iterator();
			while (iterator.hasNext()) {
				System.out.println(listaAsignaturasOrdenadas.get(iterator.next()));
			}
		}
	}
	
	private Alumno getAlumno(String expediente) {
		Iterator<Alumno> iterator = listaAlumnos.iterator();
		while (iterator.hasNext()) {
			Alumno alumno = iterator.next();
			if (alumno.getNumExpediente().equals(expediente)) {
				return alumno;
			}
		}
		return null;
	}
	
	private Asignatura getAsignatura(String codigo) {
		return this.getListaAsignaturas().get(codigo);
	}
	
	
	private TreeMap<String, Asignatura> ordenarAsignaturasNombre(TreeMap<String, Asignatura> asignaturas){
		// Creamos nombreComparator
		Comparator<String> nombreComparator = new Comparator<String>() {
			@Override
		    public int compare(String codigo1, String codigo2) {
		        Asignatura a1 = asignaturas.get(codigo1);
		        Asignatura a2 = asignaturas.get(codigo2);
		        return a1.getNombre().compareTo(a2.getNombre());
		    }
		};
		// Creamos nuevo TreeMap y volcamos el original en él
		TreeMap<String, Asignatura> listaAsignaturasOrdenadas = new TreeMap<>(nombreComparator);
		listaAsignaturasOrdenadas.putAll(this.getListaAsignaturas());
		return listaAsignaturasOrdenadas;
		
	}

}