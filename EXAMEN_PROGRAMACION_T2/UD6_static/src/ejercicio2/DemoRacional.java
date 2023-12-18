package ejercicio2;

public class DemoRacional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Racional r1 =new Racional(3,4);
		Racional r2 =new Racional(1,2);
		Racional r3 =new Racional(1,1);
		r3.multiplicar(r1, r2);
		System.out.println("MUTIPLICACIÓN DE NÚMEROS RACIONALES");
		System.out.println("r1 vale: " + r1.numerador + "/" + r1.denominador);
		System.out.println("r2 vale: " + r2.numerador + "/" + r2.denominador);
		System.out.println("r3 vale: " + r3.numerador + "/" + r3.denominador);
		System.out.println("Aplicamos el método estático");
		Racional r4 = Racional.multiplicarSt(r1,r2);
		System.out.println("r4 vale: " + r4.numerador + "/" + r4.denominador);

	}

}
