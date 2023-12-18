package ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Barco
		Barco barco = new Barco("Bribón", "yate", 50, 200);
		// GPS
		Gps posicion = new Gps("42ºN","9ºW","12-09-2023","10:02:58", 349);
		
		Tripulante[] tripulantes = new Tripulante[7];
		tripulantes[0] = new Capitan(12345678, 45, 10, "Jose Rodríguez", "666665667", 'H', barco, posicion, 4000);
		tripulantes[1] = new Capitan(34598521, 32, 10, "María Pérez", "659874123", 'H', barco, posicion, 8000);
		tripulantes[2] = new JefeFlota(87654321, 56, 25, "Antonio Martínez", "987654321", 'H', barco, posicion, 25000, 5000, 2000);
		tripulantes[3] = new Marinero(446789123, 23, 5, "Jesús López", "986542312", 'H', barco, posicion, 300, 300);
		tripulantes[4] = new Marinero(334455661, 32, 3, "Pedro Ramos", "981556644", 'H', barco, posicion, 500, 500);
		tripulantes[5] = new Marinero(552233449, 25, 4, "Sergio López", "982326547", 'H', barco, posicion, 1000, 800);
		tripulantes[6] = new Marinero(778855661, 20, 1, "Ramón García", "987986512", 'H', barco, posicion, 100, 1000);
		// Mostramos el enlazado dinámico del polimorfismo.
		// El compilador de JAVA ya detecta automaticamente el método sobreescrito al que tiene que llamar (clase Capitan, JefeFlota o Marinero)
		int contCapitan = 0;
		int contMarinero = 0;
		int contJefeFlota = 0;
		int pos = 0;
		for (Tripulante tripulante:tripulantes) {
			tripulante.sueldo();
			tripulante.mostrarInfo();
			System.out.println("**** MOSTRAMOS MÉTODOS ESPECÍFICOS CAPTITAN, MARINERO, ****");
			if (tripulante instanceof Capitan) {
				// Llamamos a un método específico de la clase Capitan para ello realizamos un casting
				Capitan capitan = (Capitan) tripulante;
				System.out.println("En la posición " + pos + " del array de tripulantes: " + capitan.saludoCapitan());
				contCapitan++;
			}
			else if (tripulante instanceof JefeFlota) {
				// Llamamos a un método específico de la clase JefeFlota para ello realizamos un casting
				JefeFlota jefeFlota = (JefeFlota) tripulante;
				System.out.println("En la posición " + pos + " del array de tripulantes: " + jefeFlota.saludoJefeFlota());
				contJefeFlota++;
			}
			else {
				// Llamamos a un método específico de la clase Marinero para ello realizamos un casting
				Marinero marinero = (Marinero) tripulante;
				System.out.println("En la posición " + pos + " del array de tripulantes: " + marinero.saludomarinero());
				contMarinero++;
			}
			System.out.println("**********************************************************");
			pos++;
		}
		System.out.println("Núm total TRIPULANTES " + tripulantes.length + "\nCapitanes: " + contCapitan + "\nJefes de Flota: " + contJefeFlota + "\nMarineros: " + contMarinero);

	}

}
