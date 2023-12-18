package ejercicio1;

public class DemoPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Número de objetos de la clase Punto " + Punto.numObjetos); 
		Punto p1 = new Punto(0,0);
		Punto p2 = new Punto(1,1);
		Punto p3 = new Punto(2,2);
		new Punto(4,2);	// Esto también se puede hacer	
		new Punto(5,2);
		new Punto(6,2);
		System.out.println("Número de objetos de la clase Punto " + Punto.numObjetos); 

	}

}
