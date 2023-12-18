package constructores;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*A obj_a = new A();
		B obj_b = new B();
		int suma = obj_a.sumar_b(obj_b);
		System.out.println(suma);*/
		
		A a = new A(20);
		B b = new B(5);
		System.out.println(a.sumar_b(b));

	}

}
