package tareaud8;

public class Rookie extends Jugador {
	
	private static final long serialVersionUID = 1L;
	private int numDraft;
	private double salario;
	public final static double SALARIO_BASE=500000;
	
	public Rookie(String nombre, int dorsal, int numDraft) throws NbaException {
		super(nombre, dorsal);
		if (numDraft < 0) {
			throw new NbaException("ERROR: EL número del draft debe ser un número positivo");
		}
		else {
			this.numDraft = numDraft;
		}
		this.setSalario();
	}
	
	@Override
	public double getSalario() {
		return salario;
	}
	
	public int getNumDraft() {
		return numDraft;
	}
	
	public void setSalario() {
		this.salario = SALARIO_BASE/this.numDraft;
	}
	
	
	@Override
	public String toString() {
		return String.format("Nombre: %s - Dorsal: %s - Salario ($): %.2f - Número Draft: %d", this.getNombre(), this.getDorsal(), this.getSalario(), this.getNumDraft());
	}
	

}
