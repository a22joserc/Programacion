package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado miCuadrado=new Cuadrado(2.5,"azul");
		System.out.println("Lado de miCuadrado: "+ miCuadrado.getLado());
		Circulo miCirculo=new Circulo(3.6,"blanco");
		System.out.println("Color de miCirculo: "+ miCirculo.getColor());
	}

}
