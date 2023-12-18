package ejemplo1;

public class EmpleadoTemporal extends Empleado {
	public EmpleadoTemporal(String nombre, int ant) {
		 super(nombre, ant);
	}
	
	int calcularNomina() {
		return sueldoBase+50*ant;
	}


}
