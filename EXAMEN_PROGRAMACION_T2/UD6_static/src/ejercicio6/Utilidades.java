package ejercicio6;

public class Utilidades {
	
	public static void imprimir(int i) {
		System.out.println(i);
	}
	
	public static void imprimir(double d) {
		System.out.println(d);
	}
	
	public static void imprimir(char c) {
		System.out.println(c);
	}
	
	public static void imprimir(String s) {
		System.out.println(s);
	}
	
	public char sumar(char c, int i) {
		int num = (int)c + i;
		return  (char)num;
	}
	
	public int sumar(int a, int b) {
		return a+b;
	}
	
	public String sumar(String s1, String s2) {
		return s1+s2;
	}

}
