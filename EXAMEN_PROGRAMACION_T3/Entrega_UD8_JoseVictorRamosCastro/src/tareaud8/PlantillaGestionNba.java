package tareaud8;

public interface PlantillaGestionNba {
	
	public boolean anadirEquipo(Equipo equipo);
	
	public void mostrarEquipos();
	
	public void guardarEquipoDisco(String nombreEquipo, String nombreFichero);
	
	public void anadirEquiposConferencias();
	
	public void anadirJugadorEquipo(String nombreEquipo, Jugador jugador) throws NbaException;
	
	public void mostrarInfoEquipo(String nombreEquipo) throws NbaException;
	
	public void mostrarInfoEquiposFichero(String pathFichero);

}
