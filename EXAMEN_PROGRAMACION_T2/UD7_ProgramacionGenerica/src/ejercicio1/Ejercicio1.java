package ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<Integer, Float> pair1 = new Pair<>();
		pair1.setFirst(1);
		pair1.setSecond(5.2f);
		System.out.println("El primer parámetro es: " + pair1.getFirst() + " el segundo es: " + pair1.getSecond());
		
		
		Pair<String, Integer[]> pair2 = new Pair<>();
		pair2.setFirst("Hola");
		Integer[] arrayInt = {1, 2, 3, 5};
		pair2.setSecond(arrayInt);
		System.out.println("El primer parámetro es: " + pair2.getFirst() + " el segundo es: " + pair2.getSecond());
		
		
		Pair<Persona, Persona> pair3 = new Pair<>();
		pair3.setFirst(new Persona("Pepe", 98153970));
		pair3.setSecond(new Persona("Sebas", 98153956));
		System.out.println("El primer parámetro es: " + pair3.getFirst() + " el segundo es: " + pair3.getSecond());
		

	}

}
