package ejemplo1;

public class Main {
	
	public static void main(String[] args) {
        A a1 = new A(2);
        A a2;
        B b = new B(2,4);
        C c = new C(8);
        a2 = a1; //ningun problema, a2 y a1 son del mismo tipo
        //a2=c; // mal, a2 y c no son tipos compatibles
        a2=b; //bien, una referencia a superclase puede referenciar a un objeto subclase
        System.out.println(a2.a);//bien
        b.metodo();
        // System.out.println(a2.b); //mal, a2 sólo puede acceder a la parte de superclase
	}

}
