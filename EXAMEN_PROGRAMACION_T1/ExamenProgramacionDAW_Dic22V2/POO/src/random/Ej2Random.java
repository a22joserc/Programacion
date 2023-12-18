package random;
import java.util.Random;
import java.util.Scanner;

public class Ej2Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rdm = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Diga si salio cara o cruz : ");
		String usr = sc.nextLine();
		String mon_str;
		sc.close();
		int mon = rdm.nextInt(2);
		/*if (mon < 1) {
			mon_str = "cruz";
		}
		else {
			mon_str = "cara";
		}*/
		mon_str = mon < 1 ? "cruz":"cara";
		System.out.println(mon_str.equalsIgnoreCase(usr)?("¡Éxito! La moneda ha salido " + mon_str):("¡Fracaso! La moneda ha salido " + mon_str));
		
	}

}
