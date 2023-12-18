package tareaopcionalrepasoV3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;



public class Parking {
	
	public final static int NUM_MAX_PLAZAS=10;
	public final static double PRECIO_HORA_PARKING = 1.5;
	private int numPlazasOcupadas;
	private HashSet<Estacionamiento> registroEstacionamietos;
	private HashSet<Vehiculo> registoVehiculos;
	
	public Parking() {
		this.numPlazasOcupadas = 0;
		this.registroEstacionamietos = new HashSet<>();
		this.registoVehiculos = new HashSet<>();
	}
	
	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}
	
	public HashSet<Vehiculo> getRegistoVehiculos() {
		return registoVehiculos;
	}
	
	public HashSet<Estacionamiento> getRegistroEstacionamietos() {
		return registroEstacionamietos;
	}
	
	public void entradaVehiculo(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
		
		if(this.estacionadoEnParking(vehiculo)) {
			System.out.println("ERROR: El vehículo ya se encuentra actualmente estacionado!");
			return;
		}
		if (this.getNumPlazasOcupadas() == NUM_MAX_PLAZAS) {
			System.out.println("ERROR: El Parking se encuentra a su máxima capacidad!");
			return;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta &&  (this.numPlazasOcupadas+2) > NUM_MAX_PLAZAS) {
			System.out.println("ERROR: No existen plazas sufucientes para la furgoneta! Recuerde que ocupa dos lugares!");
			return;
		}
		// El Vehículo puede entrar al parking
		if (vehiculo.getTipo() == tipoVehiculo.coche) {
			this.numPlazasOcupadas += 1;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta) {
			this.numPlazasOcupadas += 2;
		}
		this.getRegistroEstacionamietos().add(new Estacionamiento(vehiculo, fechaEntrada));
		this.getRegistoVehiculos().add(vehiculo);
		System.out.println("El vehículo ha ingresado al parking a las " + fechaEntrada);
	}
	
	
	public void salidaVehiculo(Vehiculo vehiculo, LocalDateTime fechaSalida) {
		Estacionamiento estacionamiento = this.getEstacionamientoSalida(vehiculo);
		if (estacionamiento == null) {
			System.out.println("ERROR: El vehículo no se encuentra actualmente estacionado!");
			return;
		}
		if (estacionamiento.getFechaEntrada().isAfter(fechaSalida)) {
			System.out.println("ERROR: La fecha de salida del vehículo no puede ser anterior a la de entrada!");
			return;
		}
		// El vehiculo puede salir del parking
		if (vehiculo.getTipo() == tipoVehiculo.coche) {
			this.numPlazasOcupadas -= 1;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta) {
			this.numPlazasOcupadas -= 2;
		}
		estacionamiento.setFechaSalida(fechaSalida);
		estacionamiento.setFacturacion();
		System.out.println("El vehículo ha ingresado al parking a las " + fechaSalida);
	}	
	
	public int getNumeroPlazasLibres() {
		return Parking.NUM_MAX_PLAZAS-this.getNumPlazasOcupadas();
	}
	
	
	public void mostrarEstacionamientosParking(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		double facturacionPeriodo = 0;
		System.out.println("*** REGISTRO DE ESTACIONAMIENTOS ENTRTE " + fechaInicial + " y " + fechaFinal);
		Iterator<Estacionamiento> iterator = this.getRegistroEstacionamietos().iterator();
		while(iterator.hasNext()) {
			Estacionamiento estacionamiento = iterator.next();
			System.out.println(estacionamiento.getVehiculo().toString() + " -  " + estacionamiento.toString());
			facturacionPeriodo += estacionamiento.getFacturacion();
		}
		System.out.println("Facturación total del peirodo: " + facturacionPeriodo + " €");
	}
	
	
	public void getFicheroResumenPrintWriter(LocalDateTime fechaReferencia) {
		
		File file = new File("./FicheroParkingV2.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.println("***********************************************************");
			printWriter.println("*************** Facturación por Vehículo ******************");
			printWriter.println("***********************************************************");
			Iterator<Vehiculo> iteratorVehiculo = this.getRegistoVehiculos().iterator();
			double facturacionParking = 0;
			while(iteratorVehiculo.hasNext()) {
				Vehiculo vehiculo = iteratorVehiculo.next();
				boolean flagImprimirVehiculo = true;
				double facturacionVehiculo = 0;
				Iterator<Estacionamiento> iteratorEstacionamiento = this.getRegistroEstacionamietos().iterator();
				while(iteratorEstacionamiento.hasNext()) {
					Estacionamiento estacionamiento = iteratorEstacionamiento.next();	
					if (flagImprimirVehiculo && estacionamiento.getVehiculo().equals(vehiculo) &&  estacionamiento.getFechaEntrada().isAfter(fechaReferencia.minusHours(24))) {
						printWriter.println(vehiculo);
						flagImprimirVehiculo = false;
					}
					if (estacionamiento.getVehiculo().equals(vehiculo)  && estacionamiento.getFechaEntrada().isAfter(fechaReferencia.minusHours(24))) {
						printWriter.println("Fecha Entrada: " + estacionamiento.getFechaEntrada() + " - Fecha Salida: " + estacionamiento.getFechaSalida() + " - Facturacion: " + estacionamiento.getFacturacion() + " €");
						facturacionVehiculo += estacionamiento.getFacturacion();
					}
					
				}	
				printWriter.println("Facturación vehículo: " + facturacionVehiculo + " €");
				printWriter.println("***********************************************************");
				facturacionParking += facturacionVehiculo;
			}
			printWriter.println("Facturación últimas 24 horas: " + facturacionParking + " €");
			printWriter.println("***********************************************************");
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	// Método para comprobar si el vehículo se encuentra estacionado en el parking
	
	public boolean estacionadoEnParking(Vehiculo vehiculo) {
		Iterator<Estacionamiento> iterator = this.getRegistroEstacionamietos().iterator();
		while(iterator.hasNext()) {
			Estacionamiento estacionamiento = iterator.next();
			if(estacionamiento.getVehiculo().equals(vehiculo) && estacionamiento.getFechaSalida() == null) {
				return true;
			}
		}	
		return false;	
	}
	
	// Estaciamiento Salida
	
	public Estacionamiento getEstacionamientoSalida(Vehiculo vehiculo) {
		Iterator<Estacionamiento> iterator = this.getRegistroEstacionamietos().iterator();
		while(iterator.hasNext()) {
			Estacionamiento estacionamiento = iterator.next();
			if(estacionamiento.getVehiculo().equals(vehiculo) && estacionamiento.getFechaSalida() == null) {
				return estacionamiento;
			}
		}	
		return null;
		
		
	}

}
