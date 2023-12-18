package gestioncarrera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import excepciones.GestionCarreraException;

public class GestionCarrera {
	
	
	private final static int NUM_CARRERAS_GEN_INT = 5;
	private final static int NUM_EQUIPOS_CARRERAS_GEN_INT = 5;
	private ArrayList<Carrera> listaCarreras;
	private ArrayList<Equipo> listaEquipos;
	
	
	public GestionCarrera() {
		this.listaCarreras = new ArrayList<>();
		this.listaEquipos = new ArrayList<>();
	}

	// Método para añadir CARRERA al sistema
	public void addCarrera(Carrera carrera) throws GestionCarreraException {
		if (this.getListaCarreras().contains(carrera)) {
			throw new GestionCarreraException("ERROR: La carrera ya se encuentra registrada en sistema!");
		}
		else {
			this.getListaCarreras().add(carrera);
		}
	}
	
	// Método para eliminar CARRERA al sistema
	public void removeCarrera(String nombreCarrera) throws GestionCarreraException {
		if (this.getCarrera(nombreCarrera) == null) {
			throw new GestionCarreraException("ERROR: La carrera no se encuentra registrada en el sistema!");
		}
		else {
			this.getListaCarreras().remove(this.getCarrera(nombreCarrera));
		}
	}
	
	// Método para añadir EQUIPO al sistema
	public void addEquipo(Equipo equipo) throws GestionCarreraException {
		if (this.getListaEquipos().contains(equipo)) {
			throw new GestionCarreraException("ERROR: El equipo ya se encuentra registrado en sistema!");
		}
		else {
			this.getListaEquipos().add(equipo);
		}
	}
	
	// Método para eliminar EQUIPO al sistema
	public void removeEquipo(String codigoEquipo) throws GestionCarreraException {
		if (this.getEquipo(codigoEquipo) == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrada en el sistema!");
		}
		else {
			this.getListaEquipos().remove(this.getEquipo(codigoEquipo));
		}
	}
	
	// Método para añadir un CORREDOR a un EQUIPO determinado
	public void addCorredorEquipo(String codigoEquipo, Participante participante) throws GestionCarreraException {
		Equipo equipo = this.getEquipo(codigoEquipo);
		if (equipo == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en el sistema!");
		}
		equipo.addCorredor(participante);
	}
	
	// Método para eliminar a un EQUIPO en una CARRERA determinada
	public void addEquipoCarrera(String nombreCarrera, String codigoEquipo) throws GestionCarreraException {
		 Carrera carrera = this.getCarrera(nombreCarrera);
		 Equipo equipo = this.getEquipo(codigoEquipo);
		 if (equipo == null) {
			 throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en el sistema!");
		 }
		 if (carrera == null) {
			 throw new GestionCarreraException("ERROR: La carrera no seregistrada en el sistema!");
		 }
		 carrera.addEquipo(equipo);
	}
	
	// Método para eliminar a un EQUIPO en una CARRERA determinada
	public void removeEquipoCarrera(String nombreCarrera, String codigoEquipo) throws GestionCarreraException {
		Carrera carrera = this.getCarrera(nombreCarrera);
		Equipo equipo = this.getEquipo(codigoEquipo);
		if (equipo == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en el sistema!");
		}
		if (carrera == null) {
			throw new GestionCarreraException("ERROR: La carrera no seregistrada en el sistema!");
		}
		carrera.eliminarEquipo(codigoEquipo);
	}
	
	// Método para añadir premio a un EQUIPO en una CARRERA determinada
	public void addPremioEquipoCarrera(String nombreCarrera, String codigoEquipo, int posicion) throws GestionCarreraException {	
		Carrera carrera = this.getCarrera(nombreCarrera);
		Equipo equipo = this.getEquipo(codigoEquipo);
		if (equipo == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en el sistema!");
		}
		if (carrera == null) {
			throw new GestionCarreraException("ERROR: La carrera no se encuentra registrada en el sistema!");
		}
		carrera.addEquipoPodium(posicion, equipo);
	}
	
	// Método para combinar dos EQUIPOS por SEXO (HOMBRE) y CATEGORIA (SENIOR) usando funcionalidades STREAM
	public List<Participante> combinarEquipoPorSexoCategoria(Equipo equipo1, Equipo equipo2) {
		Predicate<Participante> p1 = (p) -> p.getSexo() == tipoSexo.HOMBRE;
		Predicate<Participante> p2 = (p) -> p.getCategoria() == tipoParticipante.SENIOR;
		Predicate<Participante> pf = p1.and(p2);
		List<Participante> listaCombinada = Stream.concat(equipo1.getPlantilla().stream(), equipo2.getPlantilla().stream())
				  .collect(Collectors.toList())
				  .stream()
				  .filter(pf)
				  .collect(Collectors.toList());
		return listaCombinada;
	}
	
	// Método para mostrar EQUIPOS
	public void mostrarEquipos() {
		System.out.println("LISTADO EQUIPOS: ");
		this.getListaEquipos().forEach(equipo -> System.out.println("Nombre: " + equipo.getNombre() + " - Código: " + equipo.getCodigo()));
		System.out.println("************************************************************************");
	}
	
	// Método para mostrar CARRERAS
	public void mostrarCarreras() {
		System.out.println("LISTADO CARRERAS: ");
		this.getListaCarreras().forEach(carrera -> System.out.println("Nombre: " + carrera.getNombre() + " - Fecha: " + carrera.getFecha() + " - Km: " + carrera.getKm()));
		System.out.println("************************************************************************");
	}
	
	// Método para mostrar los CORREDORES de un EQUIPO
	public void mostrarCorredoresEquipo(String codigoEquipo) throws GestionCarreraException {
		Equipo equipo = this.getEquipo(codigoEquipo);
		if (equipo == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en el sistema!");
		}
		equipo.mostrarParticipantes();
	}
	
	// Método para mostrar los EQUIPOS de una CARRERA
	public void mostrarEquiposCarrera(String nombreCarrera) throws GestionCarreraException {
		Carrera carrera = this.getCarrera(nombreCarrera);
		if (carrera == null) {
			throw new GestionCarreraException("ERROR: La carrera no seregistrada en el sistema!");
		}
		carrera.mostrarNombreCodigoEquipos();
	}
	
	// Método para mostrar todas las CARRERAS y sus EQUIPOS
	public void mostrarEquiposCarreras() {
		System.out.println("LISTADO CARRERAS: ");
		for (Carrera carrera: this.getListaCarreras()) {
			System.out.print("Nombre: " + carrera.getNombre() + " - Fecha: " + carrera.getFecha() + " - Km: " + carrera.getKm());
			System.out.print(" - Primer Clasificado: " + ((carrera.getClasificacion().get(1) == null)?null:carrera.getClasificacion().get(1).getCodigo()));
			System.out.print(" - Segundo Clasificado: " + ((carrera.getClasificacion().get(2) == null)?null:carrera.getClasificacion().get(2).getCodigo()));
			System.out.print(" - Tercer Clasificado: " + ((carrera.getClasificacion().get(3) == null)?null:carrera.getClasificacion().get(3).getCodigo()) + "\n");
			carrera.mostrarNombreCodigoEquipos();
		}
	}
	
	// Método para generar internamente EQUIPOS - CORREDORES - CARRERAS
	public void generarCarrerasEquipos() throws GestionCarreraException {	
		// Generamos Equipos Funcionalidades Stream
		for (int i=0; i<NUM_EQUIPOS_CARRERAS_GEN_INT-3; i++) {
			Equipo equipo = new Equipo("EQ_ST_" + (i+1),"Equipo_Stream_" + (i+1));
			for (int j=0; j<Equipo.NUM_MIEMBROS_EQUIPO; j++) {
				if (j<Equipo.NUM_MIEMBROS_EQUIPO-2) {
					equipo.addCorredor(new Participante("C" + (j+1) + "_E_ST" + (i+1), "NombreC" + (j+1) + "_E_ST" + (i+1), "ApellidosC" + (j+1) + "_E_ST" + (i+1), new Random().nextInt(0, 2), new Random().nextInt(1, 31)));
				}
				else {
					equipo.addCorredor(new Participante("C" + (j+1) + "_E_ST" + (i+1), "NombreC" + (j+1) + "_E_ST" + (i+1), "ApellidosC" + (j+1) + "_E_ST" + (i+1), 0, new Random().nextInt(19, 31)));
				}	
			}
			equipo.setCapitan("C1_E_ST" + (i+1));
			this.addEquipo(equipo);
		}
		// Generamos Equipos Random
		for (int i=0; i<NUM_EQUIPOS_CARRERAS_GEN_INT; i++) {
			Equipo equipo = new Equipo("EQ_" + (i+1),"Equipo_" + (i+1));
			for (int j=0; j<Equipo.NUM_MIEMBROS_EQUIPO-2; j++) {
				equipo.addCorredor(new Participante("C" + (j+1) + "_E" + (i+1), "NombreC" + (j+1) + "_E" + (i+1), "ApellidosC" + (j+1) + "_E" + (i+1), new Random().nextInt(0, 2), new Random().nextInt(1, 31)));
			}
			equipo.setCapitan("C1_E" + (i+1));
			this.addEquipo(equipo);
		}
		// Generamos Carreras
		for (int q=0; q<NUM_CARRERAS_GEN_INT; q++) {
			this.addCarrera(new Carrera("Carrera_" + (q+1), LocalDate.of(new Random().nextInt(2010, 2024), new Random().nextInt(3, 13), new Random().nextInt(1,31)), new Random().nextInt(20, 43), Carrera.DEFAULT_PUNTOS_PRIMER_CLASIFICADO, Carrera.DEFAULT_PUNTOS_SEGUNDO_CLASIFICADO, Carrera.DEFAULT_PUNTOS_TERCER_CLASIFICADO));
			for (int i=0; i<NUM_EQUIPOS_CARRERAS_GEN_INT-2; i++) {
				this.addEquipoCarrera("Carrera_" + (q+1), "EQ_" + (i+1));
			}
		}
	}
	
	// GETTERS
	public Carrera getCarrera(String nombreCarrera) {
		Iterator<Carrera> iterator = this.getListaCarreras().iterator();
		while (iterator.hasNext()) {
			Carrera carrera = iterator.next();
			if (carrera.getNombre().equals(nombreCarrera)) {
				return carrera;
			}
		}
		return null;
	}
	
	public Equipo getEquipo(String codigoEquipo) {
		Iterator<Equipo> iterator = this.getListaEquipos().iterator();
		while (iterator.hasNext()) {
			Equipo equipo = iterator.next();
			if (equipo.getCodigo().equals(codigoEquipo)) {
				return equipo;
			}
		}
		return null;
	}
	
	private ArrayList<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	private ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}	
	

}
