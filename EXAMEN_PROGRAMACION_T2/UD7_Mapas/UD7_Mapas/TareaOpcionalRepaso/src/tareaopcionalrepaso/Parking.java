package tareaopcionalrepaso;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

public class Parking {
	
	public final static int NUM_MAX_PLAZAS=10;
	private int numPlazasOcupadas;
	private LinkedList<Vehiculo> registroVehiculos;
	
	public Parking() {
		this.numPlazasOcupadas=0;
		this.registroVehiculos = new LinkedList<>();
	}
	
	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}
	
	public LinkedList<Vehiculo> getRegistroVehiculos() {
		return registroVehiculos;
	}
	
	public int getNumeroPlazasLibres() {
		return NUM_MAX_PLAZAS - this.getNumPlazasOcupadas();
	}
	
	
	public void entradaVehiculo(Vehiculo vehiculo, LocalDate horaEntrada) throws Exception {
		if (vehiculo.getInParking()) {
			throw new Exception("ERROR: El vehículo ya se encuentra en el parking!");
		}
		if (this.getNumPlazasOcupadas() == NUM_MAX_PLAZAS) {
			throw new Exception("ERROR: El Parking se encuentra a su máxima capacidad!");
		}
		if (vehiculo instanceof Furgoneta &&  (this.numPlazasOcupadas+2) > NUM_MAX_PLAZAS) {
			throw new Exception("ERROR: No existen plazas sufucientes para la furgoneta! Recuerde que ocupa dos lugares!");
		}
		if (vehiculo instanceof Coche) {
			this.numPlazasOcupadas +=1;
		}
		if (vehiculo instanceof Furgoneta) {
			this.numPlazasOcupadas +=2;
		}
		vehiculo.setHoraEntrada(horaEntrada);
		vehiculo.setInParking(true);
		this.getRegistroVehiculos().add(vehiculo);
		System.out.println("El vehículo ha ingresado al parking a las " + horaEntrada);
	}
	
	
	public void salidaVehiculo(Vehiculo vehiculo, LocalDate horaSalida) throws Exception {
		Vehiculo vehiculoParking = this.getVehiculoFromResgistro(vehiculo.getMatricula());
		if (!vehiculoParking.getInParking()) {
			throw new Exception("ERROR: El vehículo no se encuentra en el parking!");
		}
		if (vehiculoParking.getHoraEntrada().isAfter(horaSalida)) {
			throw new Exception("ERROR: La hora de salida del vehículo debe ser posterior a la de entrada!");
		}
		if (vehiculo instanceof Coche) {
			this.numPlazasOcupadas -=1;
		}
		if (vehiculo instanceof Furgoneta) {
			this.numPlazasOcupadas -=2;
		}
		vehiculoParking.setHoraSalida(horaSalida);
		vehiculoParking.setInParking(false);
		// vehiculoParking.setFacturacion(vehiculoParking.getFacturacion()+1.5*horas);
		System.out.println("El vehículo ha salido del parking a las " + horaSalida);
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
	
	
	
	/*
	private HashMap<String,Vehiculo> vehiculosAparcados;
	
	public Parking() {
		this.numPlazasOcupadas=0;
		this.registroVehiculos = new ArrayList<>();
	}
	
	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}
	
	public ArrayList<Vehiculo> getRegistroVehiculos() {
		return registroVehiculos;
	}
	
	public HashMap<String, Vehiculo> getVehiculosAparcados() {
		return vehiculosAparcados;
	}
	
	public void setNumPlazasOcupadas(int numPlazasOcupadas) {
		this.numPlazasOcupadas = numPlazasOcupadas;
	}

	
	public void entradaVehiculo(Vehiculo vehiculo, LocalDate horaEntrada) throws Exception {
		if (this.getVehiculoFromParking(vehiculo.getMatricula()) !=null) {
			throw new Exception("ERROR: El vehículo ya se encuentra en el parking!");
		}
		if (this.getNumPlazasOcupadas() == NUM_MAX_PLAZAS) {
			throw new Exception("ERROR: El Parking se encuentra a su máxima capacidad!");
		}
		if (vehiculo instanceof Furgoneta &&  (this.numPlazasOcupadas +=2) > NUM_MAX_PLAZAS) {
			throw new Exception("ERROR: No existen plazas sufucientes para la furgoneta! Recuerde que ocupa dos lugares!");
		}
		if (vehiculo instanceof Coche) {
			this.numPlazasOcupadas +=1;
		}
		if (vehiculo instanceof Furgoneta) {
			this.numPlazasOcupadas +=2;
		}
		vehiculo.setHoraEntrada(horaEntrada);
		this.getVehiculosAparcados().put(vehiculo.getMatricula(), vehiculo);
		this.getRegistroVehiculos().add(vehiculo);
	}
	
	public void salidaVehiculo(Vehiculo vehiculo, LocalDate horaSalida) throws Exception {
		Vehiculo vehiculoParking = this.getVehiculoFromParking(vehiculo.getMatricula());
		if (vehiculoParking == null) {
			throw new Exception("ERROR: El vehículo no se encuentra en el parking!");
		}
		if (vehiculoParking.getHoraEntrada().isAfter(horaSalida)) {
			throw new Exception("ERROR: La hora de salida del vehículo debe ser posterior a la de entrada!");
		}
		if (vehiculo instanceof Coche) {
			this.numPlazasOcupadas -=1;
		}
		if (vehiculo instanceof Furgoneta) {
			this.numPlazasOcupadas -=2;
		}
		vehiculoParking.setHoraSalida(horaSalida);
		this.getVehiculosAparcados().remove(vehiculoParking.getMatricula());

	}
	
	
	public Vehiculo getVehiculoFromParking(String matricula) {
		return this.getVehiculosAparcados().get(matricula);
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
	*/
}
