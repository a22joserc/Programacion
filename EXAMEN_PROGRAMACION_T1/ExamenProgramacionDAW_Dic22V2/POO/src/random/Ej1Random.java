package random;
import java.util.Random;

public class Ej1Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rdm = new Random();
		int tirada1 = rdm.nextInt(6);
		tirada1 += 1;
		System.out.println("Tirada: " + tirada1);

	}

}
