package tareaopcionalrepaso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class DemoParking {

	public static void main(String[] args) {
		
		Parking parking = new Parking();
		
		Vehiculo vehiculo1 = new Coche("3565-DPX", "verde");
		Vehiculo vehiculo2 = new Coche("8125-DBD", "verde");
		Vehiculo vehiculo6 = new Coche("7777-DBD", "verde");
		Vehiculo vehiculo3 = new Furgoneta("3251-AAB", "blanco");
		Vehiculo vehiculo4 = new Furgoneta("8888-AAB", "blanco");
		Vehiculo vehiculo5 = new Furgoneta("9999-AAB", "blanco");
		Vehiculo vehiculo7 = new Furgoneta("9009-AAB", "blanco");

		
		try {
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo2, LocalDate.of(2022, 3, 17));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo1, LocalDate.of(2023, 3, 17));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.salidaVehiculo(vehiculo1, LocalDate.of(2023, 3, 18));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo1, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo3, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo4, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo5, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo6, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
			parking.entradaVehiculo(vehiculo7, LocalDate.of(2023, 3, 19));
			System.out.println(parking.getNumeroPlazasLibres());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		LinkedList<Vehiculo> lista = parking.getRegistroVehiculos();
		for (Vehiculo vehiculo:lista) {
			System.out.println(vehiculo);
		}

	}


}
