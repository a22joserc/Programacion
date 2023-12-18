package sobrecarga.metodos;

public class MainPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona(28,"Jose López López");
		Persona p2 = new Persona(25,"Bonifacio Martínez");
		System.out.println("Es " + p1.getNombre() + " mayor de edad? " + p1.mayorEdad());
		System.out.println("Es " + p2.getNombre() + " mayor de edad? " + p2.mayorEdad());
		System.out.println("La persona más mayor es " + p2.revelaMasViejo(p1).getNombre());
	}

}
