package ejemplos;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		// Interfaz supplier
		
		Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
		Supplier<LocalDateTime> s = () -> LocalDateTime.now();
		LocalDateTime time = s.get();
		int random = randomNumbersSupp.get();
		System.out.println(random);
		System.out.println(time);
		
		// Interfaz predicate
		Predicate<String> checker = a -> a.startsWith("M") && a.endsWith("l");
		System.out.println(checker.test("Miguel"));

	}

}
