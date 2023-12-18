package ejercicio4;

import java.util.ArrayList;

public class DemoOperacionesAnimal {

	public static void main(String[] args) {
		
		OperacionesAnimalesV2 operacionesAnimales = new OperacionesAnimalesV2();
		
		/*operacionesAnimales.addAnimal(new Perro("Buck", 11, tipoRabo.LARGO));
		operacionesAnimales.addAnimal(new Gato("Sandro", 4, tipoBigote.LARGO));
		operacionesAnimales.addAnimal(new Gato("Luke", 5, tipoBigote.LARGO));
		
		operacionesAnimales.gardarAnimaisADisco("Animales.dat");*/
		
		ArrayList<Animal> listaAnimalesRecuperados = operacionesAnimales.lerAnimaisDisco("Animales.dat");
		
		for (Animal animal: listaAnimalesRecuperados) {
			System.out.println(animal);
		}

	}

}
