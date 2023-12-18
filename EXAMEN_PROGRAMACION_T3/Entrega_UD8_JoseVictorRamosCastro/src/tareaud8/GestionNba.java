package tareaud8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class GestionNba implements PlantillaGestionNba{
	
	private LinkedList<Equipo> listaEquipos;
	private TreeSet<Equipo> listaEquiposConferenciaEste;
	private TreeSet<Equipo> listaEquiposConferenciaOeste;
	
	public GestionNba() {
		this.listaEquipos = new LinkedList<>();
		this.listaEquiposConferenciaEste = new TreeSet<>(new EquipoComparator());
		this.listaEquiposConferenciaOeste = new TreeSet<>(new EquipoComparator());
	}
	
	// Getters
	public LinkedList<Equipo> getListaEquipos() {
		return listaEquipos;
	}
	
	public TreeSet<Equipo> getListaEquiposConferenciaEste() {
		return listaEquiposConferenciaEste;
	}
	
	public TreeSet<Equipo> getListaEquiposConferenciaOeste() {
		return listaEquiposConferenciaOeste;
	}
	
	
	// Método que añade equipos a la LinkedList devuelve un dato de tipo boolean
	@Override
	public boolean anadirEquipo(Equipo equipo) {
		// Controlamos que no se puedan añadir equipos con el mismo nombre
		Iterator<Equipo> iterator = this.getListaEquipos().iterator();
		while(iterator.hasNext()) {
			if (iterator.next().getNombre().equals(equipo.getNombre())) {
				return false;
			}
		}
		this.getListaEquipos().add(equipo);
		return true;
	}
	
	// Método que muestra por pantalla los equipos registrados en el sistema
	@Override
	public void mostrarEquipos() {
		Iterator<Equipo> iterator = this.getListaEquipos().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
	
	// Método para serializar un equipo
	@Override
	public void guardarEquipoDisco(String nombreEquipo, String nombreFichero) {
		Equipo equipo = this.getEquipo(nombreEquipo);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
			objectOutputStream.writeObject(equipo);
			System.out.println("El equipo " + nombreEquipo + " ha sido serializado en el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método para leer un equipo previamente serializado
	public void leerEquipoDisco(String nombreFichero) {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreFichero))) {
			Equipo equipo = (Equipo) objectInputStream.readObject();
			System.out.println(equipo.toString());
			equipo.mostrarPlantillaEquipo();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método para añadir equipos a las colecciones de la conferencia ESTE - OESTE
	@Override
	public void anadirEquiposConferencias() {
		Iterator<Equipo> iterator = this.getListaEquipos().iterator();
		while (iterator.hasNext()) {
			Equipo equipo = iterator.next();
			if (equipo.getConferencia() == tipoConferencia.ESTE) {
				this.getListaEquiposConferenciaEste().add(equipo);
			}
			else {
				this.getListaEquiposConferenciaOeste().add(equipo);
			}
		}
	}
	
	// Método para añadir jugadores a un equipo determinado
	@Override
	public void anadirJugadorEquipo(String nombreEquipo, Jugador jugador) throws NbaException {
		Equipo equipo = this.getEquipo(nombreEquipo);
		if (equipo == null) {
			throw new NbaException("ERROR: El equipo " + nombreEquipo + " no se encuentra registrado en el sistema");
		}
		equipo.anadirJugador(jugador);
	}
		
	// Método para mostrar la Masa Salarial y número de jugadores de un equipo
	@Override
	public void mostrarInfoEquipo(String nombreEquipo) throws NbaException {
		Equipo equipo = this.getEquipo(nombreEquipo);
		if (equipo == null) {
			throw new NbaException("ERROR: El equipo " + nombreEquipo + " no se encuentra registrado en el sistema");
		}
		equipo.mostrarMasaSalarialEquipo();
	}
	
	// Método para almacenar la información del los equipos en un fichero de texto
	@Override
	public void mostrarInfoEquiposFichero(String pathFichero) {
		File file = new File(pathFichero);
		try {
			PrintWriter printWriter = new PrintWriter(file);
			Iterator<Equipo> iterator = this.getListaEquipos().iterator();
			while (iterator.hasNext()) {
				Equipo equipo = iterator.next();
				printWriter.println(equipo);
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Método que devuelve un equipo a partir de su nombre
	public Equipo getEquipo(String nombreEquipo) {
		Iterator<Equipo> iterator = this.getListaEquipos().iterator();
		while (iterator.hasNext()) {
			Equipo equipo = iterator.next();
			if(equipo.getNombre().equals(nombreEquipo)) {
				return equipo;
			}
		}
		return null;
	}
	

}
