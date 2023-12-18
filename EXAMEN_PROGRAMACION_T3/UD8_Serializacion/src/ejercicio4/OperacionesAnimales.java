package ejercicio4;

public class OperacionesAnimales {
	
	private final static int NUM_MAX_PERROS = 5;
	private final static int NUM_MAX_GATOS = 5;
	private static int numPerros; 
	private static int numGatos; 
	private Animal[] animales;
	
	
	public OperacionesAnimales() {
		this.animales = new Animal[NUM_MAX_GATOS+NUM_MAX_PERROS];
		numPerros = 0;
		numGatos = 0;
	}
	
	public Animal[] getAnimales() {
		return animales;
	}
	
	public boolean addPerro(Perro perro) {
		if (numPerros == NUM_MAX_PERROS) {
			System.out.println("Ya ha alcanzado el límite máx de perros: " + NUM_MAX_PERROS + "!");
			return false;
		}
		for (int i=0; i < animales.length; i++) {
			if (animales[i] == null) {
				animales[i] = perro;
				numPerros++;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean addGato(Gato gato) {
		if (numGatos == NUM_MAX_GATOS) {
			System.out.println("Ya ha alcanzado el límite máx de gatos: " + NUM_MAX_GATOS + "!");
			return false;
		}
		for (int i=0; i < animales.length; i++) {
			if (animales[i] == null) {
				animales[i] = gato;
				numGatos++;
				return true;
			}
		}
		return false;
	}
	
	

}
