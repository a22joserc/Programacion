package democentroacademicoV2;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class CentroAcademico implements PlantillaCentroAcademico {
	
	// Variables de clase
	private HashSet<Alumno> listaAlumnos;
	private TreeSet<Asignatura> listaAsignaturas;
	
	// Constructor
	public CentroAcademico() {
		listaAlumnos = new HashSet<>();
		listaAsignaturas = new TreeSet<>(new CompararAsignaturas());
	}
	
	// Getters
	/** Declaramos los getters privados para evitar que desde el main se puedan modificar
	las colecciones de objetos Alumnos y Asignaturas sólo utilizando los métodos definidos
	por la interface */
	
	private HashSet<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	
	private TreeSet<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}
	
	// Desarrollamos métodos Inteface
	
	@Override
	public boolean crearAlumno(String expediente,String nombre) {
		boolean addAlumno = listaAlumnos.add(new Alumno(expediente, nombre));
		if (addAlumno) {
			System.out.println("El alumno con con número de expediente " + expediente + " se ha añadido en el sistema del centro academico");
		}
		else {
			System.out.println("ERROR: El alumno con con número de expediente " + expediente + " ya se encuentra registrado en el sistema");
		}
		return  addAlumno;
		//return listaAlumnos.add(new Alumno(expediente, nombre));
	}
	
	@Override
	public boolean crearAsignatura(String codigo,String nombre, String creditos) {
		boolean addAsignatura = listaAsignaturas.add(new Asignatura(codigo, nombre, Integer.parseInt(creditos)));
		if (addAsignatura) {
			System.out.println("La asignatura con código " + codigo + " se ha añadido en el sistema del centro academico");
		}
		else {
			System.out.println("ERROR: La asignatura con código " + codigo + " ya se encuentra registrado en el sistema");
		}
		return addAsignatura;
		//return listaAsignaturas.add(new Asignatura(codigo, nombre, Integer.parseInt(creditos)));
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
		if (this.getAlumno(expediente).getAsignaturasMatriculadas().add(this.getAsignatura(codigo))) {
			this.getAsignatura(codigo).getListadoAlumnos().add(this.getAlumno(expediente));
			this.getAsignatura(codigo).getListadoCalificaciones().put(expediente, 0.0);
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
			Iterator<Asignatura> iterator = this.getAlumno(expediente).getAsignaturasMatriculadas().iterator();
			while(iterator.hasNext()) {
				Asignatura asignatura = iterator.next();
				System.out.println("\t" + asignatura.getNombre() + ": " + asignatura.getListadoCalificaciones().get(expediente));
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
		
		Iterator<Asignatura> iterator = this.getAlumno(expediente).getAsignaturasMatriculadas().iterator();
		while(iterator.hasNext()) {
			Asignatura asignatura = iterator.next();		
			if(asignatura.getCodigo().equals(codigo)) {
				asignatura.getListadoCalificaciones().put(expediente, calificacion);
				this.getAlumno(expediente).setNotaMedia();
				System.out.println("Asignado nota " + calificacion  +  " a la asignatura con código " + codigo + " al alumno con número de expediente " + expediente);
				return true;
			}
		}
		System.out.println("ERROR: El alumno con número de expediente " + expediente + " no se encuentra matriculado de la asignatura con código " + codigo);
		return false;
	}
	
	
	@Override
	public void imprimirAsignatura(String codigo) {
		if (this.getAsignatura(codigo) == null) {
			System.out.println("ERROR: La asignatura con código " + codigo + " no se encuentra registrada en el sistema");
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
			Iterator<Asignatura> iterator = this.getListaAsignaturas().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
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
		Iterator<Asignatura> iterator = listaAsignaturas.iterator();
		while (iterator.hasNext()) {
			Asignatura asignatura = iterator.next();
			if (asignatura.getCodigo().equals(codigo)) {
				return asignatura;
			}
		}
		return null;
	}
	

}
