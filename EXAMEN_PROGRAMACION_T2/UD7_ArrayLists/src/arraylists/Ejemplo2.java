package arraylists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro libro1 = new Libro("0345404475", "Do Androids Dream of Electric Sheep?", "Philip K.Dick");
		Libro libro2 = new Libro("0451457998", "2001: A Space Odissey", "Arthur C. Clarke");
		Libro libro3 = new Libro("0451457998", "2001: A Space Odissey", "Arthur C. Clarke");
		
		
		List<Libro> biblioteca = new ArrayList<>();
		biblioteca.add(libro1);
		biblioteca.add(libro2);
		biblioteca.add(libro3);
		
		Iterator<Libro> it = biblioteca.iterator();
		
		while(it.hasNext()) {
			if (it.next().getTitulo().equals("2001: A Space Odissey")) {
				it.remove();
			}
		}
		
		biblioteca.forEach(libro -> System.out.println(libro));
		
		
	}

}
