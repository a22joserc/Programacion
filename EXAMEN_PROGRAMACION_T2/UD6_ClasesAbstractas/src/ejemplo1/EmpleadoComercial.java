package ejemplo1;

public class EmpleadoComercial extends Empleado {
	 int comision;
	 public EmpleadoComercial(int comision, String nombre, int ant) {
		 super(nombre, ant);
		 this.comision = comision;
	 }
	 int calcularNomina() {
		 return sueldoBase+comision;
	 }

}
