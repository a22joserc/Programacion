package tareaopcionalrepasoV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;


public class Parking {
	
	public final static int NUM_MAX_PLAZAS=10;
	private int numPlazasOcupadas;
	private HashSet<Vehiculo> registroVehiculos;
	
	public Parking() {
		this.numPlazasOcupadas=0;
		this.registroVehiculos = new HashSet<>();
	}
	
	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}
	
	public HashSet<Vehiculo> getRegistroVehiculos() {
		return registroVehiculos;
	}
	
	public int getNumeroPlazasLibres() {
		return NUM_MAX_PLAZAS - this.getNumPlazasOcupadas();
	}
	
	public boolean entradaVehiculo(Vehiculo vehiculo, LocalDateTime fechaEntrada) { // throws Exception {
		if (vehiculo.getInParking()) {
			// throw new Exception("ERROR: El vehículo ya se encuentra en el parking!");
			System.out.println("ERROR: El vehículo ya se encuentra en el parking!");
			return false;
		}
		if (this.getNumPlazasOcupadas() == NUM_MAX_PLAZAS) {
			// throw new Exception("ERROR: El Parking se encuentra a su máxima capacidad!");
			System.out.println("ERROR: El Parking se encuentra a su máxima capacidad!");
			return false;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta &&  (this.numPlazasOcupadas+2) > NUM_MAX_PLAZAS) {
			// throw new Exception("ERROR: No existen plazas sufucientes para la furgoneta! Recuerde que ocupa dos lugares!");
			System.out.println("ERROR: No existen plazas sufucientes para la furgoneta! Recuerde que ocupa dos lugares!");
			return false;
		}
		if (vehiculo.getTipo() == tipoVehiculo.coche) {
			this.numPlazasOcupadas +=1;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta) {
			this.numPlazasOcupadas +=2;
		}
		vehiculo.getListaEstacionamientos().add(new Estacionamiento(fechaEntrada));
		vehiculo.setInParking(true);
		this.getRegistroVehiculos().add(vehiculo);
		System.out.println("El vehículo ha ingresado al parking a las " + fechaEntrada);
		return true;
	}
	

	public boolean salidaVehiculo(Vehiculo vehiculo, LocalDateTime fechaSalida) { // throws Exception {
		Vehiculo vehiculoParking = this.getVehiculoFromResgistro(vehiculo.getMatricula());
		if (!vehiculoParking.getInParking()) {
			// throw new Exception("ERROR: El vehículo no se encuentra en el parking!");
			System.out.println("ERROR: El vehículo no se encuentra en el parking!");
			return false;
		}
		if (vehiculoParking.getEstacionamiento().getFechaEntrada().isAfter(fechaSalida)) {
			// throw new Exception("ERROR: La hora de salida del vehículo debe ser posterior a la de entrada!");
			System.out.println("ERROR: La hora de salida del vehículo debe ser posterior a la de entrada!");
			return false;
		}
		if (vehiculo.getTipo() == tipoVehiculo.coche) {
			this.numPlazasOcupadas -=1;
		}
		if (vehiculo.getTipo() == tipoVehiculo.furgoneta) {
			this.numPlazasOcupadas -=2;
		}
		vehiculoParking.getEstacionamiento().setFechaSalida(fechaSalida);
		vehiculoParking.setInParking(false);
		System.out.println("El vehículo ha salido del parking a las " + fechaSalida);
		return true;
	}
	
	
	public Vehiculo getVehiculoFromResgistro(String matricula) {
		Iterator<Vehiculo> iterator = this.getRegistroVehiculos().iterator();
		while (iterator.hasNext()) {
			Vehiculo vehiculo = iterator.next();
			if (vehiculo.getMatricula().equals(matricula)) {
				return vehiculo;
			}
		}
		return null;
	}
	
	public double getFacturacionParkingDiaPrevio(LocalDateTime fechaReferencia) {
		double facturacionParking = 0;
		Iterator<Vehiculo> iterator = this.getRegistroVehiculos().iterator();
		while (iterator.hasNext()) {
			Vehiculo vehiculo = iterator.next();
			facturacionParking += vehiculo.getFacturacionDiaPrevio(fechaReferencia);
		}
		return facturacionParking;
	}
	
	public void getFicheroResumenPrintWriter(LocalDateTime fechaReferencia) {
		
		File file = new File("./FicheroParking.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			Iterator<Vehiculo> iterator = this.getRegistroVehiculos().iterator();
			printWriter.println("***********************************************************");
			printWriter.println("***************** Resumen Facturación *********************");
			printWriter.println("***********************************************************");
			while (iterator.hasNext()) {
				Vehiculo vehiculo = iterator.next();
				printWriter.println(vehiculo);
				printWriter.println("Facturación vehículo: " + vehiculo.getFacturacionDiaPrevio(fechaReferencia));
				printWriter.println("***********************************************************");
			}
			printWriter.println("Facturación últimas 24 horas: " + this.getFacturacionParkingDiaPrevio(fechaReferencia) + " €");
			printWriter.println("***********************************************************");
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
