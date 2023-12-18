package centroacademicoexceptions;

public class AlumnoCodigoException  extends Exception{
	
	@Override
	public String getMessage() {
		return "ERROR: El número de expediente del alumno debe corresponde con el de su DNI!";
	}
}
