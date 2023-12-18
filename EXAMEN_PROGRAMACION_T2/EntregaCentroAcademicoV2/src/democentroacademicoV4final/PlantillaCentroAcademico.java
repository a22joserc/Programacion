package democentroacademicoV4final;

public interface PlantillaCentroAcademico {
	
	boolean crearAlumno(String expediente,String nombre);
	
	boolean crearAsignatura(String codigo,String nombre, String creditos);
	
	boolean matricular(String expediente, String codigo);
	
	void imprimirAlumno(String expediente);
	
	void imprimirAlumnos();
	
	void imprimirAsignatura(String código) throws AsignaturaException;
	
	boolean agregarCalificacion(String expediente, String codigo, double calificacion);
	
	void compararAlumno (String expediente1, String expediente2);

}