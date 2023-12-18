package ejercicio6;

public class Ordenador {
	
	// Variables de clase
	private String numeroDeSerie;
	private Procesador procesador;
	private DiscoDuro discoDuro;
	private Memoria memoria;
	private int pvp;
	public static int numOrdenadores=0;
	
	// int capacidadMemoria,String tipMemoria,int velocidadMemoria, float capacidadDisco, String tipoDisco, int velocidadDisco,String tipoProcesador, float velocidadProcesador, int precio
	
	//NumeroDeSerie,capacidadMemoria,tipMemoria,velocidadMemoria,capacidadDisco,tipoDisco,velocidadDisco,tipoProcesador,velocidadProcesador,precio
	
	public Ordenador(String numeroDeSerie, int capacidadMemoria, int velocidadMemoria, float capacidadDisco, String tipoDisco, int velocidadDisco, String tipoProcesador, float velocidadProcesador, int pvp) throws OrdenadorException {
		if (tipoProcesador.equalsIgnoreCase("I7") && !tipoDisco.equalsIgnoreCase("SATA3")) {
			throw new OrdenadorException(numeroDeSerie, " Procesador - " + tipoProcesador + " requiere un disco SATA3");
		}
		else if (numeroDeSerie.startsWith("HP") && capacidadMemoria < 4){
			throw new OrdenadorException(numeroDeSerie, " Un ordenador HP tiene que tener más de 4 GB de RAM ");
		}
		else {
		
			this.numeroDeSerie = numeroDeSerie;
			this.memoria = new Memoria(capacidadMemoria, velocidadMemoria);
			this.discoDuro = new DiscoDuro(capacidadDisco, tipoDisco, velocidadDisco);
			this.procesador = new Procesador(tipoProcesador, velocidadProcesador);
			this.pvp = pvp;
			numOrdenadores++;
		}
	}
	
	// Constructor por paso de parámetros
	public Ordenador(Procesador procesador, DiscoDuro discoDuro, Memoria memoria, int pvp) {
		this.procesador = procesador;
		this.discoDuro = discoDuro;
		this.memoria = memoria;
		this.pvp = pvp;
		numOrdenadores++;
	}
	
	// GETTERS
	
	public DiscoDuro getDiscoDuro() {
		return discoDuro;
	}
	
	public Memoria getMemoria() {
		return memoria;
	}
	
	public Procesador getProcesador() {
		return procesador;
	}
	
	public int getPvp() {
		return pvp;
	}
	
	// Método getCapacidadMemoria
	
	public int getCapacidadMemoria() {
		return this.memoria.getCapacidad();
	}
	
	// MostrarInfo
	public void mostrarInfo() {
		System.out.println("**** Características Ordenador" + numOrdenadores + " ****");
		System.out.println(this.getProcesador().toString());
		System.out.println(this.getDiscoDuro().toString());
		System.out.println(this.getMemoria().toString());
		System.out.println("PVP: " + this.getPvp());
		System.out.println("*********************************");
	}
}
