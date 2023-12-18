package gestioncarrera;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;


import excepciones.GestionCarreraException;
import utilidades.ConexionBaseDatos;


public class Carrera {
	
	public final static int DEFAULT_PUNTOS_PRIMER_CLASIFICADO = 25;
	public final static int DEFAULT_PUNTOS_SEGUNDO_CLASIFICADO = 20;
	public final static int DEFAULT_PUNTOS_TERCER_CLASIFICADO = 16;
	
	private String nombre;
	private LocalDate fecha;
	private double km;
	private ArrayList<Equipo> equipos;
	private HashMap<Integer,Equipo> clasificacion;
	private int puntosPrimerClasificado;
	private int puntosSegundoClasificado;
	private int puntosTercerClasificado;
	
	
	public Carrera(String nombre, LocalDate fecha, double km, int puntosPrimerClasificado, int puntosSegundoClasificado, int puntosTercerClasificado) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.km = km;
		this.puntosPrimerClasificado = puntosPrimerClasificado;
		this.puntosSegundoClasificado = puntosSegundoClasificado;
		this.puntosTercerClasificado = puntosTercerClasificado;
		this.equipos = new ArrayList<>();
		this.clasificacion = new HashMap<>();
	}
	
	// Método para añadir EQUIPOS al podium de la carrera
	public void addPodium(String codigoEquipo1, String codigoEquipo2, String codigoEquipo3) throws GestionCarreraException {
		Equipo equipo1 = this.getEquipo(codigoEquipo1);
		Equipo equipo2 = this.getEquipo(codigoEquipo2);
		Equipo equipo3 = this.getEquipo(codigoEquipo3);
		if (equipo1 == null || equipo2 == null || equipo3 == null) {
			throw new GestionCarreraException("ERROR: Los equipos no se encuentran registrados en la carrera!");
		}
		else if (equipo1.equals(equipo2) || equipo1.equals(equipo3) || equipo2.equals(equipo3)) {
			throw new GestionCarreraException("ERROR: No puede asignar más de un premio a un equipo!");
		}
		else {
			// Añadimos equipos podium y puntos
			this.getClasificacion().put(1, equipo1);
			equipo1.addPuntosEquipo(this.getPuntosPrimerClasificado());
			this.getClasificacion().put(2, equipo2);
			equipo2.addPuntosEquipo(this.getPuntosSegundoClasificado());
			this.getClasificacion().put(3, equipo3);
			equipo3.addPuntosEquipo(this.getPuntosTercerClasificado());
		}
	}

	// Método para añadir EQUIPO a una posición del Podium
	public void addEquipoPodium(int posicion, String codigoEquipo) throws GestionCarreraException {
		Equipo equipo = this.getEquipo(codigoEquipo);
		if (posicion < 1 || posicion > 4) {
			throw new GestionCarreraException("ERROR: Sólo se puden asignar premio a los tres primeros equipos!");
		}
		else if (equipo == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en la carrera!");
		}
		else if (this.equipoEnPodium(codigoEquipo)) {
			throw new GestionCarreraException("ERROR: El equipo ya se encuentra registrado en el podium!");
		}
		else if (this.getClasificacion().get(posicion) != null) {
			throw new GestionCarreraException("ERROR: Ya se ha asignado un equipo para la " + posicion + "ª posición!");
		}
		else {
			// Añadimos equipo a la posición del podium
			this.getClasificacion().put(posicion, equipo);
			// Añadimos puntos equipo
			this.addPuntosEquipo(equipo, posicion);
		}
	}
	
	// Sobrecarga del Método anterior
	public void addEquipoPodium(int posicion, Equipo equipo) throws GestionCarreraException {
		if (posicion < 1 || posicion > 4) {
			throw new GestionCarreraException("ERROR: Sólo se puden asignar premio a los tres primeros equipos!");
		}
		else if (!(this.getEquipos().contains(equipo))) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en la carrera!");
		}
		else if (this.equipoEnPodium(equipo)) {
			throw new GestionCarreraException("ERROR: El equipo ya se encuentra registrado en el podium!");
		}
		else if (this.getClasificacion().get(posicion) != null) {
			throw new GestionCarreraException("ERROR: Ya se ha asignado un equipo para la " + posicion + "ª posición!");
		}
		else {
			// Añadimos equipo a la posición del podium
			this.getClasificacion().put(posicion, equipo);
			// Añadimos puntos equipo
			this.addPuntosEquipo(equipo, posicion);
		}
	}
	
	// Método para añadir puntos al EQUIPO según su posición
	private void addPuntosEquipo(Equipo equipo, int posicion) {
		if (posicion == 1) {
			equipo.addPuntosEquipo(this.getPuntosPrimerClasificado());
		}
		else if (posicion == 2) {
			equipo.addPuntosEquipo(this.getPuntosSegundoClasificado());
		}
		else {
			equipo.addPuntosEquipo(this.getPuntosTercerClasificado());
		}
	}
	
	// Método para añadir EQUIPO a la CARRERA
	public void addEquipo(Equipo equipo) throws GestionCarreraException {
		if (this.getEquipos().contains(equipo)) {
			throw new GestionCarreraException("ERROR: El equipo ya se encuentra registrado en la carrera!");
		}
		else {
			this.getEquipos().add(equipo);
		}
	}
	
	// Método para eliminar EQUIPO de la CARRERA
	public void eliminarEquipo(String codigoEquipo) throws GestionCarreraException {
		if (this.getEquipo(codigoEquipo) == null) {
			throw new GestionCarreraException("ERROR: El equipo no se encuentra registrado en la carrera!");
		}
		else {
			this.getEquipos().remove(this.getEquipo(codigoEquipo));
		}
	}
	
	// Método para comprobar si el equipo se encuentra en el PODIUM
	public boolean equipoEnPodium(String codigoEquipo) {
		Iterator<Integer> iterator = this.getClasificacion().keySet().iterator();
		while (iterator.hasNext()) {
			int pos = iterator.next();
			Equipo equipo = this.getClasificacion().get(pos);
			if (equipo.getCodigo().equals(codigoEquipo)) {
				return true;
			}
		}
		return false;
	}
	
	// Sobrecarga del método anterior
	public boolean equipoEnPodium(Equipo equipo) {
		Iterator<Integer> iterator = this.getClasificacion().keySet().iterator();
		while (iterator.hasNext()) {
			int pos = iterator.next();
			Equipo equipoPodium = this.getClasificacion().get(pos);
			if (equipoPodium.equals(equipo)) {
				return true;
			}
		}
		return false;
	}
	
	// Método obtener participantes carrera
	public int getNumParticipantes() {
		int numParticipantes=0;
		for (Equipo equipo: this.getEquipos()) {
			numParticipantes += equipo.getNumParticipantes();
		}
		return numParticipantes;
	}

	// Método para obtener el equipo con más puntos acumulados de la carrera usando stream
	public Equipo getEquipoMasPuntosV3() throws GestionCarreraException {
		Optional<Equipo> equipOptional = this.getEquipos().stream().max((e1, e2) -> Integer.compare(e1.getPuntosAcumulados(), e2.getPuntosAcumulados()));
		if (equipOptional.isPresent()) {
			return equipOptional.get();
		}
		else {
			throw new GestionCarreraException("ERROR: No existen equipos registrados en la carrera!");
		}
	}
	
	// Método para volcar datos resumen base datos
	public void guardarBaseDatos(Connection connection) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.INSERT_CARRERA)) {
			preparedStatement.setString(1, this.getNombre());
			try {
				preparedStatement.setString(2, this.getEquipoMasPuntosV3().getNombre());
			}
			catch (GestionCarreraException e) {
				preparedStatement.setString(2, null);
				System.out.println(e.getMessage());
			}
			preparedStatement.setInt(3, this.getNumParticipantes());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			preparedStatement.executeUpdate();
			System.out.println("Datos de la carrera con nombre " + this.getNombre() + " introducidos correctamente en la base de datos!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método para mostrar EQUIPOS (toString()) de la CARRERA
	public void mostrarEquipos() {
		System.out.println("LISTADO EQUIPOS CARRERA " + this.getNombre() + ":");
		this.getEquipos().forEach(equipo -> System.out.println(equipo.toString()));
		System.out.println("************************************************************************");
	}
	
	// Método para mostrar las características principales de los EQUIPOS de la CARRERA
	public void mostrarNombreCodigoEquipos() {
		System.out.println("LISTADO EQUIPOS CARRERA " + this.getNombre() + ":");
		this.getEquipos().forEach(equipo -> System.out.println("Nombre Equipo: " + equipo.getNombre() + " - Código Equipo: " + equipo.getCodigo() + " - Puntos Acumulados: " + equipo.getPuntosAcumulados()));
		System.out.println("************************************************************************");
	}
	
	// GETTERS
	public Equipo getEquipo(String codigoEquipo) {
		Iterator<Equipo> iterator = this.getEquipos().iterator();
		while (iterator.hasNext()) {
			Equipo equipo = iterator.next();
			if (equipo.getCodigo().equals(codigoEquipo)) {
				return equipo;
			}
		}
		return null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public double getKm() {
		return km;
	}
	
	public int getPuntosPrimerClasificado() {
		return puntosPrimerClasificado;
	}
	
	public int getPuntosSegundoClasificado() {
		return puntosSegundoClasificado;
	}
	
	public int getPuntosTercerClasificado() {
		return puntosTercerClasificado;
	}
	
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public HashMap<Integer, Equipo> getClasificacion() {
		return clasificacion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Equipo)) {
			return false;
		}
		Equipo other = (Equipo) obj;
		if (other.getNombre().equals(this.getNombre())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getNombre());
	}
	
}
