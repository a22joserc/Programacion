package gestioncarrera;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import excepciones.GestionCarreraException;

public class Equipo {
	
	
	public final static int NUM_MIEMBROS_EQUIPO=5;
	private int puntosAcumulados;
	private String codigo;
	private String nombre;
	private Participante capitan;
	private ArrayList<Participante> plantilla;
	private int numParticipantes;
	
	
	public Equipo(String codigo, String nombre) {	
		this.codigo = codigo;
		this.nombre = nombre;
		this.plantilla = new ArrayList<>();
		this.numParticipantes = 0;
		this.puntosAcumulados = 0;
	}
	
	public Equipo(String codigo, String nombre, ArrayList<Participante> plantilla, String codigoCapitan) throws GestionCarreraException {	
		this.codigo = codigo;
		this.nombre = nombre;
		this.numParticipantes = 0;
		this.setPlantilla(plantilla);
		this.setCapitan(codigoCapitan);
		this.puntosAcumulados = 0;
	}
	
	// Método para añadir CORREDOR a EQUIPO
	public void addCorredor(Participante participante) throws GestionCarreraException{
		if (this.getNumParticipantes() == NUM_MIEMBROS_EQUIPO) {
			throw new GestionCarreraException("ERROR: La plantilla del equipo ya cuenta con 5 corredores!");
		}
		else if(this.getPlantilla().contains(participante)) {
			throw new GestionCarreraException("ERROR: El corredor introducido ya se encuentra registrado en el equipo!");
		}
		else {
			this.getPlantilla().add(participante);
			this.numParticipantes++;
		}
	}
	
	// Método para fijar CAPITAN del EQUIPO
	public void setCapitan(String codigoCapitan) throws GestionCarreraException{
		if (this.getPlantilla().size()==0) {
			throw new GestionCarreraException("ERROR: Debe asignar corredores al equipo para poder definir un capitan!");
		}
		else if (this.getPartipantePorCodigo(codigoCapitan) == null) {
			throw new GestionCarreraException("ERROR: El códigoCorredor introducido no se corresponde con ningún miembro del equipo!");
		}
		else {
			this.capitan = this.getPartipantePorCodigo(codigoCapitan);
			// System.out.println("Se ha sido añadido como capitán a " + this.capitan.toString());
		}
		
	}
	
	// Método para añadir puntos EQUIPO 
	public void addPuntosEquipo(int puntos) {
		this.puntosAcumulados += puntos;
	}
	
	// Método para mostrar CORREDORES del EQUIPO
	public void mostrarParticipantes() {
		System.out.println("LISTADO CORREDORES EQUIPO " + this.getNombre() + " - Código: " + this.getCodigo());
		this.getPlantilla().forEach(participante -> System.out.println(participante.toString()));
		System.out.println("************************************************************************");
	}
	
	// Método para obtener CORREDOR de menor edad STREAM
	public Participante getCorredorMenorEdadStreamV2() throws GestionCarreraException {		
		Optional<Participante> participanteOptional = this.getPlantilla().stream().min((par1,par2) -> Integer.compare(par1.getEdad(), par2.getEdad()));
		if (participanteOptional.isPresent()) {
			return participanteOptional.get();
		}
		else {
			throw new GestionCarreraException("ERROR: Resultado el listado de jugadores del equipo esta vacio!");
		}
	}
	
	// Método para combinar apellidos CORREDORES del EQUIPO
	public String getStringApellidosEquipo() {		
		List<String> listaApellidos = this.getPlantilla()
												.stream()
												.map(p -> p.getApellidos())
												.collect(Collectors.toList());
		
		String apellidosString = listaApellidos.stream().collect(Collectors.joining("|"));
		return apellidosString;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Equipo)) {
			return false;
		}
		Equipo other = (Equipo) obj;
		if(other.getCodigo().equals(this.getCodigo())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getCodigo());
	}
	
	@Override
	public String toString() {
		String string = this.getNombre() + " - Código: " + this.getCodigo() +
						"\nPuntos Acumulados: " + this.getPuntosAcumulados() +
						"\nCapitán: " + this.getCapitan().toString() + 
						"\nCorredores:";
		for (Participante participante:this.getPlantilla()) {
			string = string.concat("\n" + participante.toString());
			
		}
		return string;
	}
	
	private void setPlantilla(ArrayList<Participante> plantilla) throws GestionCarreraException {		
		if (this.getPlantilla() != null) {
			throw new GestionCarreraException("ERROR: El equipo ya tiene una plantilla creada de " + this.getPlantilla().size() + " corredores. Debe añadir los jugadores uno a uno!");
		}
		if (plantilla.size() > NUM_MIEMBROS_EQUIPO) {
			throw new GestionCarreraException("ERROR: La plantilla del equipo no puede exceder los 5 corredores!");
		}
		else {
			this.plantilla = plantilla;
			this.numParticipantes += this.plantilla.size();
		}
	}
	
	
	// GETTERS SETTERS
	public Participante getPartipantePorCodigo(String codigoParticipante) {
		Iterator<Participante> iterator = this.getPlantilla().iterator();
		while (iterator.hasNext()) {
			Participante participante = iterator.next();
			if(participante.getCodigo().equalsIgnoreCase(codigoParticipante)) {
				return participante;
			}
		}
		return null;
	}
	
	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Participante getCapitan() {
		return capitan;
	}

	public ArrayList<Participante> getPlantilla() {
		return plantilla;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

}
