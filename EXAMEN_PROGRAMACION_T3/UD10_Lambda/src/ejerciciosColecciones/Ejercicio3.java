package ejerciciosColecciones;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ejercicio3 {

	public static void main(String[] args) {

		Stream.generate(() -> new Random().nextInt(1, 11)).limit(5).forEach(x -> System.out.println(x));
		System.out.println("****************************************");
		Supplier<Integer> randomNumbersSupp = () -> new Random().nextInt(1, 11);
		Stream.generate(randomNumbersSupp).limit(5).forEach(x -> System.out.println(x));


	}

}
