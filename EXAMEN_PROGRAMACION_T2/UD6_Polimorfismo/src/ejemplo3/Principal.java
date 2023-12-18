package ejemplo3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MiInterface tri = new Triangulo();
        MiInterface cua = new Cuadrado();
        tri.calcularArea();
        cua.calcularArea();*/
		
		MiInterface[] figuras = new MiInterface[2];
		figuras[0] = new Triangulo();
        figuras[1] = new Cuadrado();
        
        for(MiInterface figura:figuras) {
        	figura.calcularArea();
        }
        
        
		
		
	}

}
