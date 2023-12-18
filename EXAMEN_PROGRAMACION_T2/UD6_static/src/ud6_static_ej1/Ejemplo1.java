package ud6_static_ej1;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Accedemos a la variable estática sin tener que instanciar un objeto de la clase
		System.out.println("total de cohetes " + Cohete.numCohetes);
		Cohete C1 = new Cohete("C1");
		Cohete C2 = new Cohete("C2");
		Cohete C3 = new Cohete("C3");
		// No es muy recomendable
		System.out.println("total de cohetes " + C3.numCohetes);

	}

}
