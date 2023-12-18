package ejercicio4;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		try {
			Rectangulo miRectangulo=new Rectangulo(-2,3,4,5);
		} catch (Exception e) {
			System.out.println("Excepción recibida --> " + e.getMessage());
		}

	}

}
