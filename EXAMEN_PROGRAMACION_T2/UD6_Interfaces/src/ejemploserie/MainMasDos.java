package ejemploserie;

public class MainMasDos {
	
	public static void main(String[] args) {
		MasDos ob = new MasDos();
        for(int i=0;i<5;i++) {
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
        }
        System.out.println("restableciendo ...");
        ob.restablecer();
        for(int i=0;i<5;i++) {
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
        }
        System.out.println("empezando en 100 ...");
        ob.establecerInicio(100);
        for(int i=0;i<5;i++) {
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
        }
		
		
	}

}
