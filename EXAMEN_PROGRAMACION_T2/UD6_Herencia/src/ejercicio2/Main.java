package ejercicio2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona("Zutano", "Santiago", "112345678H");
		System.out.println(persona);
		Cliente cliente = new Cliente("Mengano", "Lugo", "87654321H", 2500.32);
		System.out.println(cliente);
		Empleado empleado = new Empleado("Fulano", "Coruña", "65454321H", 30500.32);
		System.out.println(empleado);

	}

}
