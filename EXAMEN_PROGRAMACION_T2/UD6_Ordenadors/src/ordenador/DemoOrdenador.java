package ordenador;


public class DemoOrdenador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Memoria
		Memoria memoria1 = new Memoria(64, 1500);
		memoria1.mostrarInfo();
		Memoria memoria2 = new Memoria(0, 1500);
		memoria2.mostrarInfo();
		// Disco Duro
		DiscoDuro discoDuro1 = new DiscoDuro(2048f, "HDD", 3000);
		discoDuro1.mostrarInfo();
		DiscoDuro discoDuro2 = DiscoDuro.creaDiscoDuro();
		discoDuro2.mostrarInfo();
		// Procesador
		Procesador procesador1 = new Procesador("AMD", 16000);
		procesador1.mostrarInfo();
		Procesador procesador2 = new Procesador("INTEL", 32000);
		procesador2.mostrarInfo();
		// Generamos ordenadores
		Ordenador ordenador1 = new Ordenador(procesador1, discoDuro1, memoria1, 1200);
		ordenador1.mostrarInfo();
		Ordenador ordenador2 = new Ordenador(procesador2, discoDuro2, memoria2, 3400);
		ordenador2.mostrarInfo();
	}

}
