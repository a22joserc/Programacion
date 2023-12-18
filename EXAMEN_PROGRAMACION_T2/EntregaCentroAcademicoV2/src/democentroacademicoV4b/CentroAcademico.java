package democentroacademicoV4b;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import centroacademicoexceptions.*;

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
	
	@Override
	public boolean crearAlumno(String expediente,String nombre) throws AlumnoCodigoException{
		if (!expediente.matches("^[0-9]{8}[A-Z]$")) {
			throw new AlumnoCodigoException();
		}
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
	public boolean crearAsignatura(String codigo,String nombre, String creditos) throws AsignaturaCodigoException, AsignaturaCreditosException{
		if (!codigo.matches("^A-[0-9]{3}$")) {
			throw new AsignaturaCodigoException();	
		}
		if (Integer.parseInt(creditos) <= 0) {
			throw new AsignaturaCreditosException();	
		}
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
	public boolean matricular(String expediente, String codigo) throws AlumnoCodigoException, AsignaturaCodigoException{
		if (!expediente.matches("^[0-9]{8}[A-Z]$")) {
			throw new AlumnoCodigoException();
		}
		if (!codigo.matches("^A-[0-9]{3}$")) {
			throw new AsignaturaCodigoException();	
		}
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
	public void imprimirAlumno(String expediente) throws AlumnoCodigoException {
		if (!expediente.matches("^[0-9]{8}[A-Z]$")) {
			throw new AlumnoCodigoException();
		}
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
			try {
				this.imprimirAlumno(alumno.getNumExpediente());
			} catch (AlumnoCodigoException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	@Override
	public boolean agregarCalificacion(String expediente, String codigo, double calificacion) throws AlumnoCodigoException, AsignaturaCodigoException {
		if (!expediente.matches("^[0-9]{8}[A-Z]$")) {
			throw new AlumnoCodigoException();
		}
		if (!codigo.matches("^A-[0-9]{3}$")) {
			throw new AsignaturaCodigoException();	
		}
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
	public void imprimirAsignatura(String codigo) throws AsignaturaCodigoException, AsignaturaException {
		if (!codigo.matches("^A-[0-9]{3}$")) {
			throw new AsignaturaCodigoException();	
		}
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
	public void compararAlumno (String expediente1, String expediente2) throws AlumnoCodigoException {
		if (!expediente1.matches("^[0-9]{8}[A-Z]$") || !expediente2.matches("^[0-9]{8}[A-Z]$")) {
			throw new AlumnoCodigoException();
		}
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