package random;
import java.util.Random;

public class DemoRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random numeroAleatorio= new Random();
		/*int aleatorio1= numeroAleatorio.nextInt();
		int aleatorio2=numeroAleatorio.nextInt();
		int aleatorio3=numeroAleatorio.nextInt();
		System.out.println("aleatorio1: " + aleatorio1);
		System.out.println("aleatorio2: " + aleatorio2);
		System.out.println("aleatorio3: " + aleatorio3);*/
		int jugada1= numeroAleatorio.nextInt(2);
		int jugada2=numeroAleatorio.nextInt(2);
		System.out.println("en la jugada1 salió "+ (jugada1==0?"cara":"cruz"));
		System.out.println("en la jugada2 salió "+ (jugada2==0?"cara":"cruz"));

	}

}
