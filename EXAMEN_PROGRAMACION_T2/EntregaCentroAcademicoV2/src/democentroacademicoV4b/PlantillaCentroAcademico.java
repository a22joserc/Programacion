package democentroacademicoV4b;

import centroacademicoexceptions.*;


public interface PlantillaCentroAcademico {
	
	boolean crearAlumno(String expediente,String nombre) throws AlumnoCodigoException;
	
	boolean crearAsignatura(String codigo,String nombre, String creditos) throws AsignaturaCodigoException, AsignaturaCreditosException;
	
	boolean matricular(String expediente, String codigo) throws AlumnoCodigoException, AsignaturaCodigoException;
	
	void imprimirAlumno(String expediente) throws AlumnoCodigoException;
	
	void imprimirAlumnos();
	
	void imprimirAsignatura(String código) throws AsignaturaCodigoException, AsignaturaException;
	
	boolean agregarCalificacion(String expediente, String codigo, double calificacion) throws AlumnoCodigoException, AsignaturaCodigoException;
	
	void compararAlumno (String expediente1, String expediente2) throws AlumnoCodigoException;

}
