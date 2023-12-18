package repasoTareaUD10;

import java.util.ArrayList;
import java.util.Objects;



public class Equipo {
	
	
	private String codigo;
	private String nombre;
	private Participante capitan;
	private ArrayList<Participante> plantilla;
	
	
	public Equipo(String codigo, String nombre, ArrayList<Participante> plantilla) {	
		this.codigo = codigo;
		this.nombre = nombre;
		this.plantilla = plantilla;
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
	
	// GETTERS - SETTERS

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


}
