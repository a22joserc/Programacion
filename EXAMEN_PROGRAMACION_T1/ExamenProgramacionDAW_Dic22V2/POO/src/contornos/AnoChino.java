package contornos;
import java.util.Scanner;

public class AnoChino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca su año de nacimiento: ");
		Scanner sc = new Scanner(System.in);
		int ano = sc.nextInt();
		sc.close();
		int resto = ano%12;
		switch (resto){
			case 0:
				System.out.println("Mono");
				break;
			case 1:
				System.out.println("Gallo");
				break;
			case 2:
				System.out.println("Perro");
				break;
			case 3:
				System.out.println("Cerdo");
				break;
			case 4:
				System.out.println("Rata");
				break;
			case 5:
				System.out.println("Buey");
				break;
			case 6:
				System.out.println("Tigre");
				break;
			case 7:
				System.out.println("Conejo");
				break;
			case 8:
				System.out.println("Dragón");
				break;
			case 9:
				System.out.println("Serpiente");
				break;
			case 10:
				System.out.println("Caballo");
				break;
			case 11:
				System.out.println("Cabra");
				break;
			
		}

	}

}
