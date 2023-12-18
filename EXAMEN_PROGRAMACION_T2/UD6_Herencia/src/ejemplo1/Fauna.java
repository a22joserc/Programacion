package ejemplo1;

public class Fauna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		animal.setEdad(3);
		animal.setNombre("Dude");
		System.out.println(animal.toString());
		Gato gataBlanca = new Gato();
		gataBlanca.setNombre("Victoriaaaaaa");
		gataBlanca.setEdad(73);
		System.out.println(gataBlanca.toString());
		System.out.println(gataBlanca.habla());
		Perro bolo = new Perro();
		bolo.setNombre("Bucky");
		bolo.setEdad(11);
		System.out.println(bolo.toString());
		System.out.println(bolo.habla());
		// Constructor por paso de parámetros
		Gato gato = new Gato(4,"Lucky");
		System.out.println(gato.toString());
		System.out.println(gato.habla());
	}

}
