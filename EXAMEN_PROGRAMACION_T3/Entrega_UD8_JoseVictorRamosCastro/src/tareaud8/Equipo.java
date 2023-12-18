package tareaud8;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Equipo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public final static int NUM_MAX_ROOKIES = 3;
	public final static int NUM_MAX_JUGADORES = 15;
	private int numJugadores;
	private int numRookies;
	private String nombre;
	private String localidad;
	private tipoConferencia conferencia;
	private HashSet<Jugador> plantilla;
	
	public Equipo(String nombre, String localidad, tipoConferencia conferencia) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.conferencia = conferencia;
		this.plantilla = new HashSet<>();
		this.numJugadores = 0;
		this.numRookies = 0;
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public tipoConferencia getConferencia() {
		return conferencia;
	}
	
	public HashSet<Jugador> getPlantilla() {
		return plantilla;
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	
	public int getNumRookies() {
		return numRookies;
	}
	
	// Método para añadir jugdores al equipo. Retorna un dato de tipo boolean
	// Controla el número máximo de jugadores y rookies lanzando las excepciones correspondientes
	// También se controla con el tipo de colección HashSet que no se puedan registrar el mismo jugador varias veces en el equipo
	public boolean anadirJugador(Jugador jugador) throws NbaException {
		boolean flagJugador;
		if (this.getNumJugadores() == NUM_MAX_JUGADORES) {
			throw new NbaException("ERROR: El equipo ya cuenta con la plantilla completa 15 Jugadores");		
		}
		if (jugador instanceof Rookie && this.getNumRookies() == NUM_MAX_ROOKIES) {
			throw new NbaException("ERROR: El equipo ya cuenta con el máximo número de rookies (3)");
		}
		if (jugador instanceof Rookie) {
			flagJugador = this.getPlantilla().add(jugador);
			if (flagJugador) {
				this.numJugadores += 1;
				this.numRookies += 1;
			}
			return flagJugador;
		}
		else {	
			flagJugador = this.getPlantilla().add(jugador);
			if (flagJugador) {
				this.numJugadores +=1;
			}
			return flagJugador;
		}
		
	}
		
	// Método para calcular la masa salarial de los equipos
	public double getMasaSarial() {
		double masaSalarial = 0;
		Iterator<Jugador> iterator = this.getPlantilla().iterator();
		while (iterator.hasNext()) {
			masaSalarial += iterator.next().getSalario();
		}
		return masaSalarial;
	}
	
	// Método que muestra la masa salarial y el número de jugadores del equipo
	public void mostrarMasaSalarialEquipo() {
		 System.out.printf("%s - Masa Salarial ($): %.2f - Núm Jugadores : %d\n", this.getNombre(), this.getMasaSarial(), this.getNumJugadores());
	}
	
	// Método para comparar salarios de jugadores
	public void comparaJugadoresSalario(String nombreJugador1, String nombreJugador2) {
		if (this.getJugadorPorNombre(nombreJugador1) == null) {
			System.out.println("ERROR: El jugador " + nombreJugador1 + " no pertence a la plantilla de los " + this.getNombre());
		}
		else if (this.getJugadorPorNombre(nombreJugador2) == null) {
			System.out.println("ERROR: El jugador " + nombreJugador2 + " no pertence a la plantilla de los " + this.getNombre());
		}
		else if (this.getJugadorPorNombre(nombreJugador1).getSalario() > this.getJugadorPorNombre(nombreJugador2).getSalario()) {
			System.out.printf("El %s tiene un mayor salario (%.2f $) que %s (%.2f $)\n", nombreJugador1, this.getJugadorPorNombre(nombreJugador1).getSalario(), nombreJugador2, this.getJugadorPorNombre(nombreJugador2).getSalario());

		}
		else if (this.getJugadorPorNombre(nombreJugador1).getSalario() < this.getJugadorPorNombre(nombreJugador2).getSalario()) {
			System.out.printf("El %s tiene un mayor salario (%.2f $) que %s (%.2f $)\n", nombreJugador2, this.getJugadorPorNombre(nombreJugador2).getSalario(), nombreJugador1, this.getJugadorPorNombre(nombreJugador1).getSalario());
		}
		else {
			System.out.printf("Los jugadores %s y %s tienen el mismo salario (%.2f $)\n", nombreJugador1, nombreJugador2, this.getJugadorPorNombre(nombreJugador1).getSalario());
		}
	}
	
	// Método que retorna un objeto de tipo Jugador a partir de su nombre
	public Jugador getJugadorPorNombre(String nombreJugador) {
		Iterator<Jugador> iterator = this.getPlantilla().iterator();
		while(iterator.hasNext()) {
			Jugador jugador = iterator.next();
			if (jugador.getNombre().equals(nombreJugador)) {
				return jugador;
			}
		}
		return null;
	}
	
	// Método que muestra la plantilla de Jugadores de un equipo
	public void mostrarPlantillaEquipo() {
		System.out.println("Plantilla Equipo: ");
		Iterator<Jugador> iterator = this.getPlantilla().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
	
	// Criterio para diferenciar los objetos Equipo es el nombre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Equipo))
			return false;
		Equipo otro = (Equipo) obj;
		if (this.getNombre().equals(otro.getNombre())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " - Localidad: " + this.getLocalidad() + " - Conferencia: " + this.getConferencia();
	}
}
