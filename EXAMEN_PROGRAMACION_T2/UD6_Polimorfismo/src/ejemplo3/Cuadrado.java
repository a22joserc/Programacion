package ejemplo3;

public class Cuadrado implements MiInterface {
	
	int lado = 4;
    @Override
    public void calcularArea() {
        System.out.println(lado*lado);
    }
    @Override
    public void calcularPerimetro() {
    }

}
