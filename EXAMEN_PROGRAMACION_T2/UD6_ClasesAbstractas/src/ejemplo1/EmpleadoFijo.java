package ejemplo1;

public class EmpleadoFijo extends Empleado {
	
	public EmpleadoFijo(String nombre, int ant) {
		super(nombre, ant);
	}
	@Override //esa anotación no es obligatoria pero tiene ventajas usarla, una es la legibilidad del código
	int calcularNomina() {
		return sueldoBase+100*ant;
	}
}

