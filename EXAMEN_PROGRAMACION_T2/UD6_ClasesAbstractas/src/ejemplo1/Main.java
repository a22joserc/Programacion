package ejemplo1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Empleado eGenerico=new Empleado("generico",2);
		// System.out.println("Nomina de " + eGenerico.nombre + ": " + eGenerico.calcularNomina());
		EmpleadoFijo eFijo=new EmpleadoFijo("fijo",10);
		System.out.println("Nomina de "+ eFijo.nombre+": "+eFijo.calcularNomina());
		EmpleadoTemporal eTemporal=new EmpleadoTemporal("temporal",5);
		System.out.println("Nomina de "+ eTemporal.nombre+": "+eTemporal.calcularNomina());
		EmpleadoComercial eComercial=new EmpleadoComercial(30,"comercial",5);
		System.out.println("Nomina de "+ eComercial.nombre+": "+eComercial.calcularNomina());
	}

}
