package ejercicio1;

public class Principal {
	
	public static void main(String[] args) {
		
		Serie[] series = new Serie[4];
		
		series[0] = new MasDos();
		series[1] = new MasDos();
		series[1].establecerInicio(200);
		series[2] = new MasTres();
		series[3] = new MasTres();
		series[3].establecerInicio(300);
		
		int j=1;
		for (Serie serie:series) {
			System.out.println("Serie " + j);
			for(int i=0; i<5; i++) {
				System.out.print(serie.obtenerSiguiente() + " ");
				if (i==4) {
					System.out.println();
				}
			}
			j++;
			
		}
		
	}

}
