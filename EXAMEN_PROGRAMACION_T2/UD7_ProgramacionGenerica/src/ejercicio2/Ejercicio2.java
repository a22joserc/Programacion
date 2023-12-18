package ejercicio2;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		Pair<Integer, Float> pair1 = new Pair<>(1, 5.2f);
		System.out.println("El primer parámetro es: " + pair1.getFirst() + " el segundo es: " + pair1.getSecond());
		
		Integer[] arrayInt = {1, 2, 3, 5};
		Pair<String, Integer[]> pair2 = new Pair<>("hola", arrayInt);
		System.out.println("El primer parámetro es: " + pair2.getFirst() + " el segundo es: " + pair2.getSecond());
		
		Pair<Persona, Persona> pair3 = new Pair<>(new Persona("Pepe", 98153970), new Persona("Sebas", 98153956));
		System.out.println("El primer parámetro es: " + pair3.getFirst() + " el segundo es: " + pair3.getSecond());
	}

}
