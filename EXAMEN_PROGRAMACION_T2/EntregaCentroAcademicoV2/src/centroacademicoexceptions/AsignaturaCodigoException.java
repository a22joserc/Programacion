package centroacademicoexceptions;

public class AsignaturaCodigoException extends Exception {

	@Override
	public String getMessage() {
		return "ERROR: El código de la Asignatura debe empezar por A- y tener tres números. Ejemplo A-111!";
	}

}
