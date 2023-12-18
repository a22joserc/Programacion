package tareaopcionalrepasoV2;


import java.time.LocalDateTime;
import java.util.HashSet;


public class DemoParking {

	public static void main(String[] args) {
		
		LocalDateTime fechaReferencia = LocalDateTime.of(2023, 3, 20, 0, 0);
		
		Parking parking = new Parking();
		
		Vehiculo coche1 = new Vehiculo("3565-DPX", "verde", tipoVehiculo.coche);
		Vehiculo coche2 = new Vehiculo("8125-DBD", "verde", tipoVehiculo.coche);
		Vehiculo coche3 = new Vehiculo("7777-DBD", "verde", tipoVehiculo.coche);
		Vehiculo furgoneta1 = new Vehiculo("3251-AAB", "blanco",tipoVehiculo.furgoneta);
		Vehiculo furgoneta2 = new Vehiculo("8888-AAB", "blanco", tipoVehiculo.furgoneta);
		Vehiculo furgoneta3 = new Vehiculo("9999-AAB", "blanco", tipoVehiculo.furgoneta);
		Vehiculo furgoneta4 = new Vehiculo("9009-AAB", "blanco", tipoVehiculo.furgoneta);
		Vehiculo furgoneta5 = new Vehiculo("0000-AAB", "blanco", tipoVehiculo.furgoneta);

		//------------------------------------------------------------------------
		/*
		System.out.println(parking.getNumeroPlazasLibres());
		parking.entradaVehiculo(coche1, LocalDateTime.of(2023, 3, 18, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(coche1, LocalDateTime.of(2023, 3, 17, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.salidaVehiculo(coche1, LocalDateTime.of(2023, 3, 18, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(coche1, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.salidaVehiculo(coche1, LocalDateTime.of(2023, 3, 19, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		*/
		
		
		parking.entradaVehiculo(furgoneta1, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(furgoneta2, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(furgoneta3, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(furgoneta4, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());
	
		parking.entradaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 8, 30));
		// System.out.println(parking.getNumeroPlazasLibres());
		
		
		
		parking.salidaVehiculo(furgoneta1, LocalDateTime.of(2023, 3, 19, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.salidaVehiculo(furgoneta2, LocalDateTime.of(2023, 3, 19, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.salidaVehiculo(furgoneta3, LocalDateTime.of(2023, 3, 19, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.salidaVehiculo(furgoneta4, LocalDateTime.of(2023, 3, 19, 10, 30));
		System.out.println(parking.getNumeroPlazasLibres());
	
		
		parking.salidaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 14, 30));
		System.out.println(parking.getNumeroPlazasLibres());
		
		parking.entradaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 16, 30));
		parking.salidaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 18, 30));
		parking.entradaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 19, 30));
		parking.salidaVehiculo(furgoneta5, LocalDateTime.of(2023, 3, 19, 21, 30));
		
		parking.entradaVehiculo(coche1, LocalDateTime.of(2023, 3, 19, 8, 30));
		System.out.println(parking.getNumeroPlazasLibres());

		
		parking.getFicheroResumenPrintWriter(fechaReferencia);
		
		/*
		HashSet<Vehiculo> lista = parking.getRegistroVehiculos();
		for (Vehiculo vehiculo:lista) {
			System.out.println(vehiculo);
		}
		*/


	}

}
