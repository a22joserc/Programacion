package ejemploserie;

public class MainMasTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MasDos ob2 = new MasDos();
        MasTres ob3 = new MasTres();

        System.out.println("De dos en dos ...");
        for(int i=0;i<5;i++) {
        	System.out.println("el siguiente valor es: "+ ob2.obtenerSiguiente());
        }

        System.out.println("De tres en tres ...");
        for(int i=0;i<5;i++) {
        	System.out.println("el siguiente valor es: "+ ob3.obtenerSiguiente());
        }
	}

}
