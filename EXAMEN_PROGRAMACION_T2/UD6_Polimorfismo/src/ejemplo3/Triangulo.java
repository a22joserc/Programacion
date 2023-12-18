package ejemplo3;

public class Triangulo implements MiInterface{
	
	int base = 3;
    int altura = 5;
   
    @Override
    public void calcularArea() {
        System.out.println(base*altura);
    }
    @Override
    public void calcularPerimetro() {      
    }

}
