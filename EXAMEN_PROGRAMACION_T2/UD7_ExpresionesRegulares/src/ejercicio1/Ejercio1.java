package ejercicio1;

public class Ejercio1 {
	
	public static void main(String[] args) {
		
		

		try {
			// Dni dni = new Dni(44824695, 'H');
			Dni dni = new Dni("44824695H");
			
		} catch (Exception e) {
			System.out.println("Excepción capturada -> " + e.getMessage());
		}
		
		System.out.println("Continuamos programa!");
		
	}

}
