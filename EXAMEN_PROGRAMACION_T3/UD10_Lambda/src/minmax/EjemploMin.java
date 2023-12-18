package minmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EjemploMin {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
		Optional<Integer> var = list.stream().min(Comparator.reverseOrder());
		System.out.println(var.get());

	}

}
