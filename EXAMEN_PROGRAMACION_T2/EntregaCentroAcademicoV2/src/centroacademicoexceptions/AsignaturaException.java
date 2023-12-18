package centroacademicoexceptions;

import java.time.LocalDate;
import democentroacademicoV4b.Asignatura;

public class AsignaturaException extends Exception {
	
	private Asignatura asignatura;
	private String codigoAsignaturaUsuario;
	
	public AsignaturaException(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public AsignaturaException(Asignatura asignatura, String codigoAsignaturaUsuario) {
		this.asignatura = asignatura;
		this.codigoAsignaturaUsuario = codigoAsignaturaUsuario;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public String getCodigoAsignaturaUsuario() {
		return codigoAsignaturaUsuario;
	}
	
	@Override
	public String getMessage() {
		if (this.getAsignatura() == null) {
			return "ERROR! La asignatura con código " + this.getCodigoAsignaturaUsuario() + " no se encuentra resgistrada en el sistema. Fecha del error " + LocalDate.now();
		}
		else {
			return "ERROR! La asignatura -> ( " + this.getAsignatura().toString() + ") no tiene alumnos matriculados. Fecha del error " + LocalDate.now();
		}
	}

}
