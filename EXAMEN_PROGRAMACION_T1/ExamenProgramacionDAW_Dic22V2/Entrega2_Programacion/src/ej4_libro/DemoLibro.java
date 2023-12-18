package ej4_libro;
import java.util.Scanner;

public class DemoLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****************************** LIBRO 1 **********************");
		Libro l1 = new Libro();
		System.out.println(l1.toString());
		// Métodos set
		l1.setAutor("George RR Martin");
		l1.setTitulo("Juego de Tronos");
		l1.setIsbn("2415-00-254-2");
		l1.setNumPag(500);
		System.out.println("Ahora el libro l1:");
		System.out.println(l1.toString());
		System.out.println("****************************** LIBRO 2 **********************");
		// Objeto por paso de parámetros
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el título del libro");
		String titulo = sc.nextLine();
		System.out.println("Introduzca el autor del libro");
		String autor = sc.nextLine();
		System.out.println("Introduzca el ISBN del libro");
		String isbn = sc.nextLine();
		System.out.println("Introduzca el número de páginas del libro");
		int pag = sc.nextInt();
		sc.close();
		Libro l2 = new Libro(isbn, titulo, autor, pag);
		System.out.println(l2.toString());
		// Comparamos libros por numero de página
		System.out.println("****************************** LIBRO MÁS PÁGINAS **********************");
		Libro libroMasPag = l1.comparaPaginas(l2);
		System.out.println("El libro " + libroMasPag.getTitulo() + " tiene un mayor número de páginas (" + libroMasPag.getNumPag() + ")");

	}

}
