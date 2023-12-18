package tareaud8;

public class Veterano extends Jugador {
	
	private static final long serialVersionUID = 1L;
	private double salario;
	private int anosExperiencia;
	private Equipo ultimoEquipo;
	
	public Veterano(String nombre, int dorsal, double salario, int anosExperiencia, Equipo ultimoEquipo) throws NbaException {
		super(nombre,dorsal);
		if (salario < 0) {
			throw new NbaException("ERROR: El salario del jugador no puede ser menor que cero!");
		}
		else {
			this.salario = salario;
		}
		if (anosExperiencia <0 ) {
			throw new NbaException("ERROR: Los años de experiencia de un jugador no pueden ser menor que cero!");
		}
		else {
			this.anosExperiencia = anosExperiencia;
		}
		this.ultimoEquipo = ultimoEquipo;
	}
	
	// Getters
	
	@Override
	public double getSalario() {
		return this.salario;
	}

	public Equipo getUltimoEquipo() {
		return ultimoEquipo;
	}
	
	public int getAnosExperiencia() {
		return anosExperiencia;
	}
	
	@Override
	public String toString() {
		return String.format("Nombre: %s - Dorsal: %s - Salario ($): %.2f - Años Experiencia: %d - Último Equipo: %s", this.getNombre(),this.getDorsal(),this.getSalario(),this.getAnosExperiencia(),this.getUltimoEquipo().getNombre());
	}

}
