package primerainterface;

public class Tienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro libro1 = new Libro("Crimen y Castigo", 10.40, 752);
	    Pelicula peli1 = new Pelicula("Matrix", 9.99, 150);
	    System.out.println(libro1.getNombre() + ", " + libro1.getPrecio() + "€");
	    System.out.println(peli1.getNombre() + ", " + peli1.getPrecio() + "€");
	}

}
