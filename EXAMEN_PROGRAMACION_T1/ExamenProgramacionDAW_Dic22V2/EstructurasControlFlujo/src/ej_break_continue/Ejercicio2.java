package ej_break_continue;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12;
		int cifras = 0;
		while(num > 0 && cifras<5) {
			num/=10;
			cifras++;
			/*if(cifras==5) {
				break;
			}*/
		}
		if (cifras ==5) {
			 System.out.println("El número tiene 5 o más dígitos");
		}
		else {
			System.out.println("El número tiene menos de 5 dígitos");
		}
	}

}
