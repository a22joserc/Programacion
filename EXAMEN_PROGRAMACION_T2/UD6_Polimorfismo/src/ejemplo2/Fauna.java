package ejemplo2;

public class Fauna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal[] animales = new Animal[4];
		animales[0] = new Perro();
		animales[1] = new Gato();
		animales[2] = new Estudiante();
		animales[3] = new Animal();
		
		for(Animal animal: animales) {
			System.out.println(animal.habla());
		}
 		
		Animal animalPerro = (Animal) animales[0];
		animalPerro.habla();
		

	}

}
